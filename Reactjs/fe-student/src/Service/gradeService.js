import axios from "axios";

const URL = "http://localhost:8080/api/get-all-grade";

export const findAllGrade = async () => {
    try {
        const res = await axios.get(URL);
        return res.data;
    } catch (e) {
        console.log(e);
    }
}


