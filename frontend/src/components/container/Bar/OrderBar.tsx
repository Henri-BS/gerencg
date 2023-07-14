import axios from "axios";
import IUpdateProduct from "assets/img/update.png"
import IDeleteProduct from "assets/img/delete-img.png"
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Order, OrderStats, OrderStatsTotalValue } from "types/order";
import { BASE_URL } from "utils/requests";
import "./styles.css"
import { MdClose } from "react-icons/md";
import { OrderEditForm } from "../Form/OrderForm";
import moment from "moment";
import { Props } from "types/page";

export function OrderMenuBar({ id: codeId }: Props) {

    const [order, setOrder] = useState<Order>();
    const navigate = useNavigate();
    const params = useParams();

    useEffect(() => {
        axios.get(`${BASE_URL}/order/${codeId}`)
            .then((response) => {
                setOrder(response.data);
            });
    }, [codeId]);

    useEffect(() => {
        axios.put(`${BASE_URL}/order/sum-item-values/${codeId}`)
            .then((response) => {
                setOrder(response.data);
            });
    }, [codeId]);

    const deleteOrder = () => {
        axios.delete(`${BASE_URL}/order/delete/${codeId}`)
            .then((response) => {
                navigate("/order/list")
            });
    }

    return (
        <>
            <div className="max-bar-container ">
                <div className="menu-bar-container">
                    <span>
                        <h2><b>Pedido de Produtos</b></h2>
                        <p>Infornações sobre produtos solicitados.</p>
                    </span>
                    <button data-bs-toggle="modal" data-bs-target="#updateCommissionModal" className="menu-bar-option" >
                        <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                        <h6>Editar</h6>
                    </button>
                    <button data-bs-toggle="modal" data-bs-target="#deleteCommissionModal" className="menu-bar-option" >
                        <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                        <h6>Deletar</h6>
                    </button>
                </div>

                <div className="modal fade" role="dialog" id="updateCommissionModal">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <label className="modal-title" id="orderLabel">Alterar pedido</label>
                                <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                    <span className="text-close" aria-hidden="true"><MdClose /></span>
                                </button>
                            </div>
                            <div className="modal-body"><OrderEditForm id={`${params.codeId}`} /></div>
                        </div>
                    </div>
                </div>
                <div className="modal fade" role="dialog" id="deleteCommissionModal">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <div className="modal-title" id="orderLabel">Desejar deletar o pedido de produtos ?</div>
                                <button className="close" data-bs-dismiss="modal" aria-label="commissionModal">
                                    <span aria-hidden="true"><MdClose /></span>
                                </button>
                            </div>
                            <div className="modal-footer">
                                <button className="text-close">cancelar</button>
                                <button onClick={() => deleteOrder()} className="btn-danger" data-bs-dismiss="modal">Deletar Pedido</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="bar-container">
                    <h2>Informações de Identificação</h2>
                    <div className="row">
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 ">
                            <div className="bar-item-content"> <b>Código:</b> {order?.code}</div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 ">
                            <div className="bar-item-content"> <b>Data de Emissão:</b> {moment(order?.orderDate).format('DD/MM/YYYY')}</div>
                        </div>
                        <div className="bar-item col-12 col-sm-12 col-md-6 col-lg-4 col-xl-4 ">
                            <div className="bar-item-content"> <b>Distribuidora:</b> {order?.distributor}</div>
                        </div>
                    </div>
                </div>

                <div className="bar-container">
                    <h2>Valores Totais do Produtos</h2>
                    <div className="row">
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div className="bar-item-content"> <b>Quantidade de Items:</b> {order?.amountItems}</div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div className="bar-item-content"> <b>Tipo de Pacote:</b> {order?.packageType} </div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div className="bar-item-content"> <b>Total de Pacotes:</b> {order?.totalPackage} </div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div className="bar-item-content"> <b>Total de Unidades:</b> {order?.totalQuantity} </div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div className="bar-item-content"> <b>Valor Total do Pedido:</b> {order?.totalValue} </div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div className="bar-item-content"> <b>Categoria:</b> {order?.categoryId} </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}


export function OrderStatsBar({ id: statsId }: Props) {

    const [stats, setStats] = useState<OrderStats>();
    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/${statsId}`)
            .then((response) => {
                setStats(response.data);
            });
    }, [statsId])

    useEffect(() => {
        axios.put(`${BASE_URL}/order-stats/update/${statsId}`)
            .then((response) => {
                setStats(response.data);
            });
    }, [statsId])

    return (
        <>
            <div className="max-bar-container">
                <div className="bar-container row">
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Data Inicial:</b> {moment(stats?.initialDate).format("DD/MM/YYYY")} </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Data Final:</b> {moment(stats?.finalDate).format("DD/MM/YYYY")} </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Pedidos do Mês:</b> {stats?.amountOrder} </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Items do Mês:</b> {stats?.amountItems}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Despesas do Mês:</b> {stats?.totalValue.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Média Semanal de Despesas:</b> {stats?.averageWeek.toFixed(2)}</div>
                    </div>

                </div>
            </div>
        </>
    )
}

export function OrderStatsTotalValuesBar() {

    const [stats, setStats] = useState<OrderStatsTotalValue>();
    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/total-value`)
            .then((response) => {
                setStats(response.data);
            });
    }, [])

    return (
        <>
            <div className="max-bar-container">
                <div className="bar-container row">
                    <div className="bar-item col-12 col-sm-6 col-xl-3 ">
                        <div className="bar-item-content"> <b>Total de Pedidos:</b> {stats?.amountOrders}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-3 ">
                        <div className="bar-item-content"> <b>Total de Items:</b> {stats?.amountItems}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-3 ">
                        <div className="bar-item-content"> <b>Total de Despesas:</b> {stats?.totalValue.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-3 ">
                        <div className="bar-item-content"> <b>Maior Despesa:</b> {stats?.maxValue.toFixed(2)}</div>
                    </div>

                </div>
            </div>
        </>
    )
}