import axios from "axios";
import { productIcons } from "components/shared/MenuIcons";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Code, CodeProps, Commission } from "types/commission";
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
        </>
    );
}