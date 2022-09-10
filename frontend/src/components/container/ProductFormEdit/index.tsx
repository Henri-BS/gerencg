import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import  ProductService  from "service/ProductService";
import { CategoryPage } from "types/category";
import { MeasurePage } from "types/measure";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";



type Props = {
    productId: string
}

export function ProductFormEdit({ productId }: Props) {

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

    const [msg, setMsg] = useState('')
    const [product, setProduct] = useState<Product>();
    const { id } = useParams();
    const [description, setDescription] = useState('');
    const [image, setImage] = useState('');
    const [price, setPrice] = useState('');
    const [quantity, setQuantity] = useState('');
    const [validate, setValidate] = useState('');
    const [measureValue, setMeasureValue] = useState('');
    const [measure, setMeasure] = useState('');
    const [category, setCategory] = useState('');


    const productData = { description, image, price, quantity, validate, measureValue, measure, category };
    const navigate = useNavigate();

    function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault();

        if (
            productData.description !== "" &&
            productData.image !== "" &&
            productData.price !== "" &&
            productData.quantity !== "" &&
            productData.validate !== "" &&
            productData.measureValue !== "" &&
            productData.measure !== "" &&
            productData.category !== "") {

            if (id) {
                ProductService.updateProduct(id, productData)
                  //  .then(navigate("product/list"))
                    .catch((event: any) => console.log(event));
            } else {
                ProductService.saveProduct(productData)
                //.then(navigate("/product/list"))
                .catch((event: any) => console.log(event));
            }
        } else {
            alert("Porfavor, complete as inserções");
        }
    };
useEffect (() => {
    if(id) {
        ProductService.findProductById(id)
        .then((response) => {
            setDescription(response.data.description);
            setImage(response.data.image);
        })
        .catch(event => console.log(event));
    }
})
   
    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Editar Produto</h3>

                <form
                    className="gerencg-form"
                    
                >

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="description">Descrição: </label>
                        <input
                            type="text"
                            className="form-control"
                            id="description"
                            
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="image">Image: </label>
                        <input
                            type="text"
                            className="form-control"
                            id="image"
                            
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="price">Preço: </label>
                        <input
                            className="form-control"
                            id="price"
                            
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="quantity">Quantidade: </label>
                        <input
                            type="number"
                            className="form-control"
                            id="quantity"
                            
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="validate">Validade: </label>
                        <input
                            type="text"
                            className="form-control"
                            id="validate"
                            placeholder="aaaa-mm-dd"
                            
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measureValue">Valor de Medida: </label>
                        <input
                            className="form-control"
                            id="measureValue"
                        />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="measure">Tipo de Medida: </label>
                        <select
                            className="form-control"
                            id="measure"

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

                        >
                            {categoryList.content?.map(item => (
                                <option key={item.name}>
                                    {item.name}
                                </option>
                            ))}
                        </select>

                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className=" gerencg-btn" >
                            Editar Produto
                        </button>
                    </div>

                    <Link className="form-btn-container" to={`/product/${productId}`}>
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