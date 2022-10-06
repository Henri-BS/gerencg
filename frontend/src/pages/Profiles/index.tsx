import ProductLateralBar from "components/container/LateralBar/ProductLateralBar";
import { useParams } from "react-router-dom";
import "./styles.css"
import ProductMenuBar from "components/container/HorizontalBar/ProductHorizontalBar";
import { ProductCategoryList, ProductMeasureList } from "pages/Listings";
import CategoryLateralBar from "components/container/LateralBar/CategoryLateralBar";
import { MeasureInfo } from "components/container/Card/MeasureCard";
import { ProductFormEdit } from "components/container/Form/ProductFormEdit";
import { ProductFormAdd } from "components/container/Form/ProductFormAdd";

//Product profile 
export function ProductProfile() {
  const params = useParams();

  return (
    <>
      <div className="profile row">

        <div className="col-12 col-md-12 col-lg-6 col-xl-4 p-0">
          < ProductLateralBar productId={`${params.productId}`} />
        </div>

        <div className="col-12 col-md-12 col-lg-6 col-xl-8  p-0">
          <ProductMenuBar productId={`${params.productId}`} />

        </div>
      </div>
    </>
  );

}

//Category Profile Function
export function CategoryProfile() {

  const params = useParams();
  return (
    <>
      <div className="profile row">
        <div className="col-6-sm col-md-6 col-lg-4 p-0">
          <CategoryLateralBar categoryId={`${params.categoryId}`} />
        </div>
        <div className="col-6-sm col-md-6 col-lg-8 p-0">
          <ProductCategoryList categoryId={`${params.categoryId}`} />
        </div>
      </div>
    </>
  );
}


export function SaveProduct() {

  return(
      <div className="container-blur">
          <ProductFormAdd />
      </div>  
  );
}

export function UpdateProduct() {

const params = useParams();

  return(
      <div className="container-blur">
          <ProductFormEdit productId={`${params.productId}`}/>
      </div>  
  );
}

export function MeasureProfile() {

  const params = useParams();

  return(
      <div className="container-blur">
          <div>
          <MeasureInfo measureId={`${params.measureId}`} />
          </div>
          <ProductMeasureList measureId={`${params.measureId}`} />
      </div>  
  );
}

