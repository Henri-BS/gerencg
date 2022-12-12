
import { Link, useNavigate, useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { Product, ProductProps } from 'types/product';
import axios from 'axios';
import { BASE_URL } from 'utils/requests';
import moment from "moment";
import { productIcons } from "components/shared/MenuIcons";
import IUpdateProduct from "assets/img/update.png";
import IDeleteProduct from "assets/img/delete-img.png";
import INotifications from "assets/img/notifications.png";
import {MdClose} from "react-icons/md";
import "./styles.css";
import { ProductFormEdit } from '../Form/ProductForm';

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
    const params = useParams();
    const [product, setProduct] = useState<Product>();

    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then((response) => {
                setProduct(response.data);
            })
    }, [productId]);

    const deleteProduct = () => {
        axios.delete(`${BASE_URL}/product-delete/${productId}`)
            .then((response) => {
                navigate("/product-list");
            })
    }

    const notifyProduct = () => {
        axios(`${BASE_URL}/product/${productId}/notification`)
            .then((response) => {
                console.log("SUCESS")
            })
    }

    return (
        <>
        <div className="menu-bar-container">
            
                <button data-bs-toggle="modal" data-bs-target="#updateProductModal" className="menu-bar-option">
                    <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                    Editar 
                </button>
            <button data-bs-toggle="modal" data-bs-target="#deleteProductModal" className="menu-bar-option">
                <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                Deletar
            </button>
            <button className="menu-bar-option" onClick={() => notifyProduct()}>
                <img className="option-card-img" src={INotifications} alt="notification" />
                Notificar
            </button>
        </div>

        <div className="modal fade" role="dialog" id="updateProductModal">
            <div className="modal-dialog" role="document">
                <div className="modal-content">
                    <div className="modal-header">
                        <div className="modal-title" id="productLabel">Editar produto: {product?.description}</div>
                        <button className="close" data-bs-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><MdClose/></span>
                        </button>
                    </div>
                    <div className="modal-body"><ProductFormEdit productId={`${params.productId}`}/></div>
                </div>
            </div>
        </div>

        <div className="modal fade" role="dialog" id="deleteProductModal">
            <div className="modal-dialog" role="document">
                <div className="modal-content">
                    <div className="modal-header">
                        <div className="modal-title">Deseja deletar este produto ?</div>
                        <button className="close" data-bs-dismiss="modal" aria-label="Close"><MdClose/></button>
                    </div>
                    <div className="modal-footer">
                        <button className="text-close" data-bs-dismiss="modal">Cancelar</button>
                        <button className="btn-danger" data-bs-dismiss="modal" onClick={() => deleteProduct()}> Deletar Produto</button>
                    </div>
                </div>
            </div>
        </div>
        </>
    );
}