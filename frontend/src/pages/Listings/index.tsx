import axios from "axios";
import Pagination from "components/shared/Pagination";
import { ProductCard, ProductHistoryCard, ProductValidateCard } from "components/container/Card/ProductCard";
import { useEffect, useState } from "react";
import { ProductPage } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css"
import { ProductHistoryPage } from "types/productHistory";
import * as FaIcons from 'react-icons/fa'
import { CategoryPage, CategoryProps } from "types/category";
import CategoryCard from "components/container/Card/CategoryCard";
import { MeasurePage, MeasureProps } from "types/measure";
import { MeasureCard } from "components/container/Card/MeasureCard";
import "react-datepicker/dist/react-datepicker.css";
import ReactDatePicker from "react-datepicker";
//Product list with description filter 

export function ProductsList() {
    const [value, setValue] = useState("");
    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        number: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/product/search?description=${value}&size=21&page=${pageNumber}`)
            .then(response => {
                setProductPage(response.data);
            });
    }, [value, pageNumber]);


    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <div className="container">
                <nav className="row header-container">
                    <h2 className="col-3 col-sm-4 col-md-4 col-xl-4 ">Lista de Produtos</h2>

                    <nav className="col-4 col-sm-4 col-md-4 col-xl-3" >
                        <div className="option-item" >
                            <h5><b>Total: </b>{productPage.totalElements} Produtos</h5>
                        </div>
                    </nav>

                    <form className="col-5 col-sm-4 col-md-4  col-xl-5 search-container">
                        <label className="form-group" >
                            <FaIcons.FaSearch />
                        </label>
                        <div className="form-group search-form-group">
                            <input
                                type="text"
                                value={value}
                                onChange={(e) => setValue(e.target.value)}
                                className="form-control"
                                id="value"
                                placeholder="Buscar produto..."
                            />
                        </div>
                    </form>
                </nav>

                <div className="pagination-container-menu">
                    <div className="pagination-item">

                        <Pagination
                            page={productPage}
                            onPageChange={handlePageChange}
                        />
                    </div>
                </div>

                <div className=" row ">
                    {productPage.content?.filter((product) =>
                        product.description.includes(value))
                        .map((product) => (
                            <div
                                key={product.id}
                                className="col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 mb-3">
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
            <div className="container ">
                <div className="header-container ">
                    <h4>Histórico de Alterações:</h4>
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
export function ProductCategoryList({ categoryId }: CategoryProps) {

    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        number: 0
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
export function ProductMeasureList({ measureId }: MeasureProps) {
    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        number: 0
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

    const min = new Date(new Date().setDate(new Date().getDate() - 7))
    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(new Date());
    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        number: 0
    });

    useEffect(() => {
        axios.get(
            `${BASE_URL}/product/validate?
            minDate=2022-01-01&maxDate=2022-06-31
            &page=${pageNumber}&size=12&sort=quantity`
        )
            .then(response => {
                setProductPage(response.data);
            });
    }, [pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <div className="container">

                <nav className="row header-container">
                    <h2 className="col-12 col-sm-3 col-md-3 border-0">Próximos da data de validade</h2>

                    <form className="col-12 col-sm-4 col-md-4 search-container">
                        <label className="form-group" >
                            <FaIcons.FaSearch />
                        </label>
                        <div className="form-group search-form-group">
                            <ReactDatePicker
                                selected={minDate}
                                onChange={(date: Date) => setMinDate(date)}
                                className="form-control"
                                dateFormat="dd/MM/yyyy"
                            />
                        </div>
                    </form>

                    <form className="col-12 col-sm-4 col-md-4 search-container">
                        <label className="form-group" >
                            <FaIcons.FaSearch />
                        </label>
                        <div className="form-group search-form-group">
                            <ReactDatePicker
                                selected={maxDate}
                                onChange={(date: Date) => setMaxDate(date)}
                                className="form-control"
                                dateFormat="dd/MM/yyyy"
                            />
                        </div>
                    </form>
                </nav>

                <div className="pagination-container-menu">
                    <div className="pagination-item">
                        <Pagination
                            page={productPage}
                            onPageChange={handlePageChange}
                        />
                    </div>
                </div>
                <div className=" row">
                    {productPage.content?.filter((product) =>
                        product.description.includes("")).map(product => (
                            <div key={product.id} className="col-sm-6 col-lg-5 col-xl-4 mb-3">
                                <ProductValidateCard product={product} />
                            </div>
                        ))}
                </div>
            </div>
        </>
    );
}

export function CategoryList() {

    const [categoryPage, setCategoryPage] = useState<CategoryPage>({
        content: [],
        number: 0,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/category/list?page=0&size=10`)
            .then(response => {
                const data = response.data as CategoryPage;
                setCategoryPage(data);
            })
    }, []);

    return (
        <>
            <div className="container">
                <div className="header-container">
                    <h2>Lista de Categorias</h2>
                </div>
                <div className="page-container">
                    <div className="list-container row">
                        {categoryPage.content?.map(category => (
                            <div key={category.name} className="col-sm-12 mb-3">
                                <CategoryCard category={category} />
                            </div>
                        ))}
                    </div>

                </div>
            </div>
        </>
    );
}

export function MeasureList() {

    const [measurePage, setMeasurePage] = useState<MeasurePage>({
        content: [],
        number: 0,
        totalElements: 0,
        totalPages: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/measure/list?size=30`)
            .then(response => {
                setMeasurePage(response.data);
            });
    }, []);

    return (
        <>
            <div className="container">
                <div className="header-container">
                    <h2>Lista de Medidas</h2>
                </div>
                <div className=" row">
                    {measurePage.content?.map(measure => (
                        <div key={measure.abbreviation} className="col-12 col-md-6 col-xl-4 mb-3">
                            <MeasureCard measure={measure} />
                        </div>
                    ))}
                </div>
            </div>
        </>
    );
}

