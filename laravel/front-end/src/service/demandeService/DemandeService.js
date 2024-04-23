
import axios from "axios";

export default {
    addDemande(res){
    let data =new FormData();
    data.append('idEtudiant',res.idEtudiant);
    data.append('idOffreDeStage',res.idOffreDeStage);
    data.append('statut',res.statut);
    data.append('DateSoumission',res.DateSoumission);
    data.append('cv',res.cv);
    const config={
        Headers:{
            "content-Type":'multipart/form-data',
        },
    };
    return axios.post('http://localhost:8000/api/getAllOffre',data,config);
},
}