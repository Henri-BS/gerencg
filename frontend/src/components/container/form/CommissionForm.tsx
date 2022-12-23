import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link, Navigate } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { Code, CodeProps, Item, ItemProps } from "types/commission";
import { MeasurePage } from "types/measure";
import { ProductPage } from "types/product";
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
        <form className="form-container" onSubmit={handleSubmit}>
            <div className="form-card-container">
                <div className="form-group gerencg-form-group">
                    <label htmlFor="code">Código do Pedido: </label>
                    <input className="form-control" id="code" placeholder="00.00.0000.00-aa" />
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="commissionDate">Data do Pedido: </label>
                    <input type="date" className="form-control" id="commissionDate" />
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="distributor">Distribuidora: </label>
                    <input className="form-control" id="distributor" />
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
            </div>
            <div className="modal-footer">
                <button className="text-close">cancelar</button>
                <button type="submit" className="btn-confirm">Adicionar Pedido</button>
            </div>

        </form>
    );
}

export function EditCommissionForm({ codeId }: CodeProps) {
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


    const [commission, setCommission] = useState<Code>();

    useEffect(() => {
        axios.get(`/commmission/${codeId}`)
            .then((response) => {
                setCommission(response.data);
            })
    }, [codeId])

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const commissionDate = (event.target as any).commissionDate.value;
        const distributor = (event.target as any).distributor.value;
        const packageType = (event.target as any).packageType.value;


        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "/update-commission",
            method: "PUT",
            data: {
                code: codeId,
                commissionDate: commissionDate,
                distributor: distributor,
                packageType: packageType
            }
        }
        axios(config).then((response) => {
            navigate(`/commission/${codeId}`)
        });
    }

    return (
        <form className="form-container" onSubmit={handleSubmit}>
            <div className="form-card-container">
                <div className="form-group gerencg-form-group">
                    <label htmlFor="commissionDate">Data do Pedido: </label>
                    <input type="date" className="form-control" id="commissionDate" />
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="distributor">Distribuidora: </label>
                    <input className="form-control" id="distributor" placeholder="ex: Comercial Novo" defaultValue={commission?.distributor} />
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
            </div>
            <div className="modal-footer">
                <button className="text-close">cancelar</button>
                <button type="submit" className="btn-confirm">Editar Pedido</button>
            </div>
        </form>
    );
}


//Item Forms
export function AddItemForm({ codeId }: CodeProps) {
    const navigate = useNavigate();
    const [commission, setCommission] = useState<Code>();
    useEffect(() => {
        axios.get(`${BASE_URL}/commission/${codeId}`)
            .then((response) => {
                setCommission(response.data);
            });
    }, [codeId]);

    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        number: 0,
    })
    const [value, setValue] = useState("");
    useEffect(() => {
        axios.get(`${BASE_URL}/product-search?description=${value}`)
            .then(response => {
                setProductPage(response.data);
            });
    }, [value])


    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
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
                commissionCode: codeId,
                quantity: quantity,
                unitValue: unitValue,
                totalValue: totalValue,
                itemValidate: itemValidate,
                packageQuantity: packageQuantity,
                productDescription: product
            }
        }
        axios(config).then((response) => {
            navigate(`/commission/${codeId}`)
        })
    }

    return (
        <>
            <form className="form-container" onSubmit={handleSubmit}>
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
                        <label htmlFor="totalValue">Valor Total: </label>
                        <input id="totalValue" type="text" className="form-control" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="itemValidate">Validade: </label>
                        <input id="itemValidate" type="text" className="form-control" />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="product">Produto: </label>
                        <input type="text" list="productDescription" value={value} onChange={(e) => setValue(e.target.value)} id="product" className="form-control" placeholder="busque pelo produto..." />
                        <datalist id="productDescription" >
                            {productPage.content?.filter((product) =>
                                product.description.toLowerCase().includes(value.toLocaleLowerCase()))
                                .map((product) => (
                                    <option id="value" key={product.id} value={product.description}>
                                        {product.description} - {product.measureValue} {product.measure}
                                    </option>
                                ))}
                        </datalist>
                    </div>
                </div>
                <div className="modal-footer">
                    <button className="text-close">cancelar</button>
                    <button type="submit" className="btn-confirm">Adicionar</button>
                </div>
            </form>
        </>
    );
}

export const EditItemForm = ({ itemId }: ItemProps) => {
    const navigate = useNavigate();

    const [item, setItem] = useState<Item>();
    useEffect(() => {
        axios.get(`${BASE_URL}/item/${itemId}`)
            .then((response) => {
                setItem(response.data);
            })
    }, [itemId])

    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        number: 0,
    })
    const [value, setValue] = useState("");
    useEffect(() => {
        axios.get(`${BASE_URL}/product-search?description=${value}`)
            .then(response => {
                setProductPage(response.data);
            });
    }, [value])


    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const quantity = (event.target as any).quantity.value;
        const unitValue = (event.target as any).unitValue.value;
        const totalValue = (event.target as any).totalValue.value;
        const itemValidate = (event.target as any).itemValidate.value;
        const packageQuantity = (event.target as any).packageQuantity.value;
        const product = (event.target as any).product.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "/update-item",
            method: "PUT",
            data: {
                id: itemId,
                quantity: quantity,
                unitValue: unitValue,
                totalValue: totalValue,
                itemValidate: itemValidate,
                packageQuantity: packageQuantity,
                productDescription: product
            }
        }
        axios(config).then((response) => {
            navigate(`/item/${item}`)
        })
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
                    <label htmlFor="totalValue">Valor Total: </label>
                    <input id="totalValue" type="text" className="form-control" defaultValue={item?.totalValue} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="itemValidate">Validade: </label>
                    <input id="itemValidate" type="text" className="form-control" defaultValue={item?.itemValidate} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="product">Produto: </label>
                    <input type="text" list="productDescription" value={value} onChange={(e) => setValue(e.target.value)} id="product" className="form-control" placeholder="busque pelo produto..." />
                    <datalist id="productDescription" >
                        {productPage.content?.filter((product) =>
                            product.description.toLowerCase().includes(value.toLocaleLowerCase()))
                            .map((product) => (
                                <option id="value" key={product.id} value={product.description}>
                                    {product.description} - {product.measureValue} {product.measure}
                                </option>
                            ))}
                    </datalist>
                </div>
               
            </div> 
            <div className="modal-footer">
                    <button className="text-close" data-bs-dismiss="modal">cancelar</button>
                    <button type="submit" className="btn-confirm">Editar</button>
                </div>
        </form>
    );
}