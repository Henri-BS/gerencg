import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { CategoryPage } from "types/category";
import { BASE_URL } from "utils/requests";
import "./styles.css"

export function CategoryAddForm(){
    const navigate = useNavigate();

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const name = (event.target as any).name.value;
        const image = (event.target as any).image.value;
        
        const config: AxiosRequestConfig = {
        method: "POST",
        baseURL: BASE_URL,
        url: "/category/add",
        data: {
            name: name,
            image: image
        }
    }
    axios(config).then((response) => {
        navigate("/")
    })
    }

    return(
        <form onSubmit={handleSubmit} className="form-card-container">
            <div className="form-group gerencg-form-group">
                <input id="name" type="text" placeholder="nome da categoria"/>
            </div>
            <div className="form-group gerencg-form-group">
                <input id="image" type="text" placeholder="imagem"/>
            </div>
            <button type="submit" className="btn btn-confirm m-2 p-2">Adicionar</button>
        </form>
    );
}

export function AddCategoryStats() {

    const navigate = useNavigate();
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
            }
        };
        axios(config).then(response => {
            setMsg("Registro Adcionado")
            navigate("/category-stats");
        }).catch(() => {
            setMsg("Erro")
        })
    };


    return (
        <form className="form-container" onSubmit={handleSubmit}>
            <div className="form-card-container">
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
            </div>
            <div className="modal-footer">
<button className="text-close" data-bs-dismiss="modal">cancelar</button>
                <button type="submit" className="gerencg-btn" >Adicionar Registro</button>

            </div>
            <div className="msg-container">
                <h3>{msg}</h3>
            </div>
        </form>
    );
}
