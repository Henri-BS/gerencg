import { CategorySideBar } from "components/bar/CategoryBar";
import { CategoryStatsChart } from "components/chart/StatsChart";
import { ProductCategoryList } from "pages/lists/CategoryListing";
import { useParams } from "react-router-dom";

export function CategoryProfile() {

  const params = useParams();
  return (
    <>
      <div className="profile row">
        <div className="col-12 col-sm-12 col-md-6 col-lg-4 p-0">
          <CategorySideBar id={`${params.categoryId}`} />
        </div>
        <div className="col-12 col-sm-12 col-md-6 col-lg-8">
          <ProductCategoryList id={`${params.categoryId}`} />
        </div>
      </div>
    </>
  );
}

export function CategoryStatsDashboard() {
  return (
          <CategoryStatsChart />
  );
}