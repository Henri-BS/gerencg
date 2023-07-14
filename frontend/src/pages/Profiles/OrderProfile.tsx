import { OrderMenuBar, OrderStatsBar, OrderStatsTotalValuesBar } from "components/container/Bar/OrderBar";
import ItemDataTable from "components/dashboard/DataTable/OrderDataTable";
import { useParams } from "react-router-dom";
import { OrderItemCard } from "components/container/Card/OrderCard";
import { ItemAddForm, OrderTagAddForm } from "components/container/Form/OrderForm";
import { MdAdd, MdClose, MdHdrPlus, MdOutline9KPlus, MdPlusOne } from "react-icons/md";
import { OrderStatsList } from "pages/Listings/OrderListing";
import { OrderStatsChartsByPediod, OrderStatsCharts, OrderStatsChartByCategory } from "components/dashboard/Chart/StatsChart";
import { CategoryStatsDashboard } from "./CategoryProfile";
import { OrderTagList, TagListByOrder } from "pages/Listings/TagListing";

export function OrderProfile() {
  const params = useParams();

  return (
    <>
      <div className="container">
        <OrderMenuBar id={`${params.codeId}`} />
        <h3>Tags <button className="btn link-primary" data-bs-toggle="modal" data-bs-target="#saveOrderTagModal">
          <MdAdd/>Adicionar Tag
        </button></h3>
        <TagListByOrder id={`${params.codeId}`} />
        
        <div className="menu-option row">
          <h2 className="col-7 col-md-10">Lista de Produtos Solicitados </h2>
          <div className="col-5 col-md-2" >
            <button className="btn-primary" data-bs-toggle="modal" data-bs-target="#saveItemModal">
              Adicionar Item
            </button>
          </div>
        </div>
        <ItemDataTable id={`${params.codeId}`} />
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
            <div className="modal-body"><ItemAddForm id={`${params.codeId}`} /></div>
          </div>
        </div>
      </div>

      <div className="modal fade" role="dialog" id="saveOrderTagModal">
        <div className="modal-dialog" role="document">
          <div className="modal-content">
            <div className="modal-header">
              <div className="modal-title" id="itemLabel">Adicionar nova tag</div>
              <button className="close" data-bs-dismiss="modal" aria-label="Close">
                <span aria-hidden="true"><MdClose /></span>
              </button>
            </div>
            <div className="modal-body"><OrderTagAddForm id={`${params.codeId}`} /></div>
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
        <OrderItemCard id={`${params.itemId}`} />
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


        <h1 className=" py-4">Estatísticas por Categoria</h1>
        <OrderStatsChartByCategory />
        <CategoryStatsDashboard /> </div>
    </div>
  );
}

export function OrderStatsProfile() {
  const params = useParams();
  return (
    <>
      <div className="container">
        <div className="m-4"><OrderStatsList /></div>
        <OrderStatsBar id={`${params.statsId}`} />
        <div className="max-container-charts ">
          <OrderStatsChartsByPediod id={`${params.statsId}`} />
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
        <OrderTagList id={`${params.tagId}`} />
      </div>
    </>
  );
}