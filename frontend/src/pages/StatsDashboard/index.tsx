import { AddedProductsChart, RemovedProductsChart, ExpenseChart, IncomeChart} from "components/dashboard/Chart/CategoryChart";
import DataTable from "components/dashboard/DataTable";
import "./styles.css"

const Dashboard = () => {
  return (
    <>
      <div className="container">
        <h1 className=" py-4">Categorias</h1>

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

        <div className="py-3">
          <h2>Registros de Informações</h2>
        </div>
        <DataTable />
      </div>
    </>
  );
}

export default Dashboard;