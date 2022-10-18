import ProductLateralBar from "components/container/LateralBar/ProductLateralBar";
import { useParams } from "react-router-dom";
import "./styles.css"
import ProductMenuBar from "components/container/HorizontalBar/ProductHorizontalBar";
import { ProductCategoryList, ProductHistoryByProduct, ProductMeasureList } from "pages/Listings";
import CategoryLateralBar from "components/container/LateralBar/CategoryLateralBar";
import { MeasureInfo } from "components/container/Card/MeasureCard";
import { AddProduct, ProductFormEdit } from "components/container/Form/ProductForm";
import { AddCategoryStats } from "components/container/Form/CategoryForm";
import { QuantityProductChart } from "components/dashboard/Chart/ProductCharts";

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
          <div className="container">
            <h1 className=" py-4">Estatísticas do Produto</h1>

            <div className="chart-box">
              <div className="container-chart">
                <h5 className="text-center">Quantidade do Produto por Data</h5>
                <QuantityProductChart productId={`${params.productId}`} />
              </div>
            </div><h1>Histórico de Alterações</h1>
              <ProductHistoryByProduct productId={`${params.productId}`} />
          </div>
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

  return (
    <div className="container-blur">
      <AddProduct />
    </div>
  );
}

export function UpdateProduct() {

  const params = useParams();

  return (
    <div className="container-blur">
      <ProductFormEdit productId={`${params.productId}`} />
    </div>
  );
}

export function SaveCategoryStats() {

  return (
    <div className="container-blur">
      <AddCategoryStats />
    </div>
  );
}

export function MeasureProfile() {

  const params = useParams();

  return (
    <div className="container-blur">
      <div>
        <MeasureInfo measureId={`${params.measureId}`} />
      </div>
      <ProductMeasureList measureId={`${params.measureId}`} />
    </div>
  );
}

