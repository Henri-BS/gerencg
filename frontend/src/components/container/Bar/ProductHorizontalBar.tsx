
import IUpdateProduct from "assets/img/update.png"
import IDeleteProduct from "assets/img/delete-img.png"
import INotifications from "assets/img/notifications.png"
import "./styles.css"
import { Link, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { Product, ProductProps } from 'types/product';
import axios from 'axios';
import { BASE_URL } from 'utils/requests';

function ProductMenuBar({ productId }: ProductProps) {
    const navigate = useNavigate();
    const [product, setProduct] = useState<Product>();

    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then((response) => {
                setProduct(response.data);
            })
    }, [productId]);

    const deleteProduct = () => {

        axios.delete(`${BASE_URL}/product/delete/${productId}`)
            .then((response) => {
                setProduct(response.data);
                navigate("/product/list");
            })
    }

    const handleCLick = () => {
        axios(`${BASE_URL}/product/${productId}/notification`)
            .then((response) => {
                console.log("SUCESS")
            })
    }

    return (
        <div className="menu-profile-container">
            <Link to={`/product/edit/${productId}`}>
                <button className="menu-option-card" >
                    <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                    Editar produto
                </button>
            </Link>
            <button className="menu-option-card" onClick={() => deleteProduct()}>
                <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                Deletar produto
            </button>
            <button className="menu-option-card" onClick={() => handleCLick()}>
                <img className="option-card-img" src={INotifications} alt="notification" />
                Notificar
            </button>
        </div>
    );
}

export default ProductMenuBar;