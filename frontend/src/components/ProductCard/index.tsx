import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css"

type Props = {
    product: Product;
}

function ProductCard({ product }: Props) {

    return (
            <Link to={`/product/${product?.id}`}>
                <div className="product-display-card">
            <img className="product-card-image" src={product?.image} alt={product?.description} />
            <div className="product-card-container">
            <h3>{product?.description}</h3>
            <div className="product-price-container">
                <h2>{product?.price}</h2>
                </div>
            </div>
            </div>
            </Link>

    );

}

export default ProductCard;