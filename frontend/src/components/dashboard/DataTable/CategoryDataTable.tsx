import axios from "axios";
import Pagination from "components/shared/Pagination";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { StatsPage } from "types/categoryStats";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";
import "./styles.css"

function CategoryDataTable() {

    const [pageNumber, setPageNumber] = useState(0);
    const [page, setPage] = useState<StatsPage>({
        number: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/category-stats/list?page=${pageNumber}&size=10&sort=registrationDate,desc`)
            .then((response) => {
                setPage(response.data);
            });
    }, [pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <div className="pagination-container-menu">
                <Pagination
                    page={page}
                    onPageChange={handlePageChange}
                />
            </div>
            
            <div className="table-responsive ">
                <table className="table border-table">
                    <thead className="bg-primary text-primary">
                        <tr>
                            <th className="table-box "><h5>Categoria</h5></th>
                            <th className="table-box"><h5>Data de Resgistro</h5></th>
                            <th className="table-box "><h5>Produtos Adicionados</h5></th>
                            <th className="table-box "><h5>Produtos Removidos</h5></th>
                            <th className="table-box "><h5>Renda</h5></th>
                            <th className="table-box "><h5>Despesa</h5></th>
                        </tr>
                    </thead>
                    <tbody className="border-0">
                        {page.content?.map(item => (
                            <tr key={item.id}>

                                <Link to={`/category/${item.category.name}`} className="table-box-title">
                                   <h5>{item.category.name}</h5>
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

export default CategoryDataTable;