
import { Link, useNavigate, useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { Product } from 'types/product';
import { Props } from 'types/page';
import axios from 'axios';
import { BASE_URL } from 'utils/requests';
import moment from "moment";
import { productIcons } from "components/shared/MenuIcons";
import IUpdateProduct from "assets/img/update.png";
import IDeleteProduct from "assets/img/delete-img.png";
import { MdClose } from "react-icons/md";
import { EditHistoryForm, ProductFormEdit } from '../form/ProductForm';
import { ProductMockSideBar } from 'mock/MockBar';

export function ProductSideBar({ id: productId }: Props) {

const params = useParams();

    const [product, setProduct] = useState<Product>();

    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then((response) => {
                setProduct(response.data);
            });
    }, [productId]);

    return (
        <>
            {product == null ? <ProductMockSideBar id={`${params.productId}`}/> :
                <div className="max-sidebar-container">
                    <div className="sidebar-container">
                        <div className="sidebar-image-container">
                            <img className="sidebar-card-image" src={product?.image} alt={product?.description} />
                        </div>
                        <h1>{product?.description}</h1>

                        <div className="sidebar-item-container">
                            <div className="sidebar-icon-container"> {productIcons.priceIcon} </div>
                            <h3>Preço: {product?.price.toFixed(2)} R$</h3>
                        </div>
                        <Link to={`/measure/${product?.measure}`} className="sidebar-item-container">
                            <div className="sidebar-icon-container">{productIcons.measureIcon}</div>
                            <h3>Medida: {product?.measureValue} {product?.measure.abbreviation}</h3>
                        </Link>
                        <div className="sidebar-item-container">
                            <div className="sidebar-icon-container">{productIcons.quantityIcon}</div>
                            <h3>Quantidade: {product?.quantity}</h3>
                        </div>
                        <Link to={`/find-by-validate`} className="sidebar-item-container">
                            <div className="sidebar-icon-container">{productIcons.validateIcon}</div>
                            <h3>Validade: {moment(product?.validate).format('DD/MM/YYYY') ?? "Indefinido"} </h3>
                        </Link>
                        <Link to={`/category/${product?.category}`} className="sidebar-item-container">
                            <div className="sidebar-icon-container">{productIcons.categoryIcon}</div>
                            <h3>Category: {product?.category.name} </h3>
                        </Link>
                    </div>
                    <div className="sidebar-card-bottom">
                        <h4>Última Atualização: {moment(product?.dateUpdate).format('DD/MM/YYYY')}</h4>
                    </div>
                </div>
            }
 
        </>
    );
}

export function ProductMenuBar({ id: productId }: Props) {
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
        axios.delete(`${BASE_URL}/product/delete/${productId}`)
            .then((response) => {
                navigate(0);
            })
    }


    return (
        <>
            <div className="menu-bar-container row">
                <button data-bs-toggle="modal" data-bs-target="#updateProductModal" className="menu-bar-option col-6">
                    <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                    Editar
                </button>
                <button data-bs-toggle="modal" data-bs-target="#deleteProductModal" className="menu-bar-option col-6">
                    <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                    Deletar
                </button>
            </div>

            <div className="modal fade" role="dialog" id="updateProductModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <div className="modal-title" id="productLabel">Editar produto: {product?.description}</div>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-body"><ProductFormEdit id={`${params.productId}`} /></div>
                    </div>
                </div>
            </div>

            <div className="modal fade" role="dialog" id="deleteProductModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <div className="modal-title">Deseja deletar este produto ?</div>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close"><MdClose /></button>
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

export function HistoryMenuBar({ id: historyId }: Props) {

    const params = useParams();
    const navigate = useNavigate();
    const deleteHistory = () => {
        axios.delete(`${BASE_URL}/history/delete/${historyId}`)
            .then((response) => {
                navigate("/product")
            });
    }

    return (
        <>
            <div className="menu-bar-container">
                <div>
                    <h2><b>Valores do Produto</b></h2>
                    <p>Detalhes sobre os valores salvos no hitórico do produto.</p>
                </div>
                <button data-bs-toggle="modal" data-bs-target="#editHistoryModal" className="menu-bar-option" >
                    <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                    <h6>Editar</h6>
                </button>
                <button data-bs-toggle="modal" data-bs-target="#deleteHistoryModal" className="menu-bar-option" >
                    <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                    <h6>Deletar</h6>
                </button>
            </div>

            <div className="modal fade" role="dialog" id="editHistoryModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <label className="modal-title" id="historyLabel">Deseja alterar os dados no histórico do produto ?</label>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-body">
                            <EditHistoryForm id={`${params.historyId}`} />
                        </div>
                    </div>
                </div>
            </div>

            <div className="modal fade" role="dialog" id="deleteHistoryModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <label className="modal-title" id="historyLabel">Deseja deletar os dados do histórico do produto?</label>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-footer">
                            <button className="text-close" data-bs-dismiss="modal">cancelar</button>
                            <button onClick={() => deleteHistory()} className="btn-danger" data-bs-dismiss="modal" >Deletar</button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}