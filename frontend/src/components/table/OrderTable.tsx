import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Item } from "types/order";
import { BASE_URL } from "utils/requests";
import { Props } from "types/page";

function ItemTable({ id: orderId }: Props) {

    const [pageItem, setPageItem] = useState<Item[]>();

    useEffect(() => {
        axios.get(`${BASE_URL}/item/order/${orderId}`)
            .then((response) => {
                setPageItem(response.data);
            });
    }, [orderId]);

    return (
        <>
            <div className="table-responsive">
                <table className="table">
                    <thead>
                        <tr>
                            <th className="table-box">Descrição do Produto</th>
                            <th className="table-box">Unidades</th>
                            <th className="table-box">Pacotes</th>
                            <th className="table-box">Valor Unitário</th>
                            <th className="table-box">Valor Total</th>
                            <th className="table-box">Validade</th>
                            <th className="table-box">Detalhes</th>
                        </tr>
                    </thead>

                    <tbody className="border-0">
                        {pageItem?.map(item => (
                            <tr key={item.id}>
                                <Link to={`/product/${item.productId}`} className="table-box-title">
                                    <td>{item.productDescription} - {item.productMeasureValue}{item.productMeasure}</td>
                                </Link>
                                <td className="table-box">{item.quantity}</td>                                
                                <td className="table-box">{item.packageQuantity}</td>
                                <td className="table-box">{item.unitValue.toFixed(2)}</td>
                                <td className="table-box">{item.expense.toFixed(2)}</td>
                                <td className="table-box">{moment(item.itemValidate).format("DD/MM/YYYY")}</td>
                                <td className="table-box">
                                    <Link to={`/item/${item.id}`}className="table-links">
                                       Ver mais
                                    </Link>
                                </td>
                            </tr>
                        ))}
                    </tbody>

                </table>
            </div>
        </>
    );
}

export default ItemTable;

