import axios from "axios";
import IUpdateProduct from "assets/img/update.png"
import IDeleteProduct from "assets/img/delete-img.png"
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Order, OrderStats, OrderStatsTotalValue } from "types/order";
import { BASE_URL } from "utils/requests";
import { MdClose } from "react-icons/md";
import { OrderEditForm, OrderStatsEditForm } from "../form/OrderForm";
import moment from "moment";
import { Props } from "types/page";
import { OrderStatsList } from "pages/lists/OrderListing";
import { OrderMockMenuBar, OrderStatsTotalValuesMockBar } from "mock/MockBar";

export function OrderMenuBar({ id: orderId }: Props) {

    const [order, setOrder] = useState<Order>();
    const navigate = useNavigate();
    const params = useParams();

    useEffect(() => {
        axios.get(`${BASE_URL}/order/${orderId}`)
            .then((response) => {
                setOrder(response.data);
            });
    }, [orderId]);

    useEffect(() => {
        axios.put(`${BASE_URL}/order/sum-item-values/${orderId}`)
            .then((response) => {
                setOrder(response.data);
            });
    }, [orderId]);

    const deleteOrder = () => {
        axios.delete(`${BASE_URL}/order/delete/${orderId}`)
            .then((response) => {
                navigate(0)
            });
    }

    return (
        <>
            <div className="max-bar-container ">

                <div className="menu-bar-container row">
                    <span className="col-12 col-md-4">
                        <h2><b>Pedido de Produtos</b></h2>
                        <p>Infornações sobre produtos solicitados.</p>
                    </span>
                    <button data-bs-toggle="modal" data-bs-target="#updateOrderModal" className="menu-bar-option col-6 col-md-4" >
                        <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                        <h6>Editar</h6>
                    </button>
                    <button data-bs-toggle="modal" data-bs-target="#deleteOrderModal" className="menu-bar-option col-6 col-md-4" >
                        <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                        <h6>Deletar</h6>
                    </button>
                </div>

                {order == null ? <OrderMockMenuBar id={`${params.orderId}`} /> :
                    <div>
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
                                    <div className="bar-item-content"> <b>Quantidade de Itens:</b> {order?.amountItems}</div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Tipo de Pacote:</b> {order?.measure} </div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Total de Pacotes:</b> {order?.totalPackage} </div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Total de Unidades:</b> {order?.totalQuantity} </div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Valor Total do Pedido:</b> {order?.expense.toFixed(2)} </div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Categoria:</b> {order?.categoryId} </div>
                                </div>
                            </div>
                        </div>
                    </div>
                }
            </div>

            <div className="modal fade" role="dialog" id="updateOrderModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <label className="modal-title">Alterar pedido</label>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span className="text-close" aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-body"><OrderEditForm id={`${params.orderId}`} /></div>
                    </div>
                </div>
            </div>
            <div className="modal fade" role="dialog" id="deleteOrderModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <div className="modal-title" id="orderLabel">Desejar deletar o pedido de produtos ?</div>
                            <button className="close" data-bs-dismiss="modal">
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
        </>
    );
}


export function OrderStatsBar({ id: statsId }: Props) {

    const navigate = useNavigate();
    const params = useParams();

    const [stats, setStats] = useState<OrderStats>();
    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/${statsId}`)
            .then((response) => {
                setStats(response.data);
            });
    }, [statsId])

    useEffect(() => {
        axios.put(`${BASE_URL}/order-stats/update-values/${statsId}`)
            .then((response) => {
                setStats(response.data);
            });
    }, [statsId]);

    const deleteOrderStats = () => {
        axios.delete(`${BASE_URL}/order-stats/delete/${statsId}`)
            .then((response) => {
                navigate("/stats")
            });
    }

    return (
        <>
            <div className="max-bar-container ">
                <div className="m-4"><OrderStatsList /></div>
                <div className="menu-bar-container">
                    <span>
                        <h2><b>Estatíticas por Período</b></h2>
                        <p>Informações dos produtos relacionadas ao mês {stats?.id}.</p>
                    </span>
                    <button data-bs-toggle="modal" data-bs-target="#updateOrderStatsModal" className="menu-bar-option" >
                        <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                        <h6>Editar</h6>
                    </button>
                    <button data-bs-toggle="modal" data-bs-target="#deleteOrderStatsModal" className="menu-bar-option" >
                        <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                        <h6>Deletar</h6>
                    </button>
                </div>
            </div>

            <div className="max-bar-container">
                <div className="bar-container row">
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-6 ">
                        <div className="bar-item-content"> <b>Data Inicial:</b> {moment(stats?.initialDate).format("DD/MM/YYYY")} </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-6 ">
                        <div className="bar-item-content"> <b>Data Final:</b> {moment(stats?.finalDate).format("DD/MM/YYYY")} </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Pedidos do Mês:</b> {stats?.amountOrder} </div>
                    </div>

                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Despesas do Mês:</b> {stats?.expense.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Média Semanal de Despesas:</b> {stats?.expenseAverageWeek.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Itens do Mês:</b> {stats?.amountItems}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Expectativa de Renda do Mês:</b> {stats?.income.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> <b>Média Semanal da Renda:</b> {stats?.incomeAverageWeek.toFixed(2)}</div>
                    </div>
                </div>
            </div>

            <div className="modal fade" role="dialog" id="updateOrderStatsModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <label className="modal-title">Alterar periodo</label>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span className="text-close" aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-body"><OrderStatsEditForm id={`${params.statsId}`} /></div>
                    </div>
                </div>
            </div>
            <div className="modal fade" role="dialog" id="deleteOrderStatsModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <div className="modal-title" id="orderLabel">Desejar deletar este perído de estatísticas ?</div>
                            <button className="close" data-bs-dismiss="modal">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-footer">
                            <button className="text-close">cancelar</button>
                            <button onClick={() => deleteOrderStats()} className="btn-danger" data-bs-dismiss="modal">Deletar</button>
                        </div>
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
        {stats == null ? <OrderStatsTotalValuesMockBar /> :
            <div className="max-bar-container">
                <div className="bar-container row">
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Pedidos:</b> {stats?.amountOrders}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Despesas:</b> {stats?.sumExpense.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Maior Despesa Mensal:</b> {stats?.maxExpense.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Itens:</b> {stats?.amountItems}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Expectativa Total de Renda:</b> {stats?.sumIncome.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Maior Renda Mensal:</b> {stats?.maxIncome.toFixed(2)}</div>
                    </div>
                </div>
            </div>
}
        </>
    )
}