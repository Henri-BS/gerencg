
import IUpdateProduct from '../../../assets/img/update-product.png';
import IDeleteProduct from 'assets/img/delete-product.png';
import "./styles.css"
import { Link, useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { Product } from 'types/product';
import ProductService from 'service/ProductService';

function ProductMenuBar() {

    const [product, setProduct] = useState<Product>();
    const id  = product?.id;

    useEffect(() => {
        ProductService.findProductById(id as number)
            .then((response) => {
                setProduct(response.data);
            })
    }, [id]);

    return (
        <div className=" menu-profile-container">
            <Link to={`/product/edit/${id}`}>
                <button className="menu-option-card" >
                    <img className="option-card-img" src={IUpdateProduct} alt={product?.description} />
                    Editar produto
                </button>
            </Link>
            <button className="menu-option-card">
                <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                Deletar produto
            </button>
        </div>
    );
}

export default ProductMenuBar;