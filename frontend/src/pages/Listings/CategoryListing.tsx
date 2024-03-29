import axios from "axios";
import {CategoryCard} from "components/container/Card/CategoryCard";
import { ProductCard } from "components/container/Card/ProductCard";
import Pagination from "components/shared/Pagination";
import { useEffect, useState } from "react";
import { CategoryPage } from "types/category";
import { Props } from "types/page";
import { ProductPage } from "types/product";
import { BASE_URL } from "utils/requests";

export function CategoryList() {

    const [categoryPage, setCategoryPage] = useState<CategoryPage>({
        content: [],
        number: 0,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/category/list?page=0&size=10`)
            .then(response => {
                setCategoryPage(response.data);
            })
    }, []);

    return (
        <>
            <div className="container">
                <div className="header-container">
                    <h2>Lista de Categorias</h2>
                </div>
                    <div className="list-container row">
                        {categoryPage.content?.map(category => (
                            <div key={category.name} className="col-12 col-md-6 mb-3">
                                <CategoryCard category={category} />
                            </div>
                        ))}
                </div>
            </div>
        </>
    );
}

export function ProductCategoryList({ id: categoryId }: Props) {

    const [pageNumber, setPageNumber] = useState(0);
    const [productPage, setProductPage] = useState<ProductPage>({ content: [], number: 0});

    useEffect(() => {
        axios.get(`${BASE_URL}/product/category/${categoryId}/?page=${pageNumber}&size=6`)
            .then(response => {
                setProductPage(response.data);
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
                        <div key={product.category.name} className="col-sm-12 col-lg-6 col-xl-6 mb-3">
                            <ProductCard product={product} />
                        </div>
                    ))}
                </div>
            </div>

        </>
    );
}
