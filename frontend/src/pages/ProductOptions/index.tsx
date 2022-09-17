import MeasureInfo from "components/container/MeasureInfo";
import {ProductFormAdd} from "components/container/ProductFormAdd";
import { ProductFormEdit } from "components/container/ProductFormEdit";
import { ProductMeasureList } from "pages/ListingProduct";
import { useParams } from "react-router-dom";
import "./styles.css"



export function SaveProduct() {
    return(
        <div className="container-blur">
            <ProductFormAdd />
        </div>  
    )
}

export function UpdateProduct() {
    
const params = useParams();

    return(
        <div className="container-blur">
            <ProductFormEdit productId={`${params.productId}`}/>
        </div>  
    )
}

export function MeasureProfile() {

    const params = useParams();

    return(
        <div className="container-blur">
            <div>
            <MeasureInfo measureId = {`${params.measureId}`} />
            </div>
            <ProductMeasureList measureId={`${params.measureId}`} />
        </div>  
    )
}
