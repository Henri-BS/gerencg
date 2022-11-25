
import IUpdateProduct from "assets/img/update.png"
import IDeleteProduct from "assets/img/delete-img.png"
import INotifications from "assets/img/notifications.png"
import "./styles.css"
import { Link, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { Product, ProductProps } from 'types/product';
import axios from 'axios';
import { BASE_URL } from 'utils/requests';
import moment from "moment";
import { productIcons } from "components/shared/MenuIcons";

export function ProductSideBar({ productId }: ProductProps) {

    const [product, setProduct] = useState<Product>();

    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then((response) => {
                setProduct(response.data);
            });
    }, [productId]);

    return (
        <>
            <div className="max-sidebar-container">
                <div className="column-container">
                    <div className="column-image-container">
                        <img className="column-card-image" src={product?.image} alt={product?.description} />
                    </div>
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
                    <Link to={`/find-by-validate`} className="column-item-container">
                        <div className="column-icon-container">{productIcons.validateIcon}</div>
                        <h3>Validade: {moment(product?.validate).format('DD/MM/YYYY')} </h3>
                    </Link>
                    <Link to={`/category/${product?.category}`} className="column-item-container">
                        <div className="column-icon-container">{productIcons.categoryIcon}</div>
                        <h3>Category: {product?.category} </h3>
                    </Link>
                </div>
                <div className="column-card-bottom"> 
                <h4>Última Atualização: {moment(product?.lastUpdateDate).format('DD/MM/YYYY')}</h4>
                </div>
            </div>
        </>
    );
}

export function ProductMenuBar({ productId }: ProductProps) {
    const navigate = useNavigate();
    const [product, setProduct] = useState<Product>();

    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then((response) => {
                setProduct(response.data);
            })
    }, [productId]);

    const deleteProduct = () => {

        axios.delete(`${BASE_URL}/product/delete/${productId}`)
            .then((response) => {
                setProduct(response.data);
                navigate("/product/list");
            })
    }

    const handleCLick = () => {
        axios(`${BASE_URL}/product/${productId}/notification`)
            .then((response) => {
                console.log("SUCESS")
            })
    }

    return (
        <div className="menu-bar-container">
            <Link to={`/product/edit/${productId}`}>
                <button className="menu-bar-option" >
                    <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                    Editar produto
                </button>
            </Link>
            <button className="menu-bar-option" onClick={() => deleteProduct()}>
                <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                Deletar produto
            </button>
            <button className="menu-bar-option" onClick={() => handleCLick()}>
                <img className="option-card-img" src={INotifications} alt="notification" />
                Notificar
            </button>
        </div>
    );
}