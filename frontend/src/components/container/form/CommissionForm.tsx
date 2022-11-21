import axios, { AxiosRequestConfig } from "axios";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Item, ItemProps } from "types/commission";
import { ProductProps } from "types/product";
import { BASE_URL } from "utils/requests";

export function UpdateByItemForm({ productId, itemId }: ItemProps) {
const navigate = useNavigate();
    const [item, setItem] = useState<Item>();
    
    useEffect(() => {
    axios.put(`${BASE_URL}/update-by-item?product=${productId}?id=${itemId}`)
    .then((response) => {
        setItem(response.data);
    })
}, [productId, itemId])

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const itemId = (event.target as any).commissionId.value;
        const productId = (event.target as any).productId.value;


        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: "PUT",
            url: ``,
            data: {
                itemId: itemId,
                productId: productId
            }
        }
        axios(config).then((response) => {
navigate(`/product/${item?.product}`)
        })
    }

    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Deseja atualizar o produto com os dados deste pedido ?</h3>
                <form className="gerencg-form" onSubmit={handleSubmit}>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="productId">Produto: {item?.productDescription}</label>
                       
                    </div>
                    <div className="form-btn-container">
                        <button type="submit" className="gerencg-btn">
                            Atualizar
                        </button>
                    </div>
                    <Link className="form-btn-container" to="/product/list">
                        <button className="btn gerencg-btn mt-3">Cancelar</button>
                    </Link>
                </form>
            </div>
        </div>
    );
}