import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Order, Item, OrderStats } from "types/order";
import { MeasurePage } from "types/measure";
import { ProductPage } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css";
import { Props } from "types/page";
import { CategoryPage } from "types/category";
import { OrderTag, TagPage } from "types/tag";
import { CategoryDatalist, MeasureDatalist, ProductDatalist, TagDataList } from "./DatalistForm";

export function OrderAddForm() {
    const navigate = useNavigate();

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const code = (event.target as any).code.value;
        const orderDate = (event.target as any).orderDate.value;
        const distributor = (event.target as any).distributor.value;
        const measure = (event.target as any).measure.value;
        const categoryId = (event.target as any).categoryId.value;

        const config: AxiosRequestConfig = {
            method: "POST",
            baseURL: BASE_URL,
            url: "/order/save",
            data: {
                code: code,
                orderDate: orderDate,
                distributor: distributor,
                measure: measure,
                categoryId: categoryId
            }
        }
        axios(config).then((response) => {
            navigate("/order");
        });
    }
    return (
        <>
            <form className="form-card-container" onSubmit={handleSubmit}>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="code">Código do Pedido: </label>
                    <input className="form-control" id="code" placeholder="00.00.0000.00-aa" />
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="orderDate">Data do Pedido: </label>
                    <input type="date" className="form-control" id="orderDate" />
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="distributor">Distribuidora: </label>
                    <input className="form-control" id="distributor" />
                </div>
                <MeasureDatalist />
                <CategoryDatalist />
                <div className="modal-footer">
                    <button type="button" className="text-close" data-bs-dismiss="modal">cancelar</button>
                    <button type="submit" className="btn-confirm">Adicionar Pedido</button>
                </div>
            </form>
        </>
    );
}

export function OrderEditForm({ id: codeId }: Props) {
    const navigate = useNavigate();

    const [order, setOrder] = useState<Order>();

    useEffect(() => {
        axios.get(`/order/${codeId}`)
            .then((response) => {
                setOrder(response.data);
            });
    }, [codeId]);

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const orderDate = (event.target as any).orderDate.value;
        const distributor = (event.target as any).distributor.value;
        const packageType = (event.target as any).packageType.value;
        const categoryId = (event.target as any).categoryId.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "/order/update",
            method: "PUT",
            data: {
                code: codeId,
                orderDate: orderDate,
                distributor: distributor,
                packageType: packageType,
                categoryId: categoryId
            }
        }
        axios(config).then((response) => {
            navigate(`/order/${codeId}`);
        });
    }

    return (
        <form className="form-container" onSubmit={handleSubmit}>
            <div className="form-card-container">
                <div className="form-group gerencg-form-group">
                    <label htmlFor="orderDate">Data do Pedido: </label>
                    <input type="date" className="form-control" id="orderDate" />
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="distributor">Distribuidora: </label>
                    <input className="form-control" id="distributor" defaultValue={order?.distributor} />
                </div>
                <MeasureDatalist />
                <CategoryDatalist />
            </div>
            <div className="modal-footer">
                <button type="submit" className="btn-confirm">Editar Pedido</button>
            </div>
        </form>
    );
}

export function ItemAddForm({ id: codeId }: Props) {

    const navigate = useNavigate();
    const [order, setOrder] = useState<Order>();
    useEffect(() => {
        axios.get(`${BASE_URL}/order/${codeId}`)
            .then((response) => {
                setOrder(response.data);
            });
    }, [codeId]);

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const quantity = (event.target as any).quantity.value;
        const unitValue = (event.target as any).unitValue.value;
        const expense = (event.target as any).expense.value;
        const itemValidate = (event.target as any).itemValidate.value;
        const packageQuantity = (event.target as any).packageQuantity.value;
        const product = (event.target as any).product.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "/item/add",
            method: "POST",
            data: {
                orderCode: codeId,
                quantity: quantity,
                unitValue: unitValue,
                expense: expense,
                itemValidate: itemValidate,
                packageQuantity: packageQuantity,
                productDescription: product
            }
        }
        axios(config).then((response) => {
            navigate(`/order/${codeId}`);
        });
    }

    return (
        <>
            <form className="form-container" onSubmit={handleSubmit}>
                <span>CódigoPedido: {order?.code}</span>
                <div className="form-card-container" >
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="quantity">Quantidade em Unidades: </label>
                        <input id="quantity" type="text" className="form-control" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="packageQuantiy">Quantidade de Pacotes: </label>
                        <input id="packageQuantity" type="text" className="form-control" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="unitValue">Valor Unitário: </label>
                        <input id="unitValue" type="text" className="form-control" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="expense">Valor Total: </label>
                        <input id="expense" type="text" className="form-control" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="itemValidate">Validade: </label>
                        <input id="itemValidate" type="date" className="form-control" />
                    </div>
                    <ProductDatalist />
                </div>
                <div className="modal-footer">
                    <button type="submit" className="btn-confirm">Adicionar</button>
                </div>
            </form>
        </>
    );
}

