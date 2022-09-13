import axios, { AxiosRequestConfig } from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";

type Props = {
    productId: string;
}

export function ProductFormEdit({ productId }: Props) {

    //Edit Product 
    const [product, setProduct] = useState<Product>();

    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then((response) => {
                setProduct(response.data);
            })
    }, [productId])

    const navigate = useNavigate();

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        const description = (event.target as any).description.value;
        const image = (event.target as any).image.value;
        const price = (event.target as any).price.value;
        const quantity = (event.target as any).quantity.value;
        const validate = (event.target as any).validate.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: "PUT",
            url: "/history",
            data: {
                productId: productId,
                description: description,
                image: image,
                price: price,
                quantity: quantity,
                validate: validate
            },
        }
        axios(config).then(response => {
            navigate("/")
        })
        const productData = { description, image, price, quantity, validate };
        console.log(productData)
    };



    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Editar Produto</h3>

                <form className="gerencg-form" onSubmit={handleSubmit}>
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
            </div>
        </div>
    );
}