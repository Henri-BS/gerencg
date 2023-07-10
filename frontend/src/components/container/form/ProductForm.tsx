import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { CategoryPage } from "types/category";
import { MeasurePage } from "types/measure";
import { Props } from "types/page";
import { Product, ProductHistory } from "types/product";
import { BASE_URL } from "utils/requests";

export function AddProductForm() {
    const navigate = useNavigate();

    //Get MeasueList for the measure type selector        
    const [measureList, setMeasure] = useState<MeasurePage>({ content: [], number: 0 })
    useEffect(() => {
        axios.get(`${BASE_URL}/measure/list`)
            .then((response) => {
                setMeasure(response.data);
            })
    }, [])

    //Get CategoryList for the category selector    
    const [categoryList, setCategoryList] = useState<CategoryPage>({ content: [], number: 0 })
    useEffect(() => {
        axios.get(`${BASE_URL}/category/list`)
            .then((response) => {
                setCategoryList(response.data);
            })
    }, [])


    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const description = (event.target as any).description.value;
        const image = (event.target as any).image.value;
        const price = (event.target as any).price.value;
        const quantity = (event.target as any).quantity.value;
        const validate = (event.target as any).validate.value;
        const measureValue = (event.target as any).measureValue.value;
        const measure = (event.target as any).measure.value;
        const category = (event.target as any).category.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: "POST",
            url: "/product/add",
            data: {
                description: description,
                image: image,
                price: price,
                quantity: quantity,
                validate: validate,
                measureValue: measureValue,
                measure: measure,
                category: category
            }
        };
        axios(config).then(response => {
            navigate("/product/list");
    })
    }

    return (
            <form className="form-lg-card-container m-0 row" onSubmit={handleSubmit}>
                <div className="form-group gerencg-form-group col-6">
                    <label htmlFor="description">Descrição: </label>
                    <input type="text" className="form-control" id="description" />
                </div>

                <div className="form-group gerencg-form-group col-6">
                    <label htmlFor="image">Imagem: </label>
                    <input type="text" className="form-control" id="image" />
                </div>

                <div className="form-group gerencg-form-group col-6">
                    <label htmlFor="price">Preço: </label>
                    <input className="form-control" id="price" />
                </div>

                <div className="form-group gerencg-form-group col-6">
                    <label htmlFor="quantity">Quantidade: </label>
                    <input type="text" className="form-control" id="quantity" />
                </div>

                <div className="form-group gerencg-form-group col-6">
                    <label htmlFor="validate">Validade: </label>
                    <input type="date" className="form-control" id="validate" />
                </div>

                <div className="form-group gerencg-form-group col-6">
                    <label htmlFor="measureValue">Valor de Medida: </label>
                    <input className="form-control" id="measureValue" />
                </div>

                <div className="form-group gerencg-form-group col-6">
                    <label htmlFor="measure">Tipo de Medida: </label>
                    <select className="form-control" id="measure">
                        {measureList.content?.map(item => (
                            <option key={item.abbreviation}>
                                {item.abbreviation}
                            </option>
                        ))}
                    </select>
                </div>

                <div className="form-group gerencg-form-group col-6">
                    <label htmlFor="category">Categoria: </label>
                    <select className="form-control" id="category">
                        {categoryList.content?.map(item => (
                            <option key={item.name}>
                                {item.name}
                            </option>
                        ))}
                    </select>
                </div>

            
            <div className="modal-footer">
                <button type="button" className="text-close" data-bs-dismiss="modal">cancelar</button>
                <button type="submit" className="btn-confirm">Adicionar Produto</button>
         </div>
        </form>
    );
}

