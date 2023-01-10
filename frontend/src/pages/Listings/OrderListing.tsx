import axios from "axios";
import { useEffect, useState } from "react";
import { CodePage, OrderStatsPage } from "types/order";
import { BASE_URL } from "utils/requests";
import * as FaIcons from 'react-icons/fa';
import "./styles.css";
import Pagination from "components/shared/Pagination";
import { CommissionCard, OrderStatsCard } from "components/container/Card/OrderCard";

export function OrderCodeList() {
    const [value, setValue] = useState("");
    const [pageNumber, setPageNumber] = useState(0);
    const [codePage, setCodePage] = useState<CodePage>({
        content: [],
        number: 0,
        totalElements: 0,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/order/list?code=${value}&page=${pageNumber}&size=21`)
            .then((response) => {
                setCodePage(response.data);
            });
    }, [value, pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <div>
                <div className="container">
                    <nav className="row header-container">
                        <h2 className="col-12 col-sm-4 col-md-4 col-xl-4">Lista de Pedidos</h2>
                        <nav className="option-item col-12 col-sm-4 col-md-4 col-xl-4">
                            <h5><b>Total:</b> {codePage.totalElements} Pedidos</h5>
                        </nav>
                        <form className="col-12 col-sm-4 col-md-4 col-xl-4 search-container">
                            <label>
                                <h5><FaIcons.FaSearch /></h5>
                            </label>
                            <div className="form-group search-form-group">
                                <input
                                    type="text"
                                    value={value}
                                    onChange={(e) => setValue(e.target.value)}
                                    className="form-control"
                                    id="value"
                                    placeholder="Buscar pelo código do pedido..."
                                />
                            </div>
                        </form>
                    </nav>

                    <div className="pagination-container-menu">
                        <div className="pagination-item">
                            <Pagination page={codePage} onPageChange={handlePageChange} />
                        </div>
                    </div>

                    <div className="row">
                        {codePage.content?.filter((order) =>
                            order.code.includes(value))
                            .map((order) => (
                                <div key={order.code} className="col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 mb-3">
                                    <CommissionCard order={order} />
                                </div>
                            ))}
                    </div>
                </div>
            </div>
        </>
    );
}

export function OrderStatsList() {
    const [statsPage, setStatsPage] = useState<OrderStatsPage>({
        content: [],
        number: 0,
        totalElements: 0,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/page?size=12&sort=initialDate,desc`)
            .then((response) => {
                setStatsPage(response.data);
            });
    }, []);

    return (
        <div className="row p-20">
            {statsPage.content?.map((x) => (
                <div key={x.id} className="col-4 col-sm-3 col-md-2 col-lg-1 col-xl-1">
                    <OrderStatsCard stats={x} />
                </div>
            ))}
        </div>
    );
}