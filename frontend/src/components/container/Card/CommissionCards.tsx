import moment from "moment";
import { Link } from "react-router-dom";
import { Code } from "types/commission";
import "./styles.css"

type Commission = {
    commission: Code;
}
export function CommissionCard({ commission }: Commission) {

    return (
        <Link to={`/commission/${commission.code}`}>
        <div className="commission-card">
            <div className="commission-box border-dark">
                <h2>Código do Pedido: <p>{commission.code}</p></h2>
            </div>
            <div className="commission-box">
                <h3>Data do Pedido: {moment(commission.commissionDate).format("DD/MM/YYYY")}</h3>
            </div>
            <div className="commission-box border-0">
                <h3>Distribuidora: {commission.distributor}</h3>
            </div>
        </div>
        </Link>
    );
}