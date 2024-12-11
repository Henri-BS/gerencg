import axios from "axios";
import moment from 'moment';
import { useEffect, useState } from "react";
import { BASE_URL } from "utils/requests";
import { Category, CategoryStats } from "types/category";
import { categoryIcons } from "components/shared/MenuIcons";
import { Props } from "types/page";

export function CategorySideBar({ id: categoryId }: Props) {

    const [category, setCategory] = useState<Category>()
    useEffect(() => {
        axios.get(`${BASE_URL}/category/${categoryId}`)
            .then(response => {
                setCategory(response.data);
            });
    }, [categoryId]);

    return (
        <>
            {category == null ? "" :
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
                        <div className="column-item-container">
                            <div className="column-icon-container">{categoryIcons.createdDateIcon}</div>
                            <h3>Data de Criação: {moment(category?.dateCreated).format('DD/MM/YYYY')}</h3>
                        </div>
                    </div>

                    <div className="column-card-bottom">
                        <h4>Última Alteração: {moment(category?.dateUpdated).format('DD/MM/YYYY')} </h4>
                    </div>
                </div>
            }
        </>
    );
}

