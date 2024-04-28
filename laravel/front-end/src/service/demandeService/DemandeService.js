
import axios from "axios";

export default {
 addDemande(res){
    let data =new FormData();
    data.append('description',res.description);
    data.append('idEtudiant',res.idEtudiant);
    data.append('idOffreDeStage',res.idOffreDeStage);
    data.append('status',res.status);
    data.append('DateSoumission',res.DateSoumission);
    data.append('file',res.cv); // used by uploadFile function
    data.append('filetype', 'pdf'); // used by uploadFile function
    const config={
        Headers:{
            "content-Type":'multipart/form-data',
        },
    };
    const uploadCV = axios.post('http://localhost:8000/api/uploadfile',data,config),
          addDemande = axios.post('http://localhost:8000/api/addDemande',data,config);
    return Promise.all([uploadCV, addDemande]); // send requests in parallele
 },
 
 getIdEtudiant(email) {
    return axios.get("http://localhost:8000/api/getuseridbyemail/" + email);
 }
}