import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import ProductService from "service/ProductService";
import { CategoryPage } from "types/category";
import { MeasurePage } from "types/measure";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";


export function ProductFormEdit() {

    //Get MeasureList for the measure type selector        
    const [measureList, setMeasureList] = useState<MeasurePage>({
        content: []
    })
    useEffect(() => {
        axios.get(`${BASE_URL}/measure/list`)
            .then((response) => {
                setMeasureList(response.data);
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
    const [product, setProduct] = useState<Product>();

    const id = product?.id;
    const [description, setDescription] = useState('');
    const [image, setImage] = useState('');
    const [price, setPrice] = useState('');
    const [quantity, setQuantity] = useState('');
    const [validate, setValidate] = useState('');
    const [measureValue, setMeasureValue] = useState('');
    const [measure, setMeasure] = useState('');
    const [category, setCategory] = useState('');


    const productData = { id, description, image, price, quantity, validate, measureValue, measure, category };
    const navigate = useNavigate();

    function handleSubmit(event: React.MouseEvent<HTMLButtonElement, MouseEvent>) {
        event.preventDefault();

        if (
            productData.description !== product?.description &&
            productData.image !== product?.image &&
            productData.price !== product?.price.toFixed(2) &&
            productData.quantity !== product?.quantity.toFixed(0) &&
            productData.validate !== product?.validate &&
            productData.measureValue !== product?.measureValue.toFixed(2) &&
            productData.measure !== product?.measure.abbreviation &&
            productData.category !== product?.category.name) {

                ProductService.updateProduct(id as number, productData)
                    .then((response) =>{
                        setProduct(response.data)
                    })
                    .catch((event: any) => console.log(event));
                navigate("/product/list")

        } else {
            alert("Porfavor, complete as inserções");
        }
    };

    useEffect(() => {
        if (id as number) {
            ProductService.findProductById(id as number)
                .then((response) => {
                    setDescription(response.data.description);
                    setImage(response.data.image);
                    setPrice(response.data.price);
                    setQuantity(response.data.quantity);
                    setValidate(response.data.validate);
                    setMeasureValue(response.data.measureValue);
                    setMeasure(response.data.measure);
                    setCategory(response.data.category);
                })
                .catch(event => console.log(event));
        }
    }, [id])

    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Editar Produto</h3>

                <form className="gerencg-form">
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="description">Descrição: </label>
                        <input
                            type="text"
                            className="form-control"
                            id="description"
                            onChange={(event) => setDescription(event.target.value)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="image">Image: </label>
                        <input
                            type="text"
                            className="form-control"
                            id="image"
                            onChange={(event) => setImage(event.target.value)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="price">Preço: </label>
                        <input
                            className="form-control"
                            id="price"
                            onChange={(event) => setPrice(event.target.value)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="quantity">Quantidade: </label>
                        <input
                            type="number"
                            className="form-control"
                            id="quantity"
                            onChange={(event) => setQuantity(event.target.value)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="validate">Validade: </label>
                        <input
                            type="text"
                            className="form-control"
                            id="validate"
                            placeholder="aaaa-mm-dd"
                            onChange={(event) => setValidate(event.target.value)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measureValue">Valor de Medida: </label>
                        <input
                            className="form-control"
                            id="measureValue"
                            onChange={(event) => setMeasureValue(event.target.value)}
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measure">Tipo de Medida: </label>
                        <select
                            className="form-control"
                            id="measure"
                            onChange={(event) => setDescription(event.target.value)}
                        >
                            {measureList.content?.map(item => (
                                <option
                                    key={item.abbreviation}>
                                    {item.abbreviation}
                                </option>
                            ))}
                        </select>
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="category">Categoria: </label>

                        <select
                            className="form-control"
                            id="category"
                            onChange={(event) => setDescription(event.target.value)}
                        >
                            {categoryList.content?.map(item => (
                                <option key={item.name}>
                                    {item.name}
                                </option>
                            ))}
                        </select>

                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className=" gerencg-btn" onClick={(event) => handleSubmit(event)}>
                            Editar Produto
                        </button>
                    </div>

                    <Link className="form-btn-container" to={`/product/${id}`}>
                        <button className=" gerencg-btn mt-3">
                            Retornar
                        </button>
                    </Link>
                </form>
            </div>
        </div>
    );
}