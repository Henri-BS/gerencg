import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { Item } from "types/commission";
import { MeasurePage } from "types/measure";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css";


export function AddCommissionForm() {
    const navigate = useNavigate();

    //Get MeasureList for the measure type selector        
    const [measureList, setMeasure] = useState<MeasurePage>({
        content: [],
        number: 0,
        totalElements: 0,
        totalPages: 0
    })
    useEffect(() => {
        axios.get(`${BASE_URL}/measure/list`)
            .then((response) => {
                setMeasure(response.data);
            })
    }, [])

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const code = (event.target as any).code.value;
        const commissionDate = (event.target as any).commissionDate.value;
        const distributor = (event.target as any).distributor.value;
        const packageType = (event.target as any).packageType.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "/save-commission",
            method: "POST",
            data: {
                code: code,
                commissionDate: commissionDate,
                distributor: distributor,
                packageType: packageType
            }
        }
        axios(config).then((response) => {
            navigate("/commission-list");
        })
    }
    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Resgistrar um novo pedido</h3>
                <form className="gerencg-form" onSubmit={handleSubmit}>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="code">Código do Pedido: </label>
                        <input
                            type="text"
                            className="form-control"
                            id="code"
                            placeholder="ex: 00.00.0000.00-aa"
                        />
                    </div>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="commissionDate">Data do Pedido: </label>
                        <input
                            type="text"
                            className="form-control"
                            id="commissionDate"
                        />
                    </div>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="distributor">Distribuidora: </label>
                        <input
                            type="text"
                            className="form-control"
                            id="distributor"
                            placeholder="ex: Comercial Novo"
                        />
                    </div>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="packageType">Tipo de Pacote: </label>
                        <select className="form-control" id="packageType">
                            {measureList.content?.map(item => (
                                <option key={item.abbreviation}>
                                    {item.abbreviation}
                                </option>
                            ))}
                        </select>
                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className="gerencg-btn" >
                            Registrar Pedido
                        </button>
                    </div>

                    <Link to="/commission-list">
                        <h5 className=" form-links mt-5">Ir para a Lista de Pedidos</h5>
                    </Link>
                </form>
            </div>
        </div>
    );
}

export function AddItemForm() {
    const [productPage, setProductPage] = useState<Product[]>();
    const navigate = useNavigate();
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const commissionCode = (event.target as any).commissionCode.value;
        const quantity = (event.target as any).quantity.value;
        const unitValue = (event.target as any).unitValue.value;
        const totalValue = (event.target as any).totalValue.value;
        const itemValidate = (event.target as any).itemValidate.value;
        const packageQuantity = (event.target as any).packageQuantity.value;
        const product = (event.target as any).product.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "/save-item",
            method: "POST",
            data: {
                commissionCode: commissionCode,
                quantity: quantity,
                unitValue: unitValue,
                totalValue: totalValue,
                itemValidate: itemValidate,
                packageQuantity: packageQuantity,
                product: product
            }
        }

        axios(config).then((response) => {
            navigate(`/commission/${commissionCode}`);
        })
    }

    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Adicionar um item ao pedido</h3>
                <form className="gerencg-form" onSubmit={handleSubmit}>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="commissionCode">Código do Pedido: </label>
                        <input id="commissionCode" type="text" className="form-control"/>
                    </div>
                    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="quantity">Quantidade em Unidades: </label>
                        <input id="quantity" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="packageQuantiy">Quantidade por Pacotes: </label>
                        <input id="packageQuantity" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="unitValue">Valor por Unidade: </label>
                        <input id="unitValue" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="totalValue">Valor Total: </label>
                        <input id="totalValue" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="itemValidate">Validade: </label>
                        <input id="itemValidate" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="product">Produto: </label>
                        <input id="product" type="text" className="form-control"/>
                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className="gerencg-btn" >Adicionar</button>
                    </div>

                </form>  <Link to="/commission-list">
                    <h5 className=" form-links mt-5">Ir para a Lista de Pedidos</h5>
                </Link>
            </div>
        </div>
    );
} 

export const EditItemForm = () => {
    const [item, setItem] = useState<Item>();
    const navigate = useNavigate(); 

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const commissionCode = (event.target as any).commissionCode.value;
        const quantity = (event.target as any).quantity.value;
        const unitValue = (event.target as any).unitValue.value;
        const totalValue = (event.target as any).totalValue.value;
        const itemValidate = (event.target as any).itemValidate.value;
        const packageQuantity = (event.target as any).packageQuantity.value;
        const product = (event.target as any).product.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: `update/item`,
            method: "PUT",
            data: {
                commissionCode: commissionCode,
                quantity: quantity,
                unitValue: unitValue,
                totalValue: totalValue,
                itemValidate: itemValidate,
                packageQuantity: packageQuantity,
                product: product
            }
        }
        axios(config).then((response) => {
            navigate(`/item/${item}`)
        })
    }
    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Alterar o item do pedido</h3>
                <form className="gerencg-form" onSubmit={handleSubmit}>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="commissionCode">Código do Pedido: </label>
                        <input id="commissionCode" type="text" className="form-control"/>
                    </div>
                    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="quantity">Quantidade em Unidades: </label>
                        <input id="quantity" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="packageQuantiy">Quantidade por Pacotes: </label>
                        <input id="packageQuantity" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="unitValue">Valor por Unidade: </label>
                        <input id="unitValue" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="totalValue">Valor Total: </label>
                        <input id="totalValue" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="itemValidate">Validade: </label>
                        <input id="itemValidate" type="text" className="form-control"/>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="product">Produto: </label>
                        <input id="product" type="text" className="form-control"/>
                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className="gerencg-btn" >Editar</button>
                    </div>

                </form>  <Link to="/commission-list">
                    <h5 className=" form-links mt-5">Ir para a Lista de Pedidos</h5>
                </Link>
            </div>
        </div>
    );
}