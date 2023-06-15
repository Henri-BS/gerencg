import axios from "axios";
import { MeasureCard } from "components/container/Card/MeasureCard";
import { ProductCard } from "components/container/Card/ProductCard";
import Pagination from "components/shared/Pagination";
import { useEffect, useState } from "react";
import { MeasurePage } from "types/measure";
import { Props } from "types/page";
import { ProductPage } from "types/product";
import { BASE_URL } from "utils/requests";

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

export function ProductMeasureList({ id: measureId }: Props) {
    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        number: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/find-products-by-measure/${measureId}/?page=${pageNumber}`)
            .then(response => {
                setProductPage(response.data);
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
                        <Pagination page={productPage} onPageChange={handlePageChange} />
                    </div>
                </div>
                <div className="row">
                    {productPage.content?.map(product => (
                        <div key={product.measure.abbreviation} className="col-sm-12 col-lg-6 col-xl-6 mb-3">
                            <ProductCard product={product} />
                        </div>
                    ))}
                </div>
            </div>
        </>
    );
}
