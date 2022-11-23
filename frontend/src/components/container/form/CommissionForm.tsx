import axios, { AxiosRequestConfig } from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { Item, ItemProps } from "types/commission";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";


export function UpdateByItemForm({ itemId }: ItemProps) {
    const navigate = useNavigate();
    const [item, setItem] = useState<Item>();
    const [product, setProduct] = useState<Product>();

    useEffect(() => {
        axios.get(`${BASE_URL}/item/${itemId}`)
        .then((response) => {
            setItem(response.data);
        })
    }, [itemId])

    const updateProductByItem = () => {
        axios.put(`${BASE_URL}/update-by-item?id=${itemId}&product=${item?.product}`)
            .then((response) => {
                setItem(response.data);
            })               

    }

    return (
        <div className="form-container">
            <div className="product-history-box  border-dark">
                <h2>Código do Pedido: {item?.commissionCode}</h2>
            </div>
            <div className="product-history-box">
                <h4>Descrição: {item?.productDescription}</h4>
            </div>
            <div className="product-history-box">
                <h3>Medida: {item?.productMeasureValue} {item?.productMeasure}</h3>
            </div>
            <div className="product-history-box">
                <h3>Quantidade: {item?.quantity}</h3>
            </div>
            <div className="product-history-box ">
                <h3>Valor por Unidade: {item?.unitValue.toFixed(2)}</h3>
            </div>
            <div className="product-history-box ">
                <h3>Valor Total: {item?.totalValue.toFixed(2)}</h3>
            </div>
            <div className="product-history-box border-0">
                <h3>Quantidade de Pacotes: {item?.packageQuantity}</h3>
            </div>

            <Link to={`/product/${item?.product}`} className="form-btn-container">
                        <button onClick={() => updateProductByItem()} type="submit" className="gerencg-update-btn"> Atualizar Produto </button>
            </Link>
        </div>
    );
}