import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { CategoryPage } from "types/category";
import { MeasurePage } from "types/measure";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";

export function ProductFormEdit(){

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
    
    const [product, setProduct] = useState<Product>();
    const [msg, setMsg] = useState('')
    const editProduct = () => {
        console.log("data:", product);
        const productData = {
            id: (product?.id),
            description: product?.description,
            image: product?.image,
            price: product?.price,
            quantity: product?.quantity,
            validate: product?.validate,
            measureValue: product?.measureValue,
            measure: product?.measure,
            category: product?.category
        }
        axios.put(`${BASE_URL}/product/edit/${product?.id}`, productData)
        .then((response) => {
            console.log("Sucess")
            setProduct(response.data);
            setMsg("Produto Editado")
        }).catch(() => {
            setMsg("Erro")
        })
    }

    const navigate = useNavigate();
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const id = (event.target as any).id.value;
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
            method: "put",
            url: "/product/edit",
            data: {
                id: id,
                description: description,
                image: image,
                price: price,
                quantity: quantity,
                validate: validate,
                measureValue: measureValue,
                measure: measure,
                category: category
            },
        };
        axios(config).then(response => {
            navigate("/product/list");
        });    
    }
    
    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Editar Produto</h3>
    
                <form className="gerencg-form" onSubmit={handleSubmit}>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="description">Descrição: </label>
                        <input type="text" className="form-control" id="description" />
                    </div>
    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="image">Image: </label>
                        <input type="text" className="form-control" id="image" />
                    </div>
    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="price">Preço: </label>
                        <input className="form-control" id="price" />
                    </div>
    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="quantity">Quantidade: </label>
                        <input type="number" className="form-control" id="quantity" />
                    </div>
    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="validate">Validade: </label>
                        <input type="text" className="form-control" id="validate" />
                    </div>
    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measureValue">Valor de Medida: </label>
                        <input className="form-control" id="measureValue" />
                    </div>
    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measure">Tipo de Medida: </label>
                        <select className="form-control" id="measure">
                            {measureList.content?.map(item => (
                                <option key={item.abbreviation}>
                                    {item.abbreviation}
                                </option>
                            ))}
                        </select>
                    </div>
    
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="category">Categoria: </label>
                        <select className="form-control" id="category">
                            {categoryList.content?.map(item => (
                                <option key={item.name}>
                                    {item.name}
                                </option>
                            ))}
                        </select>
                    </div>
    
                    <div className="form-btn-container">
                        <button type="submit" className=" gerencg-btn" onClick={() => editProduct()}>
                            Editar Produto
                        </button>
                    </div>

                    <Link className="form-btn-container" to={`/product/${product?.id}`}>
                        <button className=" gerencg-btn mt-3">
                            Cancelar
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