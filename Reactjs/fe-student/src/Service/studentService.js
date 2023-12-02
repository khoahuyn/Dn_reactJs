import axios from "axios";

const URL = "http://localhost:8080/api/";

export const save = async (value) => {
    try {
        await axios.post(URL + "create-student", value)
    } catch (e) {
        console.log(e)
    }
}

