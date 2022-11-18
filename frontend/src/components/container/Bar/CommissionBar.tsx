import axios from "axios";
import { useEffect, useState } from "react";
import { Code, CodeProps } from "types/commission";
import { BASE_URL } from "utils/requests";
import "./styles.css"

export function CommissionMenuBar({ codeId: code }: CodeProps) {

    const [commission, setCommission] = useState<Code>();

    useEffect(() => {
        axios.get(`${BASE_URL}/commission/${code}`)
            .then((response) => {
                setCommission(response.data);
            });
    }, [code]);

    return (
        <>
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
            <div className="bar-container">
                <div className="bar-option">
                    Valor Total do Pedido: {commission?.totalValue}
                </div>
                <div className="bar-option">
                    Quantidade Total de Items: {commission?.totalQuantity}
                </div>
                <div className="bar-option">
                    Total de Pacotes: {commission?.totalPackage}
                </div>
            </div>
        </>
    );
}