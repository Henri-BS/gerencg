import moment from "moment";
import { Link } from "react-router-dom";
import { CategoryPage, CategoryProps } from "types/category";
import "./styles.css"
import { useEffect, useState } from "react";
import { BASE_URL } from "utils/requests";
import axios from "axios";

export function CategoryCard({ category }: CategoryProps) {

    return (
        <Link to={`/category/${category?.name}`}>
            <div className="category-display-card">
                <img className="category-card-image" src={category?.image} alt={category?.name} />
                <div className="category-card-container">
                    <h3><b>{category?.name}</b></h3>
                    <div className="category-details-container">
                        <h2>Atualizado em: {moment(category?.dateUpdated).format('DD/MM/YYYY, hh:mm')}</h2>
                    </div>
                </div>
            </div>
        </Link>
    );
}


export function GetLastCategoryCard() {

    const [categoryList, setCategoryList] = useState<CategoryPage>({ content: [], number: 0 });
    useEffect(() => {
        axios.get(`${BASE_URL}/category/list?size=1&sort=dateCreated,asc`)
            .then((response) => {
                setCategoryList(response.data);
            });
    }, []);


    return (
        <div>
            Última Categoria Adcionada:
            {categoryList.content?.map(x => (
                <CategoryCard category={x} />
            ))}
        </div>
    );
}
