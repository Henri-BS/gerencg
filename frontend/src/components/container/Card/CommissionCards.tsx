import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Code, Item, ItemProps } from "types/commission";
import { BASE_URL } from "utils/requests";
import "./styles.css"

type Commission = {
    commission: Code;
}

export function CommissionCard({ commission }: Commission) {

    return (
        <Link to={`/commission/${commission.code}`}>
            <div className="commission-card">
                <div className="commission-box border-dark">
                    <h2>Código do Pedido: <p>{commission.code}</p></h2>
                </div>
                <div className="commission-box">
                    <h3>Data do Pedido: {moment(commission.commissionDate).format("DD/MM/YYYY")}</h3>
                </div>
                <div className="commission-box border-0">
                    <h3>Distribuidora: {commission.distributor}</h3>
                </div>
            </div>
        </Link>
    );
}

export function CommissionItemCard({ itemId }: ItemProps) {
    const [item, setItem] = useState<Item>();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get(`${BASE_URL}/item/${itemId}`)
            .then((response) => {
                setItem(response.data);
            })
    }, [itemId])

    const updateProductByItem = () => {
        axios.put(`${BASE_URL}/update-product-by-item?id=${itemId}&product=${item?.product}`)
            .then((response) => {
                setItem(response.data);
            })
    }

    const deleteItem = () => {
        axios.delete(`${BASE_URL}/delete-item/${itemId}`)
            .then((response) => {
                navigate(`/commission/${item?.commissionCode}`);
            })
    }
    return (
        <div className="gerencg-item-card">
            <div className="gerencg-box  border-dark">
                <h2>Código do Pedido: {item?.commissionCode}</h2>
            </div>
            <div className="gerencg-box">
                <h4>Descrição: {item?.productDescription}</h4>
            </div>
            <div className="gerencg-box">
                <h3>Medida: {item?.productMeasureValue} {item?.productMeasure}</h3>
            </div>
            <div className="gerencg-box">
                <h3>Quantidade: {item?.quantity}</h3>
            </div>
            <div className="gerencg-box ">
                <h3>Valor por Unidade: {item?.unitValue.toFixed(2)}</h3>
            </div>
            <div className="gerencg-box ">
                <h3>Valor Total: {item?.totalValue.toFixed(2)}</h3>
            </div>
            <div className="gerencg-box">
                <h3>Quantidade de Pacotes: {item?.packageQuantity}</h3>
            </div>
            <div className="gerencg-item-bar">
                <Link to={`/product/${item?.product}`} className="form-btn-container">
                    <button onClick={() => updateProductByItem()} className="gerencg-blue-btn"> Atualizar Produto </button>
                </Link>

                <button onClick={() => deleteItem()} className="gerencg-red-btn">
                    Deletar Item
                </button>                    
            </div>
        </div>
    );
}

