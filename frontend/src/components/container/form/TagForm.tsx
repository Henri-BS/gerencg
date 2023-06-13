import axios, { AxiosRequestConfig } from "axios";
import { useNavigate } from "react-router-dom";
import { BASE_URL } from "utils/requests";

export function TagAddForm() {

    const navigate = useNavigate();
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const tagId = (event.target as any).tagId.value;
        const description = (event.target as any).description.value;

        const config: AxiosRequestConfig = {
            method: "POST",
            baseURL: BASE_URL,
            url: "/tag/add",
            data: {
                tagId: tagId,
                description: description
            }
        }
        axios(config).then((response) => {
            navigate("/");
        })
    }

    return (
        <form className="form-card-container" onSubmit={handleSubmit}>
            <div className="form-group gerencg-form-group">
                <input id="tagId" className="form-control" type="text" placeholder="nome da tag" />
            </div>
            <div className="form-group gerencg-form-group">
                <input id="description" className="form-control" type="text" placeholder="descrição (opcional)" />
            </div>
            <button type="submit" className="btn btn-confirm m-2 p-2">Adicionar</button>
        </form>
    );
}