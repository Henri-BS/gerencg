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
                    Valor Total: {commission?.code}
                </div>
                <div className="bar-option">
                    QUantidade Total: {commission?.commissionDate}
                </div>
            </div>
        </>
    );
}