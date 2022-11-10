import moment from "moment";
import { Code } from "types/commission";
import "./styles.css"

type Commission = {
    commission: Code;
}
export function CommissionCard({ commission }: Commission) {

    return (
        <div className="product-history-card">
            <div className="product-history-box border-dark">
                <h2>Código do Pedido: {commission.code}</h2>
            </div>
            <div className="product-history-box">
                <h3>Data do Pedido: {moment(commission.commissionDate).format("DD/MM/YYYY")}</h3>
            </div>
            <div className="product-history-box border-0">
                <h3>Distribuidora: {commission.distributor}</h3>
            </div>
        </div>
    );
}