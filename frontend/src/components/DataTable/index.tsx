import axios from "axios";
import { useEffect, useState } from "react";
import { DetailPage } from "types/detail";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {

    const [page, setPage] = useState <DetailPage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/details?page=0&size=20&sort=date,desc`)
        .then(response => {
            setPage(response.data);
        });
    },[]);

    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data de Resgistro</th>
                        <th>Categoria</th>
                        <th>Produtos Adicionados</th>
                        <th>Produtos Removidos</th>
                        <th>Valor Atual</th>
                    </tr>
                </thead>
                <tbody>
                    {page.content?.map(item => (
                        <tr key={item.id}>
                        <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                        <td>{item.category.name}</td>
                        <td>{item.prod_adc}</td>
                        <td>{item.prod_remov}</td>
                        <td>{item.upd_val}</td>
                    </tr> 
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default DataTable;