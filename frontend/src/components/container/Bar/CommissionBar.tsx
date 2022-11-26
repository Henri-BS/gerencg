import axios from "axios";
import { useEffect, useState } from "react";
import { Code, CodeProps } from "types/commission";
import { BASE_URL } from "utils/requests";
import "./styles.css"

export function CommissionMenuBar({ codeId }: CodeProps) {

    const [commission, setCommission] = useState<Code>();

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


    return (
        <>
            <div className="max-bar-container ">
                <div className="bar-container">
                    <h3>Informações de Identificação</h3>
                    <div className="bar-card row">
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                            Código: {commission?.code}
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                            Data de Emissão: {commission?.commissionDate}
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                            Distribuidora: {commission?.distributor}
                        </div>
                    </div>
                </div>

                <div className="bar-container">
                    <h3>Valores Totais do Produtos</h3>
                    <div className="bar-card row">
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                            Valor Total do Pedido: {commission?.totalValue.toFixed(2)}
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                            Quantidade Total de Items: {commission?.totalQuantity}
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                            Total de Pacotes: {commission?.totalPackage}
                        </div>
                        <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 m">
                            Tipo de Pacote: {commission?.packageType}
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}