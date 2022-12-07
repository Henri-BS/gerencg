import axios from "axios";
import { useEffect, useState } from "react";
import { CodePage } from "types/commission";
import { BASE_URL } from "utils/requests";
import * as FaIcons from 'react-icons/fa';
import "./styles.css";
import Pagination from "components/shared/Pagination";
import { CommissionCard } from "components/container/Card/CommissionCards";

export function CommissionCodeList() {
    const [value, setValue] = useState("");
    const [pageNumber, setPageNumber] = useState(0);
    const [codePage, setCodePage] = useState<CodePage>({
        content: [],
        number: 0,
        totalElements: 0,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/commission-list?code=${value}&page=${pageNumber}&sort=commissionDate,DESC`)
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
                        <h2 className="col-3 col-sm-4 col-md-4 col-xl-4">Lista de Pedidos</h2>
                        <nav className="option-item col-3 col-sm-4 col-md-4 col-xl-4">
                            <h5><b>Total:</b> {codePage.totalElements} Pedidos</h5>
                        </nav>
                        <form className="col-5 col-sm-4 col-md-4 col-xl-4 search-container">
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
                        {codePage.content?.filter((commission) =>
                            commission.code.includes(value))
                            .map((commission) => (
                                <div key={commission.code} className="col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 mb-3">
                                    <CommissionCard commission={commission} />
                                </div>
                            ))}
                    </div>
                </div>
            </div>
        </>
    );
}