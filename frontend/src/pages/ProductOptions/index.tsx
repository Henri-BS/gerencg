import {SaveProductForm, UpdateProductForm} from "components/container/ProductForm";
import { useParams } from "react-router-dom";
import "./styles.css"



export function SaveProduct() {
    return(
        <div className="container-blur">
            <SaveProductForm />
        </div>  
    )
}

export function UpdateProduct() {
    
    const params = useParams();
    return(
        <div className="container-blur">
            <UpdateProductForm productId={`${params.productId}`}/>
        </div>  
    )
}