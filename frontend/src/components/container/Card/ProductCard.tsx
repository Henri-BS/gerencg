import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { MdClose, MdInfoOutline } from "react-icons/md";
import { Link, useParams } from "react-router-dom";
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
        <>   <Link to={`/history/${history.id}`}>
            <div className="small-card-container">
                <h5>Data de Registro: {moment(history.createdDate).format("DD/MM/YYYY")}
                </h5>
            </div> </Link>
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

    const [history, setHistory] = useState<ProductHistory>();
    useEffect(() => {
        axios.get(`${BASE_URL}/history/${historyId}`)
            .then((response) => {
                setHistory(response.data);
            });
    }, [historyId]);

    useEffect(() => {
        axios.put(`${BASE_URL}/history/update-value/${historyId}`)
            .then((response) => {
                setHistory(response.data);
            });
    }, [historyId]);

    return (
        <>
            <div className="gerencg-item-card">
                <div className="gerencg-box border-dark">
                    <h4>Data de registro: {moment(history?.createdDate).format("DD/MM/YYYY")}</h4>
                </div>
                <div className="gerencg-box">
                    Quantidade em estoque: {history?.quantity}
                </div>
                <div className="gerencg-box">
                    Preço: {history?.price.toFixed(2)}
                </div>
                <div className="gerencg-box">
                    Validade: {moment(history?.validate).format("DD/MM/YYYY")}
                </div>
                <div className="gerencg-box">
                    Expectativa de Renda: {history?.income}
                </div>
            </div>
        </>
    );
}