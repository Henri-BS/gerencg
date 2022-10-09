import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { CategoryPage } from "types/category";
import { CategoryStats } from "types/categoryStats";
import { BASE_URL } from "utils/requests";
import "./styles.css"

export function AddCategoryStats() {

    const navigate = useNavigate();
    const [stats, setStats] = useState<CategoryStats>()
    const [msg, setMsg] = useState('')

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

    const addProduct = () => {
        console.log("data", stats);
        const productData = {
            id: (stats?.id),
            registrationDate: stats?.registrationDate,
            addedProducts: stats?.addedProducts,
            removedProducts:    stats?.removedProducts,
            income: stats?.income,
            expense:  stats?.expense,
            category: stats?.category
        }
        axios.post(`${BASE_URL}/category-stats/add`, productData)
            .then((response) => {
                console.log("Adicionado com Sucesso")
                setStats(response.data);
                setMsg("Registro Adicionado")
            }).catch(() => {
                setMsg("Erro")
            })
    }

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const registrationDate = (event.target as any).registrationDate.value;
        const addedProducts = (event.target as any).addedProducts.value;
        const removedProducts = (event.target as any).removedProducts.value;
        const income = (event.target as any).income.value;
        const expense = (event.target as any).expense.value;
        const category = (event.target as any).category.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: "POST",
            url: "/category-stats/add",
            data: {
            registrationDate: registrationDate,   
            addedProducts: addedProducts,    
            removedProducts: removedProducts,
            income: income,
            expense:expense,
            category: category
            },
        };
        axios(config).then(response => {
            navigate("/category-stats");
        });
    };


    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Adicionar um Novo Produto</h3>
                <form className="gerencg-form" onSubmit={handleSubmit}>
                    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="registrationDate">Data de Registro: </label>
                        <input type="text" className="form-control" id="registrationDate" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="addedProducts">Produtos Adicionados: </label>
                        <input className="form-control" id="addedProducts" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="removedProducts">Produtos Removidos: </label>
                        <input type="number" className="form-control" id="removedProducts" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="income">Renda: </label>
                        <input type="text" className="form-control" id="income" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="expense">Despesas: </label>
                        <input className="form-control" id="expense" />
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
                        <button type="submit" className="gerencg-btn" onClick={() => addProduct()}>
                            Adicionar Produto
                        </button>
                    </div>
                    <Link className="form-btn-container" to="/category-stats">
                        <button className="btn gerencg-btn mt-3">Lista de Registros</button>
                    </Link>
                </form>

                <div className="msg-container">
                    <h3>{msg}</h3>
                </div>
            </div>
        </div>
    );
}
