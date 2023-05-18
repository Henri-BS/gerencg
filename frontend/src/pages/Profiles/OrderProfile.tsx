import { OrderMenuBar, OrderStatsBar, OrderStatsTotalValuesBar } from "components/container/Bar/OrderBar";
import ItemDataTable from "components/dashboard/DataTable/OrderDataTable";
import { useParams } from "react-router-dom";
import { OrderItemCard } from "components/container/Card/OrderCard";
import { AddItemForm } from "components/container/Form/OrderForm";
import { MdClose } from "react-icons/md";
import { OrderStatsList } from "pages/Listings/OrderListing";
import { OrderStatsChartsByPediod, OrderStatsCharts, OrderStatsChartByCategory } from "components/dashboard/Chart/StatsChart";
import { CategoryStatsDashboard } from "./CategoryProfile";
import { OrderTagList, TagListByOrder } from "pages/Listings/TagListing";

export function OrderProfile() {
  const params = useParams();

  return (
    <>
      <div className="container">
        <OrderMenuBar codeId={`${params.codeId}`} />
        <h3>Tags</h3>
        <TagListByOrder codeId={`${params.codeId}`}/>
        <div className="menu-option row">
          <h2 className="col-7 col-md-10">Lista de Produtos Solicitados </h2>
          <div className="col-5 col-md-2" >
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
              <div className="modal-title" id="itemLabel">Adicionar novo item</div>
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
        <OrderItemCard itemId={`${params.itemId}`} />
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
        <OrderStatsCharts />
        <OrderStatsChartByCategory />
      </div>
      <CategoryStatsDashboard/>
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
        <div className="max-container-charts ">
          <OrderStatsChartsByPediod statsId={`${params.statsId}`} />
        </div>
      </div>
    </>
  );
}

export function OrderTagProfile() {
  const params = useParams();
  return (
    <>
        <div>
          <OrderTagList tagId={`${params.tagId}`} />
      </div>
    </>
  );
}