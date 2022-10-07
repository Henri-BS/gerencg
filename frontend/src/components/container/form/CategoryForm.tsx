import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { CategoryPage } from "types/category";
import { CategoryStats } from "types/categoryStats";
import { BASE_URL } from "utils/requests";
import "./styles.css"



export function AddCategoryStats() {

    //Get CategoryList for the category selector    
    const [categoryList, setCategoryList] = useState<CategoryPage>({
        content: [],
        number: 0
    })
    useEffect(() => {
        axios.get(`${BASE_URL}/category/list`)
            .then((response) => {
                setCategoryList(response.data);
            })
    }, [])
    
    const navigate = useNavigate();
    const [categoryStats, setCategoryStats] = useState<CategoryStats>()
    const [msg, setMsg] = useState('')

    
    const AddCategoryStats = () => {
        console.log("data", categoryStats);
        const categoryStatsData = {
            id: (categoryStats?.id),
            registrationDate: categoryStats?.registrationDate,
            addedProducts: categoryStats?.addedProducts,
            removedProducts: categoryStats?.removedProducts,
            income: categoryStats?.income,
            expense: categoryStats?.expense,
            category: categoryStats?.category
        }
        axios.post(`${BASE_URL}/category-stats/add`, categoryStatsData)
            .then((response) => {
                console.log("Adicionado com Sucesso")
                setCategoryStats(response.data);
                setMsg("Produto Adicionado")
            }).catch(() => {
                setMsg("Erro")
            })
    }

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const registrationDate = (event.target as any).registrationDate.value;
        const addedProducts = (event.target as any).image.value;
        const removedProducts = (event.target as any).removedProducts.value;
        const income = (event.target as any).income.value;
        const expense = (event.target as any).expense.value;
        const category = (event.target as any).category.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: "POST",
            url: "/category-list/add",
            data: {
                registrationDate: registrationDate,
                addedProducts: addedProducts,
                removedProducts: removedProducts,
                income: income,
                expense: expense,
                category: category
            },
        };
        axios(config).then((response) => {
            navigate("/category-stats/list");
        });
    };


    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Adicionar um Novo Registro de Categoria</h3>

                <form className="gerencg-form" onSubmit={handleSubmit}>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="registrationDate">Data de Registro: </label>
                        <input type="text" className="form-control" id="registrationDate" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="addedProducts">Produtos Adicionados: </label>
                        <input type="text" className="form-control" id="addedProducts" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="removedProducts">Produtos Removidos: </label>
                        <input className="form-control" id="removedProducts" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="income">Renda: </label>
                        <input type="number" className="form-control" id="income" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="expense">Despesa: </label>
                        <input type="text" className="form-control" id="expense" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="category">Categoria: </label>
                        <select className="form-control" id="category">
                            {categoryList.content?.map(item => (
                                <option key={item.name}>
                                    {item.name}
                                </option>
                            ))}
                        </select>
                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className="gerencg-btn" onClick={() => AddCategoryStats()}>
                            Adicionar Registro
                        </button>
                    </div>
                    <Link className="form-btn-container" to="/category-stats">
                        <button className="btn gerencg-btn mt-3">Lista de Registros</button>
                    </Link>
                    <Link className="form-btn-container" to="/">
                        <button className="btn gerencg-btn mt-3">Retornar</button>
                    </Link>
                    

                </form>

                <div className="msg-container">
                    <h3>{msg}</h3>
                </div>
            </div>
        </div>
    );
}
