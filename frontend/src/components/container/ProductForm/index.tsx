import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";


function ProductForm() {

    const [product, setProduct] = useState([])
    const [selectProduct, setSelectProduct] = useState<Product>()
    const [data, setData] = useState({
        descripton: "",
        image: "",
        price: 0.0,
        quantity: 0,
        measureValue: 0.0,
        measure: "",
        validate: "",
        category: 0
    })
    const [msg, setMsg] = useState('')
    useEffect(() => {
        axios.get(`${BASE_URL}/product/list`)
            .then((response) => {
                setProduct(response.data);
            })
    }, [])

    const addProduct = () => {
        console.log("data", data);
        const productData = {
            id: (product.length + 1),
            description: data.descripton,
            image: data.image,
            price: data.price,
            quantity: data.quantity,
            validate: data.validate,
            measureValue: data.measureValue,
            measure: data.measure,
            category: data.category
        }
        axios.post(`${BASE_URL}/product/add`)
            .then((response) => {
                console.log("Adicionado com Sucesso")
                setData({
                    descripton: "",
                    image: "",
                    price: 0.0,
                    quantity: 0,
                    measureValue: 0.0,
                    measure: "",
                    validate: "",
                    category: 0
                })
                setMsg("Produto Adicionado")
            }).catch(() => {
                setMsg("Erro")
            })
    }

    const editPost = () => {
        console.log("data",data)
        const productData ={
            id: (product.length + 1),
            description: data.descripton,
            image: data.image,
            price: data.price,
            quantity: data.quantity,
            validate: data.validate,
            measureValue: data.measureValue,
            measure: data.measure,
            category: data.category
        }
        axios.put(`${BASE_URL}/product/edit/${selectProduct?.id}`, productData)
        .then((response) => {
            console.log("Adicionado com Sucesso")
            setData({
                descripton: "",
                    image: "",
                    price: 0.0,
                    quantity: 0,
                    measureValue: 0.0,
                    measure: "",
                    validate: "",
                    category: 0
                })
                setMsg("Produto Alterado")
            }).catch(() => {
                setMsg("Erro")
            })
    }

    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Adicionar um Novo Produto</h3>
                <form className="gerencg-form" >

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="email">Descrição: {data.descripton}</label>
                        <input type="email" className="form-control" id="email" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="email">Preço: </label>
                        <input type="email" className="form-control" id="email" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="email">Quantidade: </label>
                        <input type="email" className="form-control" id="email" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="email">Valor de Medida: </label>
                        <input type="email" className="form-control" id="email" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="email">Tipo de Medida: </label>
                        <input type="email" className="form-control" id="email" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="email">Validade: </label>
                        <input type="email" className="form-control" id="email" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="email">Categoria</label>
                        <input type="email" className="form-control" id="email" />
                    </div>

                    <div className="gerencg-form-btn-container">
                        <button type="submit" className="btn btn-primary gerencg-btn">
                            Salvar
                        </button>
                    </div>
                </form>
                <Link to="/product/list">
                    <button className="btn btn-primary gerencg-btn mt-3">Cancelar</button>
                </Link>
            </div>
        </div>);
}

export default ProductForm;