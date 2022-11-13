import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { CodeProps, Commission } from "types/commission";
import { BASE_URL } from "utils/requests";

function ItemDataTable({ codeId }: CodeProps) {

    const [pageItem, setPageItem] = useState<Commission[]>();
    useEffect(() => {
        axios.get(`${BASE_URL}/find-code?code=${codeId}`)
            .then((response) => {
                setPageItem(response.data);
            });
    }, [codeId]);

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
                    {pageItem?.map(item => (
                        <tr key={item.id}>
                            <Link to={`/product/${item.product}`} className="table-box-title">
                                <td>{item.productDescription}</td>
                            </Link>
                            <td className="table-box">{item.productMeasureValue}{item.productMeasure}</td>
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

