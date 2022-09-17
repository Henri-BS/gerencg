import axios from "axios";
import { productIcons } from "components/shared/MenuIcons";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css"

type Props = {
    productId: string;
}

function ProductColumn({ productId }: Props) {

    const [product, setProduct] = useState<Product>()

    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then(response => {
                setProduct(response.data);
            });
    }, [productId]);

    return (

        <>
            <div className="max-container-column">
                <div className="column-image-container">
                    <img className="column-card-image" src={product?.image} alt={product?.description} />
                </div>
                <div className="column-container">
                    <h1>{product?.description}</h1>


                    <div className="column-item-container">
                        <div className="column-icon-container"> {productIcons.priceIcon} </div>
                        <h3>Preço: {product?.price.toFixed(2)} R$</h3>
                    </div>
                    <Link to={`/measure/${product?.measure}`} className="column-item-container">
                        <div className="column-icon-container">{productIcons.measureIcon}</div>
                        <h3>Medida: {product?.measureValue} {product?.measure}</h3>
                    </Link>
                    <div className="column-item-container">
                        <div className="column-icon-container">{productIcons.quantityIcon}</div>
                        <h3>Quantidade: {product?.quantity}</h3>
                    </div>
                    <div className="column-item-container">
                        <div className="column-icon-container">{productIcons.validateIcon}</div>
                        <h3>Validade: {moment(product?.validate).format('DD/MM/YYYY')} </h3>
                    </div>
                    <Link to={`/category/${product?.category}`} className="column-item-container">
                        <div className="column-icon-container">{productIcons.categoryIcon}</div>
                        <h3>Category: {product?.category} </h3>
                    </Link>
                </div>
            </div>
        </>
    );
}

export default ProductColumn;