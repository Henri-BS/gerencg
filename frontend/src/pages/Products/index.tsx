import axios from "axios";
import Pagination from "components/Pagination";
import ProductCard from "components/ProductCard";
import { useEffect, useState } from "react";
import { Page } from "types/page";
import { PageProduct } from "types/product";
import { BASE_URL } from "utils/requests";

function ProductsList() {

    const[pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<PageProduct>({
        content: [],
        first: true,
        last: true,
        number: 0,
        totalPages: 0,
        totalElements: 0,
        numberOfElements: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/product/list?=${pageNumber}&size=10`)
            .then(response => {
                const data = response.data as PageProduct;
                setProductPage(data);
            });
    },  [pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }
    return (
        <>
 <div className="container">
                <div><Pagination 
                 page={productPage}
                 onPageChange={handlePageChange}/>
                 </div>
                <div className="list-container row">
                    {productPage.content?.map(product => (
                        <div key={product.id} className="col-sm-4 col-lg-4 col-xl-4 mb-3">
                            <ProductCard product={product} />
                        </div>
                    ))}
                </div>
            </div>
        </>
    );
}

export default ProductsList;