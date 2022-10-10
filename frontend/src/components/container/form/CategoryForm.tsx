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
                expense: expense,
                category: category
            },
        };
        axios(config).then(response => {
            setMsg("Registro Adcionado")
            navigate("/category-stats");
        }).catch(() => {
            setMsg("Erro")
        })
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
                        <button type="submit" className="gerencg-btn" >
                            Adicionar Produto
                        </button>
                    </div>

                </form>
                <Link to="/category-stats">
                    <h5 className=" form-links mt-5">Ir para a Lista de Registros</h5>
                </Link>
                 <div className="msg-container">
                    <h3>{msg}</h3>
                </div>
            </div>
        </div>
    );
}
