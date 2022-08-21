//Tabela de dados referente as categorias 
import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { StatsPage } from "types/categoryStats";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {

const [activePage, setActivePage] = useState(0);
    const [page, setPage] = useState<StatsPage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/category-stats/list?page=${activePage}&size=10&sort=registrationDate,desc`)
            .then(response => {
                setPage(response.data);
            });
    }, [activePage]);

const changePage = (index: number) => {
    setActivePage(index);
}

    return (
        <>
            <Pagination page ={page} onPageChange={changePage} />
            <div className="table-responsive">
                <table className="table table-striped table-sm table-dark">
                    <thead>
                        <tr>
                            <th>Data de Resgistro</th>
                            <th>Categoria</th>
                            <th>Produtos Adicionados</th>
                            <th>Produtos Removidos</th>
                            <th>Renda</th>
                            <th>Despesa</th>
                        </tr>
                    </thead>
                    <tbody>
                        {page.content?.map(item => (
                            <tr key={item.id}>
                                <td>{formatLocalDate(item.registrationDate, "dd/MM/yyyy")}</td>
                                <td>{item.category.name}</td>
                                <td>{item.addedProducts}</td>
                                <td>{item.removedProducts}</td>
                                <td>{item.income}</td>
                                <td>{item.expense}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default DataTable;