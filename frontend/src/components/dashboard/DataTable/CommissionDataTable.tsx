import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { CommissionPage } from "types/commission";
import { BASE_URL } from "utils/requests";

function ItemDataTable() {

    const [pageItem, setPageItem] = useState<CommissionPage>({
        content: [],
        number: 0,
        totalElements: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/items-list`)
            .then((response) => {
                setPageItem(response.data);
            });
    }, []);

    return (
        <div className="table-responsive">
            <table className="table border-table">
                <thead className="bg-primary text-primary">
                    <tr>
                        <th className="table-box"><h5>Descrição do Produto</h5></th>
                        <th className="table-box"><h5>Medida</h5></th>
                        <th className="table-box"><h5>Quantidade</h5></th>
                        <th className="table-box"><h5>Valor Total</h5></th>
                    </tr>
                </thead>
                <tbody className="border-0">
                    {pageItem.content?.map(item => (
                     <tr key={item.id}>
                        <Link to={`/product/${item.product}`} className="table-box-title">
                            <td>{item.product}</td>
                        </Link>
                        <td className="table-box">{item.quantity}</td>
                        <td className="table-box">{item.totalValue}</td>
                     </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default ItemDataTable;