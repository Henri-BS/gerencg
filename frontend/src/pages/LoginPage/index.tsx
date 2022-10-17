import axios, { AxiosRequestConfig } from "axios";
import {useState} from "react";
import { BASE_URL } from "utils/requests";

export function Login(){

    const [values, setValues] = useState({
userName: "",
password: ""
    })

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const userName = (event.target as any).userName.value;
        const password = (event.target as any).password.value;

const config: AxiosRequestConfig = {
    baseURL: BASE_URL,
    method: "POST",
    url: "/user-login",
    data: {
        userName: userName,
        password: password
    },

};
axios(config).then((response) => {
    
})
}
    return(
        <div></div>
    );
}