import axios, { AxiosRequestConfig } from "axios";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Item, ItemProps } from "types/commission";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";


export function UpdateByItemForm({ itemId, productId }: ItemProps) {
const navigate = useNavigate();
         const [item, setItem] = useState<Item>();
         const [product, setProduct] = useState<Product>();



const updateProductByItem = () => {

axios.put(`${BASE_URL}/update-by-item?id=${itemId}&product=${productId}`)
    .then((response) => {
    setItem(response.data);
})
}
    
    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Deseja atualizar o produto com os dados deste pedido ?</h3>
                <form className="gerencg-form">
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="productId">Produto: {product?.description}</label>
                    </div>
                    <Link to={`/product/${productId}`} className="form-btn-container">
                        <button type="submit" className="gerencg-btn" onClick={() => updateProductByItem()}>
                            Atualizar
                        </button>
                    </Link>
                    <Link className="form-btn-container" to="/product/list">
                        <button className="btn gerencg-btn mt-3">Cancelar</button>
                    </Link>
                </form>
            </div>
        </div>
    );
}