import BarChart from "components/BarChart";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

const Dashboard = () => {
    return (
        <>
        <NavBar />
        <div className="container">
          <h1 className=" py-4">Categorias</h1>
  
          <div className="row px-3">
            <div className="container-chart col-sm-6">
              <h5 className="text-center">Fluxo de Movimento (%)</h5>
              <BarChart />
            </div>
            <div className="container-chart col-sm-6">
              <h5 className="text-center ">Principais Categorias</h5>
              <DonutChart />
            </div>
          </div>
  
          <div className="py-3">
            <h2>Registros de Informações</h2>
          </div>
  
          <DataTable />
        </div>
        <Footer />
      </>
    );
}

export default Dashboard;