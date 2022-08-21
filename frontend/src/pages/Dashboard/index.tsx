import  {AddedProductsChart, RemovedProductsChart } from "components/BarChart";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
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
              <h5 className="text-center ">Principais Categorias</h5>
              <DonutChart />
            </div>
          </div>

          <div className="row px-3">
            <div className="container-chart col-sm-6">
              <h5 className="text-center">Total de Produtos Removidos</h5>
              <RemovedProductsChart />
            </div>
            <div className="container-chart col-sm-6">
              <h5 className="text-center ">Principais Categorias</h5>
              <DonutChart />
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