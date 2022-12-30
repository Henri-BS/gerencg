import { CommissionMenuBar, OrderStatsBar, OrderStatsTotalValuesBar } from "components/container/Bar/OrderBar";
import ItemDataTable from "components/dashboard/DataTable/CommissionDataTable";
import { useParams } from "react-router-dom";
import { CommissionItemCard } from "components/container/Card/OrderCard";
import { AddItemForm } from "components/container/Form/CommissionForm";
import { MdClose } from "react-icons/md";
import { OrderStatsList } from "pages/Listings/CommissionListing";
import { AmountOrderChart } from "components/dashboard/Chart/CategoryChart";


export function CommissionProfile() {
  const params = useParams();

  return (
    <>
      <div className="container">
        <CommissionMenuBar codeId={`${params.codeId}`} />
        <div className="menu-option row">
          <h2 className="col-7 col-md-10">Lista de Produtos Solicitados </h2>
          <div className="col-5  col-md-2" >
            <button className="btn-primary" data-bs-toggle="modal" data-bs-target="#saveItemModal">
              Adicionar Item
            </button>
          </div>
        </div>
        <ItemDataTable codeId={`${params.codeId}`} />
      </div>

      <div className="modal fade" role="dialog" id="saveItemModal">
        <div className="modal-dialog" role="document">
          <div className="modal-content">
            <div className="modal-header">
              <div className="modal-title" id="itemLabel">Adnicionar novo item</div>
              <button className="close" data-bs-dismiss="modal" aria-label="Close">
                <span aria-hidden="true"><MdClose /></span>
              </button>
            </div>
            <div className="modal-body"><AddItemForm codeId={`${params.codeId}`} /></div>
          </div>
        </div>
      </div>
    </>
  );
}

export function ItemProfile() {
  const params = useParams();

  return (
    <>
      <div className="container">
        <CommissionItemCard itemId={`${params.itemId}`} />
      </div>
    </>
  );
}

export function OrderStatsDashboard() {

  return (
    <div className="container">
      <div className="m-4"><OrderStatsList /></div>
      <OrderStatsTotalValuesBar />
      <div className="max-container-charts ">
        <div className="row ">
          <div className="chart-box col-lg-6">
            <div className="container-chart">
              <h5 className="text-center">Total de Pedidos por Mês</h5>
              <AmountOrderChart />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export function OrderStatsProfile() {
  const params = useParams();
  return (
    <>
      <div className="container">
        <div className="m-4"><OrderStatsList /></div>
        <OrderStatsBar statsId={`${params.statsId}`} />
      </div>
    </>
  );
}