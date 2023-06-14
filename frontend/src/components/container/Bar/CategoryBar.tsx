import axios from "axios";
import moment from 'moment';
import { useEffect, useState } from "react";
import { BASE_URL } from "utils/requests";
import { Category, CategoryProps, CategoryStats } from "types/category";
import { categoryIcons } from "components/shared/MenuIcons";
import "./styles.css";

export function CategorySideBar({ categoryId }: CategoryProps) {

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
                    <div className="column-item-container">
                        <div className="column-icon-container">{categoryIcons.createdDateIcon}</div>
                        <h3>Data de Criação: {moment(category?.createdDate).format('DD/MM/YYYY')}</h3>
                    </div>
                </div>
                
                <div className="column-card-bottom">
                    <h4>Última Alteração: {moment(category?.lastModifiedDate).format('DD/MM/YYYY')} </h4>
                </div>
            </div>
        </>
    );
}

export function CategoryStatsMenuBar({ categoryId }: CategoryProps) {
    const [categoryStats, setCategoryStats] = useState<CategoryStats>();

    useEffect(() => {
        axios.get(`${BASE_URL}/category-stats/${categoryId}`)
            .then((response) => {
                setCategoryStats(response.data);
            })
    }, [categoryId])

    useEffect(() => {
        axios.put(`${BASE_URL}/category-stats/update/${categoryId}`)
            .then((response) => {
                setCategoryStats(response.data);
            })
    }, [categoryId])

    return ( 
        <div className="row">
            <h3 className="text-center">Informações de Produtos da Categoria</h3>
            <div className="bar-item col-12 col-md-12 col-lg-6">
                <div className="bar-item-content"><b>Unidades de Produtos</b> {categoryStats?.addedProducts}</div>
            </div>
            <div className="bar-item col-12 col-md-12 col-lg-6">
                <div className="bar-item-content"><b>Expectativa de Renda</b> {categoryStats?.income.toFixed(2)}</div>
            </div>
        </div>
    )
}