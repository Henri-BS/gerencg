import axios from "axios";
import { MeasureCard } from "components/card/MeasureCard";
import { ProductCard } from "components/card/ProductCard";
import Pagination from "components/shared/Pagination";
import { useEffect, useState } from "react";
import { MeasurePage } from "types/measure";
import { Props } from "types/page";
import { ProductPage } from "types/product";
import { BASE_URL } from "utils/requests";

export function MeasureList() {

    const [pageNumber, setPageNumber] = useState(0);

    const [measureList, setTagList] = useState<MeasurePage>({ content: [], number: 0 });
    useEffect(() => {
        axios.get(`${BASE_URL}/measure/list?page=${pageNumber}&size=15&sort=abbreviation,ASC`)
            .then((response) => {
                setTagList(response.data);
            });
    }, [pageNumber]);

    const handlePage = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <Pagination page={measureList} onPageChange={handlePage} />
            <div className="row p-2">
                {measureList.content?.map(x => (
                    <div key={x.abbreviation} className="col-4 p-1">
                        <MeasureCard measure={x} />
                    </div>
                ))}
            </div>
        </>
    );
}

export function ProductMeasureList({ id: measureId }: Props) {
    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({ content: [], number: 0 });

    useEffect(() => {
        axios.get(`${BASE_URL}/product/measure/${measureId}?page=${pageNumber}`)
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
                        <Pagination page={productPage} onPageChange={handlePageChange} />
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
