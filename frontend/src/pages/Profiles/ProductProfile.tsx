import { useParams } from "react-router-dom";
import { ListHistoryByProduct } from "pages/lists/ProductListing";
import { MeasureInfo } from "components/card/MeasureCard";
import { SaveValuesHistory } from "components/form/ProductForm";
import { QuantityProductChart } from "components/chart/ProductCharts";
import { ProductMeasureList } from "pages/lists/MeasureListing";
import { HistoryMenuBar, ProductMenuBar, ProductSideBar } from "components/bar/ProductBar";
import ProductDataTable from "components/dataTable/ProductDataTable";
import { MdClose } from "react-icons/md";
import { GetHistoryCard as LargeHistoryCard } from "components/card/ProductCard";
import { OrderItemListByProduct } from "pages/lists/OrderListing";
import { ProductMockSideBar } from "mock/MockBar";

export function ProductProfile() {
  const params = useParams();

  return (
    <>
      <div className="profile row">
        <div className="col-12 col-sm-12 col-md-6 col-lg-5 col-xl-4 p-0">

          <ProductSideBar id={`${params.productId}`} /> 
          <ProductMockSideBar id={`${params.productId}`} />
        </div>
        <div className="col-12 col-md-6 col-lg-7 col-xl-8  p-4">
          <ProductMenuBar id={`${params.productId}`} />
          <div className="menu-option row">
            <h2 className="col-7 col-md-9">Estatísticas do Produto</h2>
            <div className="col-5  col-md-3" >
              <button className="btn-primary" data-bs-toggle="modal" data-bs-target="#saveHistoryModal">
                Salvar Valores
              </button>
            </div>
          </div>
          <ListHistoryByProduct id={`${params.productId}`} />
          <div className="chart-box">
            <div className="container-chart">
              <h5 className="text-center">Quantidade do Produto por Data</h5>
              <QuantityProductChart id={`${params.productId}`} />
            </div>
          </div>
          <h4>Registro de Pedidos do Produto</h4>
          <OrderItemListByProduct id={`${params.productId}`}/>
        </div>
      </div>

      <div className="modal fade" role="dialog" id="saveHistoryModal">
        <div className="modal-dialog" role="document">
          <div className="modal-content">
            <div className="modal-header">
              <div className="modal-title" id="historyLabel">Deseja salvar os atuais valores do produtos no histórico ?</div>
              <button className="close" data-bs-dismiss="modal" aria-label="Close">
                <span aria-hidden="true"><MdClose /></span>
              </button>
              </div>
              <div className="modal-body">
                <SaveValuesHistory id={`${params.productId}`}/>
              </div>
          </div>
        </div>
      </div>
    </>
  );
}

export function ProductHistoryProfile() {

  const params = useParams();
  return (
    <div className="container">
      <HistoryMenuBar id={`${params.historyId}`} />
      <LargeHistoryCard id={`${params.historyId}`} />
    </div>
  );
}

export function MeasureProfile() {

  const params = useParams();

  return (
    <>
      <div className="container-blur">
        <div>
          <MeasureInfo id={`${params.measureId}`} />
        </div>
        <ProductMeasureList id={`${params.measureId}`} />
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

