import axios from "axios";

export default {
    getAllOffre(){
        return axios.get("http://localhost:8000/api/getAllOffre");
    },
    getoffreById(id) {
        return axios.get(`http://localhost:8000/api/getoffreById/${id}`);

    },
    
    
}
