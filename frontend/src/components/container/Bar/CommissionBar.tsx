import axios from "axios";
import { useEffect, useState } from "react";
import { Code, CodeProps } from "types/commission";
import { BASE_URL } from "utils/requests";
import "./styles.css"

export function CommissionMenuBar({codeId }: CodeProps) {

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
        <div className="max-bar-container">
        <h3><b>Informações de Identificação</b></h3>
            <div className="bar-container">
                <div className="bar-option">
                    Código do Pedido: {commission?.code}
                </div>
                <div className="bar-option">
                    Data de Emissão: {commission?.commissionDate}
                </div>
                <div className="bar-option">
                    Distribuidora: {commission?.distributor}
                </div>
            </div>
            <h3><b>Valores Totais do Produto</b></h3>
            <div className="bar-container">
                <div className="bar-option">
                    Valor Total do Pedido: {commission?.totalValue.toFixed(2)}
                </div>
                <div className="bar-option">
                    Quantidade Total de Items: {commission?.totalQuantity}
                </div>
                <div className="bar-option">
                    Total de Pacotes: {commission?.totalPackage}
                </div>
            </div>
            </div>
        </>
    );
}