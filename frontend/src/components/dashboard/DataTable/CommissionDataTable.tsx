import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { CodeProps, Item } from "types/commission";
import { BASE_URL } from "utils/requests";
import "./styles.css";

function ItemDataTable({ codeId }: CodeProps) {

    const [pageItem, setPageItem] = useState<Item[]>();

    useEffect(() => {
        axios.get(`${BASE_URL}/find-code?code=${codeId}`)
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
                            <th className="table-box"><h5>Medida</h5></th>
                            <th className="table-box"><h5>Quantidade</h5></th>
                            <th className="table-box"><h5>Valor de Unidade</h5></th>
                            <th className="table-box"><h5>Valor Total</h5></th>
                            <th className="table-box"><h5>Validade</h5></th>
                            <th className="table-box"><h5>Quantidade de Pacotes</h5></th>
                            <th className="table-box"><h5>Detalhes</h5></th>
                        </tr>
                    </thead>
                    <tbody className="border-0">
                        {pageItem?.map(item => (
                            <tr key={item.id}>
                                <Link to={`/product/${item.productId}`} className="table-box-title">
                                    <td>{item.productDescription}</td>
                                </Link>
                                <td className="table-box">{item.productMeasureValue}{item.productMeasure}</td>
                                <td className="table-box">{item.quantity}</td>
                                <td className="table-box">{item.unitValue.toFixed(2)}</td>
                                <td className="table-box">{item.totalValue.toFixed(2)}</td>
                                <td className="table-box">{moment(item.itemValidate).format("DD/MM/YYYY")}</td>
                                <td className="table-box">{item.packageQuantity}</td>
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

