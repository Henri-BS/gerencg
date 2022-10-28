import { AddedProductsChart, RemovedProductsChart, ExpenseChart, IncomeChart } from "components/dashboard/Chart/CategoryChart";
import CategoryDataTable from "components/dashboard/DataTable/CategoryDataTable";
import ProductDataTable from "components/dashboard/DataTable/ProductDataTable";
import { ProductHistoryByProduct } from "pages/Listings";
import { useParams } from "react-router-dom";
import "./styles.css"

export function Dashboard() {
  return (
    <>
      <div className="container">
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

export function ProductDashboard() {


  return (
    <>
      <div className="container">
        <h1 className=" py-4">Registros de Alterações dos Produtos</h1>
        <ProductDataTable />
      </div>
    </>
  );
}