import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { Code, Item, ItemProps } from "types/commission";
import { BASE_URL } from "utils/requests";
import IUpdateProduct from "assets/img/update.png"
import IDeleteProduct from "assets/img/delete-img.png"
import "./styles.css"
import { EditItemForm } from "../Form/CommissionForm";
import { MdClose, MdLink } from "react-icons/md";


type CommissionCode = {
    commission: Code;
}

export function CommissionCard({ commission }: CommissionCode) {

    return (
        <Link to={`/commission/${commission.code}`}>
            <div className="commission-card">
                <div className="commission-box border-dark">
                    <h2>Código do Pedido: <p>{commission.code}</p></h2>
                </div>
                <div className="commission-box">
                    <h3>Data do Pedido: {moment(commission.commissionDate).format("DD/MM/YYYY")}</h3>
                </div>
                <div className="commission-box border-0">
                    <h3>Distribuidora: {commission.distributor}</h3>
                </div>
            </div>
        </Link>
    );
}

export function CommissionItemCard({ itemId }: ItemProps) {
    const [item, setItem] = useState<Item>();
    const navigate = useNavigate();
    const params = useParams(); 

    useEffect(() => {
        axios.get(`${BASE_URL}/item/${itemId}`)
            .then((response) => {
                setItem(response.data);
            })
    }, [itemId])

    const updateProductByItem = () => {
        axios.put(`${BASE_URL}/update-product-by-item?id=${itemId}&product=${item?.productId}`)
            .then((response) => {
                navigate(`/product/${item?.productId}`)
            })
    }

    const deleteItem = () => {
        axios.delete(`${BASE_URL}/delete-item/${itemId}`)
            .then((response) => {
                navigate(`/commission/${item?.commissionCode}`)
            })
    }
    return (
        <>
        <div className="menu-bar-container">
                    <div>
                        <h2><b>Item de Pedido</b></h2>
                        <p>Detalhes sobre o item do pedido.</p>
                    </div>
                    <button data-bs-toggle="modal" data-bs-target="#updateItemModal" className="menu-bar-option" >
                        <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                        <h6>Editar</h6>
                    </button>
                    <button data-bs-toggle="modal" data-bs-target="#deleteItemModal" className="menu-bar-option" >
                        <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                        <h6>Deletar</h6>
                    </button>
                </div>
            <div className="gerencg-item-card">
                <div className="gerencg-box  border-dark">
                    <h2>Código do Pedido: {item?.commissionCode} <Link to={`/commission/${item?.commissionCode}`} className="link-primary"> <MdLink/></Link></h2>
                </div>
                <div className="gerencg-box">
                    <h4>Descrição: {item?.productDescription}</h4>
                </div>
                <div className="gerencg-box">
                    <h3>Medida: {item?.productMeasureValue} {item?.productMeasure}</h3>
                </div>
                <div className="gerencg-box">
                    <h3>Quantidade: {item?.quantity}</h3>
                </div>
                <div className="gerencg-box ">
                    <h3>Valor por Unidade: {item?.unitValue.toFixed(2)}</h3>
                </div>
                <div className="gerencg-box ">
                    <h3>Valor Total: {item?.totalValue.toFixed(2)}</h3>
                </div>
                <div className="gerencg-box">
                    <h3>Quantidade de Pacotes: {item?.packageQuantity}</h3>
                </div>
                <div className="gerencg-item-bar">
                        <button data-bs-toggle="modal" data-bs-target="#updateProductModal" className="btn-confirm"> 
                        Atualizar Produto 
                        </button>
                </div>
            </div>

            <div className="modal fade" role="dialog" id="updateItemModal" >
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="itemLabel">Deseja alterar o produto do item ?</h5>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose/></span>
                            </button>
                        </div>
                        <div className="modal-body"><EditItemForm itemId={`${params.itemId}`}/></div>
                    </div>
                </div>
            </div>

            <div className="modal fade" role="dialog" id="deleteItemModal" >
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="itemLabel">Deseja deletar este item ?</h5>
                            <button className="close " data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose/></span>
                            </button>
                        </div>
                        <div className="modal-body">Item referente ao produto {item?.productDescription} será removido permanentemente.</div>
                        <div className="modal-footer">
                            <button className="text-close" data-bs-dismiss="modal">Cancelar</button>
                            <button onClick={() => deleteItem()} className="btn-danger" data-bs-dismiss="modal">Deletar Item</button>
                        </div>
                    </div>
                </div>
            </div>
            
            <div className="modal fade" role="dialog" id="updateProductModal" >
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="itemLabel">Deseja alterar o produto relacionado ao item ?</h5>
                            <button className="close " data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose/></span>
                            </button>
                        </div>
                        <div className="modal-body">O produto {item?.productDescription} será atualizado com os dados deste item.</div>
                        <div className="modal-footer">
                            <button className="text-close" data-bs-dismiss="modal">cancelar</button>
                            <button onClick={() => updateProductByItem()} className="btn btn-primary" data-bs-dismiss="modal">Atualizar</button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

