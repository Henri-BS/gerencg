import axios from "axios";

import { useEffect, useState } from "react";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";
import "./styles.css"

type Props = {
    productId: string;
}

function ProductColumn({ productId }: Props) {

    const [product, setProduct] = useState<Product>()

    useEffect(() => {
        axios.get(`${BASE_URL}/product/${productId}`)
            .then(response => {
                setProduct(response.data);
            });
    }, [productId]);

    return (     
        
          <>  
          <div className="column-image-container">           
           <img className="column-card-image" src={product?.image} alt={product?.description} />    
</div>
        <div className="column-container">
        <div className="column-item-container">
                <h1>{ product?.description}</h1>
            </div>
          
            <div className="column-item-container">
                <h3>Preço: {product?.price.toFixed(2)} R$</h3>
            </div>
            <div className="column-item-container">
                <h3>Medida: {product?.measureValue} {product?.measure}</h3>
            </div>
            <div className="column-item-container">
                <h3>Quantidade: {product?.quantity}</h3>
            </div>
            <div className="column-item-container">
                <h3>Validade: {product?.validate} </h3>
            </div>
            <div className="column-item-container">
                <h3>Category: {product?.category} </h3>
            </div>
            </div>     
            
            </>
    );
}

export default ProductColumn;