export function ProductFormEdit ({id: productId }: Props) {

    //Get MeasureList for the category selector    
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

    //Get CategoryList for the category selector    
    const [categoryList, setCategoryList] = useState<CategoryPage>({
        content: [],
        number: 0
    })
    useEffect(() => {
        axios.get(`${BASE_URL}/category/list?sort=name`)
            .then((response) => {
                setCategoryList(response.data);
            })
    }, [])

    //Get Product 
    const [product, setProduct] = useState<Product>();
    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then((response) => {
                setProduct(response.data);
            })
    }, [productId])

    //Creating submission event for html form to update the product
    const navigate = useNavigate();
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {

        const description = (event.target as any).description.value;
        const price = (event.target as any).price.value;
        const quantity = (event.target as any).quantity.value;
        const validate = (event.target as any).validate.value;
        const measureValue = (event.target as any).measureValue.value;
        const measure = (event.target as any).measure.value;
        const category = (event.target as any).category.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: "PUT",
            url: "/product/edit",
            data: {
                id: productId,
                description: description,
                price: price,
                quantity: quantity,
                validate: validate,
                measureValue: measureValue,
                measure: measure,
                category: category
            },
        }
        axios(config).then((response) => {
            navigate(`/product/${productId}`)
        })
    };

    return (
        <form className="form-container" onSubmit={handleSubmit}>
            <div className="form-card-container">
                <div className="form-group gerencg-form-group">
                    <label htmlFor="description">Descrição: </label>
                    <input className="form-control" id="description" defaultValue={product?.description} placeholder={product?.description} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="price">Preço: </label>
                    <input className="form-control" id="price" defaultValue={product?.price} placeholder={product?.price.toString()} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="quantity">Quantidade: </label>
                    <input className="form-control" id="quantity" defaultValue={product?.quantity} placeholder={product?.quantity.toString()} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="validate">Validade: </label>
                    <input type="date" className="form-control" id="validate" defaultValue={product?.validate} placeholder={product?.validate} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="measureValue">Valor de Medida: </label>
                    <input className="form-control" id="measureValue" defaultValue={product?.measureValue} />
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="measure">Tipo de Medida: ({product?.measure})</label>
                    <select className="form-control" id="measure">
                        {measureList.content?.map(x => (
                            <option key={x.abbreviation} defaultValue={x.abbreviation}>
                                {x.abbreviation}
                            </option>
                        ))}
                    </select>
                </div>

                <div className="form-group gerencg-form-group">
                    <label htmlFor="category">Categoria: ({product?.category}) </label>
                    <select  className="form-control" id="category">
                        {categoryList.content?.map(x => (
                            <option key={x.name}  >{x.name}</option>
                        ))}
                    </select>
                </div>

            </div> <div className="modal-footer">
                <button type="button" className="text-close" data-bs-dismiss="modal">cancelar</button>
                <button type="submit" className="btn-confirm">Editar Produto</button>
            </div>
        </form>
    );
}

export function SaveValuesHistory({id: productId }: Props) {

    const [product, setProduct] = useState<Product>();
    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then((response) => {
                setProduct(response.data);
            });
    }, [productId]);

    const navigate = useNavigate();
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "/history/save-product",
            method: "POST",
            data: {
                productId: productId,
            }
        }
        axios(config).then((response) => {
            navigate(`/product/${productId}`)
        });
    }

    return (
        <form className="form-container" onSubmit={handleSubmit}>
            <div className="form-card-container">
                <div className="form-group gerencg-form-group">
                    <label htmlFor="product">Produto: {product?.description}</label>
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="quantity">Quantidade: {product?.quantity}</label>
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="price">Price: {product?.price}</label>
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="validate">Validade: {product?.validate}</label>
                </div>
            </div>
            <div className="modal-footer">
                <button className="text-close">cancelar</button>
                <button type="submit" className="btn-confirm">Salvar</button>
            </div>
        </form>
    );
}

export function EditHistoryForm({id: historyId }: Props) {

    const [history, setHistory] = useState<ProductHistory>();
    useEffect(() => {
        axios.get(`${BASE_URL}/history/${historyId}`)
            .then((response) => {
                setHistory(response.data);
            });
    }, [historyId]);

    const navigate = useNavigate();
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const price = (event.target as any).price.value;
        const quantity = (event.target as any).quantity.value;
        const validate = (event.target as any).validate.value;
        const dateCreated = (event.target as any).dateCreated.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "history/update",
            method: "PUT",
            data: {
                id: historyId,
                price: price,
                quantity: quantity,
                validate: validate,
                createdDate: dateCreated
            }
        }
        axios(config).then((response) => {
            navigate(`/history/${historyId}`)
        });
    }

    return (
        <form onSubmit={handleSubmit} className="form-container">
            <div className="form-card-container">
                <div className="form-group gerencg-form-group">
                    <label htmlFor="price">Preço</label>
                    <input className="form-control" id="price" defaultValue={history?.price} />
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="quantity">Quantidade em estoque</label>
                    <input className="form-control" id="quantity" defaultValue={history?.quantity} />
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="validate">Validate</label>
                    <input type="date" className="form-control" id="validate" defaultValue={history?.validate} />
                </div>
                <div className="form-group gerencg-form-group">
                    <label htmlFor="dateCreated">Data de Registro</label>
                    <input type="date" className="form-control" id="dateCreated" defaultValue={history?.dateCreated} />
                </div>
            </div>
            <div className="modal-footer">
                <button type="submit" className="btn-confirm" >Editar</button>
            </div>
        </form>
    );
}