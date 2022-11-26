import axios from "axios";
import { MeasureCard } from "components/container/Card/MeasureCard";
import { ProductCard } from "components/container/Card/ProductCard";
import Pagination from "components/shared/Pagination";
import { useEffect, useState } from "react";
import { MeasurePage, MeasureProps } from "types/measure";
import { ProductPage } from "types/product";
import { BASE_URL } from "utils/requests";

//Find all measures
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

//Filter products by measure
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
