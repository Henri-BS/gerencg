import axios from "axios";
import CategoryCard from "components/container/CategoryCard";
import { useEffect, useState } from "react";
import { CategoryPage } from "types/category";
import { BASE_URL } from "utils/requests";

function CategoryList() {


    const [categoryPage, setCategoryPage] = useState<CategoryPage>({
        content: [],      
        first: true,
        last: true,
        totalElements: 0,
        totalPages: 0,
        number: 0,
        numberOfElements: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/category/list?page=0&size=10`)
            .then(response => {
                const data = response.data as CategoryPage;
                setCategoryPage(data);
            })
    }, []);

    return(
        <>
            <div className="container">
                <div className="header-container">             
                <h2>Lista de Categorias</h2>
                </div>
          <div className="page-container">
                <div className="list-container row">
                    {categoryPage.content?.map(category => (
                        <div key={category.id} className="col-sm-12 mb-3">
                            <CategoryCard category={category} />
                        </div>
                    ))}
                </div>
   
            </div>
            </div>
        </>    
        );
}
export default CategoryList;