export const ItemEditForm = ({ id: itemId }: Props) => {
    const navigate = useNavigate();

    const [item, setItem] = useState<Item>();
    useEffect(() => {
        axios.get(`${BASE_URL}/item/${itemId}`)
            .then((response) => {
                setItem(response.data);
            });
    }, [itemId]);


    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const quantity = (event.target as any).quantity.value;
        const unitValue = (event.target as any).unitValue.value;
        const expense = (event.target as any).expense.value;
        const itemValidate = (event.target as any).itemValidate.value;
        const packageQuantity = (event.target as any).packageQuantity.value;
        const product = (event.target as any).product.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "/item/edit",
            method: "PUT",
            data: {
                id: itemId,
                quantity: quantity,
                unitValue: unitValue,
                expense: expense,
                itemValidate: itemValidate,
                packageQuantity: packageQuantity,
                productDescription: product
            }
        }
        axios(config).then((response) => {
            navigate(`/item/${item}`)
        });
    }
    return (
        <form className="form-container" onSubmit={handleSubmit}>
            <div className="form-card-container">

                <div className="form-group gerencg-form-group">
                    <label htmlFor="quantity">Quantidade em Unidades: </label>
                    <input id="quantity" type="text" className="form-control" defaultValue={item?.quantity} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="packageQuantiy">Quantidade por Pacotes: </label>
                    <input id="packageQuantity" type="text" className="form-control" defaultValue={item?.packageQuantity} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="unitValue">Valor Unitário: </label>
                    <input id="unitValue" type="text" className="form-control" defaultValue={item?.unitValue} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="expense">Valor Total: </label>
                    <input id="expense" type="text" className="form-control" defaultValue={item?.expense} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="itemValidate">Validade: </label>
                    <input id="itemValidate" type="date" className="form-control" defaultValue={item?.itemValidate} />
                </div>
                <ProductDatalist />
            </div>
            <div className="modal-footer">
                <button type="submit" className="btn-confirm">Editar</button>
            </div>
        </form>
    );
}

export function OrderTagAddForm({ id: codeId }: Props) {
    const navigate = useNavigate();

    const [order, setOrder] = useState<Order>();
    useEffect(() => {
        axios.get(`${BASE_URL}/order/${codeId}`)
            .then((response) => {
                setOrder(response.data);
            });
    });

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const tagId = (event.target as any).tagId.value;

        const config: AxiosRequestConfig = {
            method: "POST",
            baseURL: BASE_URL,
            url: `/order-tag/add`,
            data: {
                codeId: codeId,
                tagId: tagId
            }

        }
        axios(config).then((response) => {
            navigate(`/order/${codeId}`)
        });
    }
    return (
        <>
            <form className="form-card-container" onSubmit={handleSubmit}>
                <TagDataList />
                <div className="modal-footer">
                    <button type="submit" className="btn-confirm">Adicionar</button>
                </div>
            </form>
        </>
    );
}

export function OrderStatsAddForm() {
    const navigate = useNavigate();
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const id = (event.target as any).id.value;
        const initialDate = (event.target as any).initialDate.value;
        const finalDate = (event.target as any).finalDate.value;

        const config: AxiosRequestConfig = {
            method: "POST",
            baseURL: BASE_URL,
            url: "/order-stats/save",
            data: {
                id: id,
                initialDate: initialDate,
                finalDate: finalDate
            }
        }
        axios(config).then((response) => {
            navigate(`/order-stats/${id}`);
        });
    }
    return (
        <>

            <form className="form-card-container" onSubmit={handleSubmit}>
             

                <div className="form-group gerencg-form-group">
                    <label htmlFor="initialDate">Data Inicial: </label>
                    <input id="initialDate" type="date" className="form-control" />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="finalDate">Data Final: </label>
                    <input id="finalDate" type="date" className="form-control" />
                </div>

                <div className="modal-footer">
                    <button type="submit" className="btn-confirm">Adicionar</button>
                </div>
            </form>
        </>
    );
}

export function OrderStatsEditForm({ id: statsId }: Props) {
    const navigate = useNavigate();

    const [stats, setStats] = useState<OrderStats>();
    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/${statsId}`)
            .then((response) => {
                setStats(response.data);
            });
    }, [statsId]);

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {

        
        const initialDate = (event.target as any).initialDate.value;
        const finalDate = (event.target as any).finalDate.value;

        const config: AxiosRequestConfig = {
            method: "PUT",
            baseURL: BASE_URL,
            url: "/order-stats/update",
            data: {
                id: statsId,
                initialDate: initialDate,
                finalDate: finalDate
            }
        }
        axios(config).then((response) => {
            navigate(`/order-stats/${statsId}`);
        });
    }
    return (
        <>

            <form className="form-card-container" onSubmit={handleSubmit}>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="id">Período: </label>
                    <input id="id" type="text" className="form-control" placeholder="01-2000" />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="initialDate">Data Inicial: </label>
                    <input id="initialDate" type="date" className="form-control" />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="finalDate">Data Final: </label>
                    <input id="finalDate" type="date" className="form-control" />
                </div>

                <div className="modal-footer">
                    <button type="submit" className="btn-confirm">Editar</button>
                </div>
            </form>
        </>
    );
}