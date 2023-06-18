import axios, { AxiosRequestConfig } from "axios";
import { useNavigate } from "react-router-dom";
import { BASE_URL } from "utils/requests";

export function MeasureAddForm() {
    const navigate = useNavigate();

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const abbreviation = (event.target as any).abbreviation.value;
        const description = (event.target as any).description.value;

        const config: AxiosRequestConfig = {
            method: "POST",
            baseURL: BASE_URL,
            url: `/measure/add`,
            data: {
                abbreviation: abbreviation,
                description: description
            }
        }

        axios(config).then((response) => {
            navigate(`/`)
        })

    }
    return (
        <form className="form-card-container" onSubmit={handleSubmit}>
            <div className="form-group gerencg-form-group">
                <input id="abbreviation" className="form-control" type="text" placeholder="abreviação" />
            </div>
            <div className="form-group gerencg-form-group">
                <input id="description" className="form-control" type="text" placeholder="nome completo da medida" />
            </div>
            <button type="submit" className="btn btn-confirm m-2 p-2">Adicionar</button>
        </form>
    );
}