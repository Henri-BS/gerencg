import axios from "axios";
import Pagination from "components/shared/Pagination";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { StatsPage } from "types/categoryStats";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";
import "./styles.css"

function DataTable() {

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
            <div className="pagination-container-menu">
                <Pagination
                    page={page}
                    onPageChange={changePage}
                />
            </div>
            <div className="table-responsive">
                <table className="table ">
                    <thead>
                        <tr className="striped-rows">
                            <th className="table-box-title border-0">Categoria</th>
                            <th className="table-box">Data de Resgistro</th>
                            <th className="table-box">Produtos Adicionados</th>
                            <th className="table-box">Produtos Removidos</th>
                            <th className="table-box">Renda</th>
                            <th className="table-box">Despesa</th>
                        </tr>
                    </thead>
                    <tbody className="border-0">
                        {page.content?.map(item => (
                            <tr key={item.id}>

                                <Link
                                    to={`/category/${item.category.name}`}
                                    className="table-box-title">
                                    {item.category.name}
                                </Link>

                                <td className="table-box">{formatLocalDate(item.registrationDate, "dd/MM/yyyy")}</td>
                                <td className="table-box">{item.addedProducts}</td>
                                <td className="table-box">{item.removedProducts}</td>
                                <td className="table-box">{item.income}</td>
                                <td className="table-box">{item.expense}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default DataTable;