import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { MdClose } from "react-icons/md";
import { Link, useNavigate, useParams } from "react-router-dom";
import { HistoryProps, Product } from "types/product";
import { ProductHistory } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css"

type Props = {
    product: Product;
}

export function ProductCard({ product }: Props) {

    return (
        <Link to={`/product/${product?.id}`}>
            <div className="product-card-container">
                <img className="product-card-image" src={product?.image} alt={product?.description} />
                <div className="product-info-box">
                    <h3 className="product-info-title">{product?.description} • {product?.measureValue} {product?.measure}</h3>

                    <div className="product-info-item">
                        <h6>Preço: {product?.price.toFixed(2)} R$</h6>
                    </div>
                </div>
            </div>
        </Link>
    );
}

//Card with Validate

export function ProductValidateCard({ product }: Props) {

    return (
        <Link to={`/product/${product?.id}`}>
            <div className="product-card-container">
                <img className="product-card-image" src={product?.image} alt={product?.description} />
                <div className="product-info-box">
                    <h3>{product?.description}</h3>

                    <div className="product-info-item">
                        <h2>Valido até: {new Date(product?.validate).toLocaleDateString()}</h2>
                    </div>
                </div>
            </div>
        </Link>
    );
}

//Product history card
type Cons = {
    history: ProductHistory
}

export function ProductHistoryCard({ history }: Cons) {

    const params = useParams();
    return (
        <>
            <div className="gerencg-history-card">
                <div className="history-card-header">
                    <h4>Data da Atualização: {moment(history.createdDate).format("DD/MM/YYYY")}</h4>
                    <span className="history-delete-container" data-bs-toggle="modal" data-bs-target="#deleteHistoryModal"><MdClose /></span>
                </div>
                <div className="gerencg-box">
                    <h3>Preço: {history.price.toFixed(2)}</h3>
                </div>
                <div className="gerencg-box">
                    <h3>Quantidade: {history.quantity}</h3>
                </div>
                <div className="gerencg-box border-0">
                    <h3>Validade: {moment(history.validate).format("DD/MM/YYYY")}</h3>
                </div>
            </div>
            <div className="modal fade" role="dialog" id="deleteHistoryModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <label className="modal-title" id="historyLabel">Deseja deletar estes valores do histórico</label>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span className="text-close" aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <GetHistoryCard historyId={`${params.historyId}`} />
                    </div>
                </div>
            </div>
        </>
    );
}

export function GetHistoryCard({ historyId }: HistoryProps) {

    const navigate = useNavigate();
    const deleteHistory = () => {
        axios.delete(`${BASE_URL}/history/delete/${historyId}`)
            .then((response) => {
                navigate("/product/list")
            });
    }
    return (
        <div className="modal-footer">
            <button className="text-close">cancelar</button>
            <button onClick={() => deleteHistory()} className="btn-danger" data-bs-dismiss="modal">Deletar</button>
        </div>
    );
}