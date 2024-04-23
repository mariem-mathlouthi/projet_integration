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


    
    
}
