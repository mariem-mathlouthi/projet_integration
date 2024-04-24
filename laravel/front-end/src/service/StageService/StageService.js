import axios from "axios";

export default {
    getAllStages() {
        return axios.get("http://localhost:8000/api/getAllStage");
    }
}
