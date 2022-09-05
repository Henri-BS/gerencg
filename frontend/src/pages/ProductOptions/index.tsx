import {SaveProductForm, UpdateProductForm} from "components/container/ProductForm";
import "./styles.css"



export function SaveProduct() {
    return(
        <div className="container-blur">
            <SaveProductForm />
        </div>  
    )
}

export function UpdateProduct() {
    
    return(
        <div className="container-blur">
            <UpdateProductForm />
        </div>  
    )
}