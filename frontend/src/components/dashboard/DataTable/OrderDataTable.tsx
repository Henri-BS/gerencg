import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Item } from "types/order";
import { BASE_URL } from "utils/requests";
import "./styles.css";
import { Props } from "types/page";

function ItemDataTable({ id: codeId }: Props) {

    const [pageItem, setPageItem] = useState<Item[]>();

    useEffect(() => {
        axios.get(`${BASE_URL}/item/order/${codeId}`)
            .then((response) => {
                setPageItem(response.data);
            });
    }, [codeId]);

    return (
        <>
            <div className="table-responsive">
                <table className="table border-table">
                    <thead className="bg-primary text-primary">
                        <tr>
                            <th className="table-box"><h5>Descrição do Produto</h5></th>
                            <th className="table-box"><h5>Unidades</h5></th>
                            <th className="table-box"><h5>Pacotes</h5></th>
                            <th className="table-box"><h5>Valor Unitário</h5></th>
                            <th className="table-box"><h5>Valor Total</h5></th>
                            <th className="table-box"><h5>Validade</h5></th>
                            <th className="table-box"><h5>Detalhes</h5></th>
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

export default ItemDataTable;

