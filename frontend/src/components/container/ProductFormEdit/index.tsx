import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { CategoryPage } from "types/category";
import { MeasurePage } from "types/measure";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";

export function ProductFormEdit() {



    //Get MeasureList for the measure type selector        
    const [measureList, setMeasure] = useState<MeasurePage>({
        content: []
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
        axios.get(`${BASE_URL}/category/list`)
            .then((response) => {
                setCategoryList(response.data);
            })
    }, [])

    //Edit Product 
    const [msg, setMsg] = useState('')
    const [product, setProduct] = useState({
        description: "", 
        price: "",
        quantity: "", 
        validate: "", 
        measureValue: "", 
        measure: "", 
        category: ""
    });    
const {id} = useParams();
    const {description, price, quantity, validate, measureValue, measure, category} = product; 
        
    const onInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setProduct({...product, [event.target.name]: event.target.value });
    };

    useEffect(() => {
        loadProduct();
    }, []);

    const navigate = useNavigate();
    
    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        await axios.put(`${BASE_URL}/product/edit/${id}`, product)
           
            navigate("/product/list");
    };

const loadProduct = async () => {
    const response = await axios.get(`${BASE_URL}/product/${id}`);
    setProduct(response.data)
}
    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Editar Produto</h3>

                <form className="gerencg-form" onSubmit={(event) =>handleSubmit(event)}>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="description">Descrição: </label>
                        <input 
                        type="text" 
                        className="form-control" 
                        id="description" 
                        value={description}
                        onChange={(event) => onInputChange(event)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="image">Image: </label>
                        <input 
                        type="text" 
                        className="form-control" 
                        id="image" 
                        onChange={(event) => onInputChange(event)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="price">Preço: </label>
                        <input 
                        className="form-control" 
                        id="price" 
                        onChange={(event) => onInputChange(event)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="quantity">Quantidade: </label>
                        <input 
                        type="number" 
                        className="form-control" 
                        id="quantity" 
                        onChange={(event) => onInputChange(event)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="validate">Validade: </label>
                        <input 
                        type="text" 
                        className="form-control" 
                        id="validate" 
                        onChange={(event) => onInputChange(event)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measureValue">Valor de Medida: </label>
                        <input 
                        className="form-control" 
                        id="measureValue" 
                        onChange={(event) => onInputChange(event)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measure">Tipo de Medida: </label>
                        <input onChange={(event) => onInputChange(event)}>
                        <select 
                        className="form-control" 
                        id="measure">                            
                            {measureList.content?.map(item => (
                                <option 
                                key={item.abbreviation}>
                                    {item.abbreviation}
                                </option>
                            ))}
                        </select>
                        </input> 
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="category">Categoria: </label>
                        <input onChange={(event) => onInputChange(event)}>
                        <select className="form-control" id="category">
                            {categoryList.content?.map(item => (
                                <option key={item.name}>
                                    {item.name}
                                </option>
                            ))}
                        </select>
                        </input>
                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className=" gerencg-btn" >
                            Editar Produto
                        </button>
                    </div>

                    <Link className="form-btn-container" to={`/product/${id}`}>
                        <button className=" gerencg-btn mt-3">
                            Retornar
                        </button>
                    </Link>
                </form>

                <div className="msg-container">
                    <h3>{msg}</h3>
                </div>
            </div>
        </div>
    );
}