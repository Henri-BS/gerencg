import axios from "axios";
import IUpdateProduct from "assets/img/update.png"
import IDeleteProduct from "assets/img/delete-img.png"
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Code, CodeProps, OrderStats, OrderStatsProps, OrderStatsTotalValue } from "types/order";
import { BASE_URL } from "utils/requests";
import "./styles.css"
import { MdClose } from "react-icons/md";
import { EditCommissionForm } from "../Form/CommissionForm";

export function CommissionMenuBar({ codeId }: CodeProps) {

    const [commission, setCommission] = useState<Code>();
    const navigate = useNavigate();
    const params = useParams();

    useEffect(() => {
        axios.get(`${BASE_URL}/commission/${codeId}`)
            .then((response) => {
                setCommission(response.data);
            });
    }, [codeId]);

    useEffect(() => {
        axios.put(`${BASE_URL}/sum-item-values/${codeId}`)
            .then((response) => {
                setCommission(response.data);
            });
    }, [codeId]);

    const deleteCommission = () => {
        axios.delete(`${BASE_URL}/delete-commission/${codeId}`)
            .then((response) => {
                navigate("/commission-list")
            })
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
                                <label className="modal-title" id="commissionLabel">Alterar pedido</label>
                                <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                    <span className="text-close" aria-hidden="true"><MdClose /></span>
                                </button>
                            </div>
                            <div className="modal-body"><EditCommissionForm codeId={`${params.codeId}`} /></div>
                        </div>
                    </div>
                </div>
                <div className="modal fade" role="dialog" id="deleteCommissionModal">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <div className="modal-title" id="commissonModal">Desejar deletar o pedido de produtos ?</div>
                                <button className="close" data-bs-dismiss="modal" aria-label="commissionModal">
                                    <span aria-hidden="true"><MdClose /></span>
                                </button>
                            </div>
                            <div className="modal-footer">
                                <button className="text-close">cancelar</button>
                                <button onClick={() => deleteCommission()} className="btn-danger" data-bs-dismiss="modal">Deletar Pedido</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="bar-container">
                    <h2>Informações de Identificação</h2>
                    <div className="row">
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 ">
                            <div className="bar-item-content"> Código: {commission?.code}</div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 ">
                            <div className="bar-item-content"> Data de Emissão: {commission?.orderDate}</div>
                        </div>
                        <div className="bar-item col-12 col-sm-12 col-md-6 col-lg-4 col-xl-4 ">
                            <div className="bar-item-content"> Distribuidora: {commission?.distributor}</div>
                        </div>
                    </div>
                </div>

                <div className="bar-container">
                    <h2>Valores Totais do Produtos</h2>
                    <div className="row">
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div className="bar-item-content"> Quantidade de Items: {commission?.amountItems}</div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div className="bar-item-content"> Tipo de Pacote: {commission?.packageType} </div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div className="bar-item-content"> Total de Pacotes: {commission?.totalPackage} </div>
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-6 col-xl-6">
                            <div className="bar-item-content"> Total de Unidades: {commission?.totalQuantity} </div>
                        </div>

                        <div className="bar-item col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                            <div className="bar-item-content"> Valor Total do Pedido: {commission?.totalValue} </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}


export function OrderStatsBar({ statsId }: OrderStatsProps) {

    const [stats, setStats] = useState<OrderStats>();
    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/${statsId}`)
            .then((response) => {
                setStats(response.data);
            });
    }, [statsId])

    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/update/${statsId}`)
            .then((response) => {
                setStats(response.data);
            });
    }, [statsId])

    return (
        <>
            <div className="max-bar-container">
                <div className="bar-container row">
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Data Inicial: {stats?.initialDate}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Data Final: {stats?.finalDate} </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Total de Pedidos do Mês: {stats?.amountOrder}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Total de Items do Mês: {stats?.amountItems}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Total de Despesas do Mês: {stats?.totalValue.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Média Semanal de Despesas: {stats?.averageWeek.toFixed(2)}</div>
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
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Total de Pedidos: {stats?.amountOrders}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Total de Items: {stats?.amountItems}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Total de Despesas: {stats?.totalValue.toFixed(2)}</div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 ">
                        <div className="bar-item-content"> Maior Despesa: {stats?.maxValue.toFixed(2)}</div>
                    </div>

                </div>
            </div>
        </>
    )
}