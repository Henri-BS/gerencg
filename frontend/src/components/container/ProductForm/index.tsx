import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css"

function ProductForm() {

    const [product, setProduct] = useState([])
    const [selectProduct, setSelectProduct] = useState<Product>()
    const [data, setData] = useState({
        description: "",
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
            description: data.description,
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
                    description: "",
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

    const editProduct = () => {
        console.log("data", data)
        const productData = {
            id: (product.length + 1),
            description: data.description,
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
                    description: "",
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

    const deleteProduct = () => {
        axios.delete(`${BASE_URL}/product/delete/${selectProduct?.id}`)
            .then((response) => {
                console.log("Adicinado com Sucesso")
                setData({
                    description: "",
                    image: "",
                    price: 0.0,
                    quantity: 0,
                    measureValue: 0.0,
                    measure: "",
                    validate: "",
                    category: 0
                })
                setMsg("Produto Deletado")
            }).catch(() => {
                setMsg("Erro")
            })
    }
    useEffect(() => {
        setData({
            description: selectProduct ? selectProduct.description : "",
            image: selectProduct ? selectProduct.image : "",
            price: selectProduct ? selectProduct.price : 0.0,
            quantity: selectProduct ? selectProduct.quantity : 0,
            measureValue: selectProduct ? selectProduct.measureValue : 0.0,
            measure: selectProduct ? selectProduct.measure : "",
            validate: selectProduct ? selectProduct.validate : "",
            category: selectProduct ? selectProduct.category.id : 0
        })
    }, [selectProduct])


    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Adicionar um Novo Produto</h3>
                <form className="gerencg-form" >

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="description">Descrição: {data.description}</label>
                        <input type="text" className="form-control" id="description" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="image">Image: </label>
                        <input type="text" className="form-control" id="image" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="price">Preço: </label>
                        <input type="number" className="form-control" id="price" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="quantity">Quantidade: </label>
                        <input type="number" className="form-control" id="quantity" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measureValue">Valor de Medida: </label>
                        <input type="number" className="form-control" id="measureValue" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measure">Tipo de Medida: </label>
                        <input type="text" className="form-control" id="measure" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="validate">Validade: </label>
                        <input type="date" className="form-control" id="validate" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="category">Categoria</label>
                        <input type="number" className="form-control" id="category" />
                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className="btn btn-primary gerencg-btn" onClick={() => addProduct()}>
                            Adicionar Produto
                        </button>
                    </div>
                    <div className="msg-container">
                        <h3>{msg}</h3>
                    </div>
                </form>
                <Link to="/product/list">
                    <button className="btn btn-primary gerencg-btn mt-3">Cancelar</button>
                </Link>
            </div>
        </div>);
}

export default ProductForm;