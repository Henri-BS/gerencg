import  {AddedProductsChart, RemovedProductsChart } from "components/data/FlowCategoryCharts";
import DataTable from "components/data/StatsDataTable";
import {ExpenseChart, IncomeChart} from "components/data/ValueCategoryCharts";
import "./styles.css"

const Dashboard = () => {
  return (
    <>
      <div className="container">
        <h1 className=" py-4">Categorias</h1>

        <div className="max-container-charts">
          <div className="row px-3">
            <div className="container-chart col-sm-6">
              <h5 className="text-center">Total de Produtos Adicionados</h5>
              <AddedProductsChart />
            </div>
            <div className="container-chart col-sm-6">
              <h5 className="text-center ">Índice de Renda por Categoria</h5>
              <IncomeChart />
            </div>
          </div>

          <div className="row px-3">
            <div className="container-chart col-sm-6">
              <h5 className="text-center">Total de Produtos Removidos</h5>
              <RemovedProductsChart />
            </div>
            <div className="container-chart col-sm-6">
              <h5 className="text-center ">Índice de Despesa por Categoria</h5>
              <ExpenseChart />
            </div>
          </div>
        </div>

        <div className="py-3">
          <h2>Registros de Informações</h2>
        </div>
        <DataTable />
      </div>
    </>
  );
}

export default Dashboard;