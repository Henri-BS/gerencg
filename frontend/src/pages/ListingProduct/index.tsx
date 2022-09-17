import axios from "axios";
import Pagination from "components/shared/Pagination";
import { ProductCard, ProductHistoryCard, ProductValidateCard } from "components/container/ProductCards";
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
                <div className=" row">
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

//Find product uppdate history

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

//Find all products by category
type Category = {
    categoryId: string
}


export function ProductCategoryList({categoryId}: Category){

    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        number: 0,
        totalPages: 0,
        totalElements: 0,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/product/find-category/${categoryId}/?page=${pageNumber}&size=6`)
            .then(response => {
                const data = response.data as ProductPage;
                setProductPage(data);
            });
    }, [categoryId, pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <div className="container">
                <div className="header-container">
                    <h2>Produtos Catalogados</h2>                   
                </div>
                <div className="pagination-container-menu">
                    <div className="pagination-item">
                        <Pagination page={productPage}
                            onPageChange={handlePageChange} />
                    </div>
                </div>
                <div className="row">
                    {productPage.content?.map(product => (
                        <div key={product.category.name} className="  col-sm-12 col-lg-6 col-xl-6 mb-3">
                            <ProductCard product={product} />
                        </div>
                    ))}
                </div>
            </div>
        </>
    );
}

//Find all products by measure

type Measure = {
    measureId: string
}

export function ProductMeasureList({measureId}: Measure){
    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        first: true,
        last: true,
        number: 0,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/product/find-measure/${measureId}/?page=${pageNumber}`)
            .then(response => {
                const data = response.data as ProductPage;
                setProductPage(data);
            });
    }, [measureId, pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }
    return (
        <>
            <div className="container">
                <div className="header-container">
                    <h2>Produtos Medidos por: {measureId}</h2>                   
                </div>
                <div className="pagination-container-menu">
                    <div className="pagination-item">
                        <Pagination page={productPage}
                            onPageChange={handlePageChange} />
                    </div>
                </div>
                <div className="row">
                    {productPage.content?.map(product => (
                        <div key={product.measure.abbreviation} className="  col-sm-12 col-lg-6 col-xl-6 mb-3">
                            <ProductCard product={product} />
                        </div>
                    ))}
                </div>
            </div>
        </>
    );
}

//Find all products by validate
export function ProductValidateList() {

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
        axios.get(`${BASE_URL}/product/list?page=${pageNumber}&size=12&sort=validate`)
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
                    <h2>Próximos da data de validate</h2>
                </div>
                <div className="pagination-container-menu">
                    <div className="pagination-item">
                        <Pagination page={productPage}
                            onPageChange={handlePageChange} />
                    </div>
                </div>
                <div className=" row">
                    {productPage.content?.map(product => (
                        <div key={product.id} className="col-sm-6 col-lg-5 col-xl-4 mb-3">
                            <ProductValidateCard product={product} />
                        </div>
                    ))}
                </div>
            </div>
        </>
    );
}
