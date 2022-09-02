import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css"

function ProductForm() {
    const navigate = useNavigate();

    const [selectProduct, setSelectProduct] = useState<Product>()
    const [msg, setMsg] = useState('')

    useEffect(() => {
        axios.get(`${BASE_URL}/product/list`)
            .then((response) => {
                setSelectProduct(response.data);
            })
    }, [])

    const addProduct = () => {
        console.log("data", selectProduct);
        const productData = {
            id: (selectProduct?.id),
            description: selectProduct?.description,
            image: selectProduct?.image,
            price: selectProduct?.price,
            quantity: selectProduct?.quantity,
            validate: selectProduct?.validate,
            measureValue: selectProduct?.measureValue,
            measure: selectProduct?.measure,
            category: selectProduct?.category
        }
        axios.post(`${BASE_URL}/product/add`, productData)
            .then((response) => {
                console.log("Adicionado com Sucesso")
                setSelectProduct(response.data);
                setMsg("Produto Adicionado")
            }).catch(() => {
                setMsg("Erro")
            })
    }

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const description = (event.target as any).description.value;
        const image = (event.target as any).image.value;
        const price = (event.target as any).price.value;
        const quantity = (event.target as any).quantity.value;
        const validate = (event.target as any).validate.value;
        const measureValue = (event.target as any).measureValue.value;
        const measure = (event.target as any).measure.value;
        const category = (event.target as any).category.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: "POST",
            url: "/product/add",
            data: {
                description: description,
                image: image,
                price: price,
                quantity: quantity,
                validate: validate,
                measureValue: measureValue,
                measure: measure,
                category: category
            },
        };
        axios(config).then(response => {
            navigate("/");
        });
    };


    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Adicionar um Novo Produto</h3>

                <form className="gerencg-form" onSubmit={handleSubmit}>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="description">Descrição: </label>
                        <input type="text" className="form-control" id="description"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="image">Image: </label>
                        <input type="text" className="form-control" id="image"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="price">Preço: </label>
                        <input className="form-control" id="price" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="quantity">Quantidade: </label>
                        <input type="number" className="form-control" id="quantity" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measureValue">Valor de Medida: </label>
                        <input className="form-control" id="measureValue" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measure">Tipo de Medida: </label>
                        <input type="text" className="form-control" id="measure"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="validate">Validade: </label>
                        <input type="text" className="form-control" id="validate"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="category">Categoria: </label>
                        <input type="number" className="form-control" id="category" />
                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className="btn btn-primary gerencg-btn" onClick={() => addProduct()}>
                            Adicionar Produto
                        </button>
                    </div>
                    <Link className="form-btn-container" to="/product/list">
                        <button className="btn gerencg-btn mt-3">Cancelar</button>
                    </Link>
                </form>

                <div className="msg-container">
                    <h3>{msg}</h3>
                </div>
            </div>
        </div>);
}

export default ProductForm;