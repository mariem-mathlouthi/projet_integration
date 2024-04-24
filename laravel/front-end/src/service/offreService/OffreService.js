import axios from "axios";

export default {
    getAllOffre(){
        return axios.get("http://localhost:8000/api/getAllOffre");
    },
    getoffreById(id) {
        return axios.get(`http://localhost:8000/api/getoffreById/${id}`);

    },
    AddOffre(res){
        let data =new FormData();
        data.append('photo',res.photo);
        data.append('description',res.description);
        const config={
            Headers:{
                "content-Type":'multipart/form-data',
            },
        };
        return axios.post('http://localhost:8000/api/getAllOffre',data,config);
    },

    searchOffre(key,searchValue) {
        if (searchValue == "" || key == "") {
            return axios.get("http://localhost:8000/api/offre/all/all/all/all");
        };
        switch (key) {
            case "title":
                return axios.get("http://localhost:8000/api/offre/all/all/all/" + searchValue);
            case "description":
                return axios.get("http://localhost:8000/api/offre/all/all/"+ searchValue + "/all");
            case "company":
                return axios.get("http://localhost:8000/api/offre/" + searchValue + "/all/all/all");
        }
    },  
    
}
