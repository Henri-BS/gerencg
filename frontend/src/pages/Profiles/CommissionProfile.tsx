import { CommissionMenuBar } from "components/container/Bar/CommissionBar";
import ItemDataTable from "components/dashboard/DataTable/CommissionDataTable";
import { useParams } from "react-router-dom";
import { CommissionItemCard } from "components/container/Card/CommissionCards";
import { AddCommissionForm, AddItemForm } from "components/container/Form/CommissionForm";
import { Link } from "react-router-dom";

export function CommissionProfile() {
  const params = useParams();

  return (
    <>
      <div className="container">
        <CommissionMenuBar codeId={`${params.code}`} />
        <div className="menu-option row">
          <h2 className="col-7 col-md-10">Lista de Produtos Solicitados </h2>
          <Link className="col-5  col-md-2" to={"/save-item"}>
            <button className="btn-confirm">
              Adicionar Item
            </button>
          </Link>
        </div>
        <ItemDataTable codeId={`${params.code}`} />
      </div>
    </>
  );
}

export function UpdateProductByItem() {
  const params = useParams();

  return (
    <>
      <div className="container">
        <CommissionItemCard itemId={`${params.itemId}`} />
      </div>
    </>
  );
}

//Add commission page
export function SaveCommission() {

  return (
    <>
      <div className="container-blur">
        <AddCommissionForm />
      </div>
    </>
  );
}

//Add item in commission page
export function SaveItem() {

  return (
    <>
      <div className="container-blur">
        <AddItemForm />
      </div>
    </>
  );
}