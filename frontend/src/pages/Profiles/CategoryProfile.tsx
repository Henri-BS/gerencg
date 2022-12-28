import CategorySideBar from "components/container/Bar/CategoryBar";
import { AddCategoryStats } from "components/container/Form/CategoryForm";
import { AddedProductsChart, ExpenseChart, IncomeChart, RemovedProductsChart } from "components/dashboard/Chart/CategoryChart";
import { ProductCategoryList } from "pages/Listings/CategoryListing";
import CategoryDataTable from "components/dashboard/DataTable/CategoryDataTable";
import { useParams } from "react-router-dom";
import "./styles.css";
import { OrderStatsList } from "pages/Listings/CommissionListing";
import { OrderStatsBar } from "components/container/Bar/OrderBar";

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
     
          <OrderStatsBar statsId={`${params.statsId}`}/>
          <h1 className=" py-4">Estatísticas das Categorias</h1>
          <div className="max-container-charts ">
            <div className="row ">
              <div className="chart-box col-lg-6">
                <div className="container-chart">
                  <h5 className="text-center">Total de Produtos Adicionados</h5>
                  <AddedProductsChart />
                </div>
              </div>
  
              <div className="chart-box col-lg-6">
                <div className="container-chart ">
                  <h5 className="text-center">Total de Produtos Removidos</h5>
                  <RemovedProductsChart />
                </div>
              </div>
  
              <div className="chart-box col-lg-6">
                <div className="container-chart">
                  <h5 className="text-center ">Índice de Renda por Categoria</h5>
                  <ExpenseChart />
                </div>
              </div>
  
              <div className="chart-box col-lg-6">
                <div className="container-chart" >
                  <h5 className="text-center ">Índice de Despesas por Categoria</h5>
                  <IncomeChart />
                </div>
              </div>
            </div>
          </div>
          <h2 className="py-3">Registros de Informações</h2>
          <CategoryDataTable />
        </div>
      </>
    );
  }