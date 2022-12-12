import { CommissionMenuBar } from "components/container/Bar/CommissionBar";
import ItemDataTable from "components/dashboard/DataTable/CommissionDataTable";
import { useParams } from "react-router-dom";
import { CommissionItemCard } from "components/container/Card/CommissionCards";
import { AddItemForm } from "components/container/Form/CommissionForm";
import { MdClose } from "react-icons/md";


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


