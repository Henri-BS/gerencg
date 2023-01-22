import axios from "axios";
import Pagination from "components/shared/Pagination";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { ProductHistoryPage } from "types/product";
import { BASE_URL } from "utils/requests";

function ProductDataTable() {
    const [pageNumber, setPageNumber] = useState(0);
    const [page, setPage] = useState<ProductHistoryPage>({
        content: [],
        number: 0,
        size: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/history/list?page=${pageNumber}&size=12&sort=createdDate`)
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
                <Pagination page={page} onPageChange={handlePageChange} />
            </div>
            <div className="table-responsive">
                <table className="table border-table">
                    <thead className="bg-primary text-primary">
                        <tr>
                            <th className="table-box"><h5>Id</h5></th>
                            <th className="table-box"><h5>Data de Registro</h5></th>
                            <th className="table-box"><h5>Quantidade</h5></th>
                            <th className="table-box"><h5>Preço</h5></th>
                            <th className="table-box"><h5>Validade</h5></th>
                        </tr>
                    </thead>
                    <tbody className="border-0">
                        {page.content?.map(item => (
                            <tr key={item.id}>
                                <Link to={`/product/${item.productId}`} className="table-box-title">
                                    <h5>{item.productId}</h5>
                                </Link>
                                <td className="table-box">{moment(item.createdDate).format("DD/MM/YYYY")}</td>
                                <td className="table-box">{item.quantity}</td>
                                <td className="table-box">{item.price}</td>
                                <td className="table-box">{moment(item.validate).format("DD/MM/YYYY")}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default ProductDataTable;