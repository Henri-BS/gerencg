import axios from "axios";
import Pagination from "components/shared/Pagination";
import { ProductCard, ProductHistoryCard } from "components/container/ProductCards";
import { useEffect, useState } from "react";
import { ProductPage } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css"
import { Link } from "react-router-dom";
import { ProductHistoryPage } from "types/productHistory";

export function ProductsList() {

    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        first: true,
        last: true,
        number: 0,
        totalPages: 0,
        totalElements: 0,
        numberOfElements: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/product/list?page=${pageNumber}&size=12`)
            .then(response => {
                const data = response.data as ProductPage;
                setProductPage(data);
            });
    }, [pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }
    return (
        <>
            <div className="container">
                <div className="header-container">
                    <h2>Lista de Produtos</h2>
                    <Link className="gerencg-btn-sec-container" to="/product/add">
                        <button className="gerencg-btn-sec">
                            <h3>Adicionar</h3>
                        </button>
                    </Link>
                </div>
                <div className="pagination-container-menu">
                    <div className="pagination-item">
                        <Pagination page={productPage}
                            onPageChange={handlePageChange} />
                    </div>
                </div>
                <div className="list-container row">
                    {productPage.content?.map(product => (
                        <div key={product.id} className="col-sm-6 col-lg-5 col-xl-4 mb-3">
                            <ProductCard product={product} />
                        </div>
                    ))}
                </div>
            </div>
        </>
    );
}

export function ProductHistoryList() {
    const [historyPage, setHistoryPage] = useState<ProductHistoryPage>({
        content: [],
        size: 10
    })

    useEffect(() => {
        axios.get(`${BASE_URL}/history/list`)
            .then((response) => {
                setHistoryPage(response.data);
            })
    }, [])


    return (
        <>
            <div className="pagination-max-container ">
                <div className="header-container ">
                    <h3>Histórico de Alterações:</h3>
                </div>
                <div className="row m-0">
                    {historyPage.content?.map(history => (
                        <div key={history.id} className="col-sm-12 col-lg-6 col-xl-6 mb-3">
                            <ProductHistoryCard history={history} />
                        </div>
                    ))}
                </div>
            </div>
        </>
    );
}
