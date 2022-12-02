import axios from "axios";
import moment from 'moment';
import { useEffect, useState } from "react";
import { BASE_URL } from "utils/requests";
import { Category, CategoryProps } from "types/category";
import { categoryIcons } from "components/shared/MenuIcons";

function CategorySideBar({ categoryId }: CategoryProps) {

    const [category, setCategory] = useState<Category>()

    useEffect(() => {
        axios.get(`${BASE_URL}/category/${categoryId}`)
            .then(response => {
                setCategory(response.data);
            });
    }, [categoryId]);

    return (
        <>
            <div className="max-sidebar-container">
                <div className="column-container">
                    <div className="column-image-container">
                        <img className="column-card-image" src={category?.image} alt={category?.name} />
                    </div>
                    <h1>{category?.name}</h1>

                    <div className="column-item-container">
                        <div className="column-icon-container">{categoryIcons.totalProductsIcon}</div>
                        <h3>Total de Produtos: {category?.totalProducts} </h3>
                    </div>
                    <div className="column-item-container">
                        <div className="column-icon-container">{categoryIcons.totalRegistersIcon}</div>
                        <h3>Total de Registros: {category?.totalRegisters}</h3>
                    </div>
                </div>
                <div className="column-card-bottom">
                    <h4>Última Alteração: {moment(category?.lastModifiedDate).format('DD/MM/YYYY')} </h4>
                </div>
            </div>
        </>
    );
}

export default CategorySideBar;