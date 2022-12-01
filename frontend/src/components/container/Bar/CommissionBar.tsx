import axios from "axios";
import IUpdateProduct from "assets/img/update.png"
import IDeleteProduct from "assets/img/delete-img.png"
import INotifications from "assets/img/notifications.png"
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Code, CodeProps } from "types/commission";
import { BASE_URL } from "utils/requests";
import "./styles.css"

export function CommissionMenuBar({ codeId }: CodeProps) {

    const [commission, setCommission] = useState<Code>();
const navigate = useNavigate();

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
            <div>
                <h2><b>Pedido de Compra</b></h2>
                <p>Infornações sobre Produtos Solicitados</p>
            </div>
                <button className="menu-bar-option" >
                    <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                    <h6>Editar</h6>
                </button>
            <button onClick={() => deleteCommission()} className="menu-bar-option" >
                <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                <h6>Deletar</h6>
            </button>
        </div>
                <div className="bar-container row">
                    <h2>Informações de Identificação</h2>
                    <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 ">
                        Código: {commission?.code}
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 ">
                        Data de Emissão: {commission?.commissionDate}
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 ">
                        Distribuidora: {commission?.distributor}
                    </div>
                </div>

                <div className="bar-container row">
                    <h2>Valores Totais do Produtos</h2>
                    <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                        Valor Total do Pedido: {commission?.totalValue.toFixed(2)}
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                        Quantidade de Items: {commission?.amountItems}
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                        Total de Unidades: {commission?.totalQuantity}
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                        Total de Pacotes: {commission?.totalPackage}
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                        Tipo de Pacote: {commission?.packageType}
                    </div>
                </div>
            </div>
        </>
    );
}
