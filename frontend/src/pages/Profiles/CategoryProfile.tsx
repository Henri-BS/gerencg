import CategorySideBar from "components/container/Bar/CategoryBar";
import { AddCategoryStats } from "components/container/Form/CategoryForm";
import { CateogryStatsChart } from "components/dashboard/Chart/StatsChart";
import { ProductCategoryList } from "pages/Listings/CategoryListing";
import { useParams } from "react-router-dom";
import "./styles.css";

//Category Profile 
export function CategoryProfile() {

  const params = useParams();
  return (
    <>
      <div className="profile row">
        <div className="col-6-sm col-md-6 col-lg-4 p-0">
          <CategorySideBar categoryId={`${params.categoryId}`} />
        </div>
        <div className="col-6-sm col-md-6 col-lg-8 p-0">
          <ProductCategoryList categoryId={`${params.categoryId}`} />
        </div>
      </div>
    </>
  );
}

//Save new category
export function SaveCategoryStats() {

  return (
    <div className="container-blur">
      <AddCategoryStats />
    </div>
  );
}

export function CategoryStatsDashboard() {
  const params = useParams();
  return (
    <>
      <div className="container">
        <h1 className=" py-4">Estatísticas das Categorias</h1>
        <div className="max-container-charts ">
          <CateogryStatsChart />
        </div>
      </div>
    </>
  );
}