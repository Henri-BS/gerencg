import { CommissionMenuBar } from "components/container/Bar/CommissionBar";
import ItemDataTable from "components/dashboard/DataTable/CommissionDataTable";
import { useParams } from "react-router-dom";
import { CommissionItemCard } from "components/container/Card/CommissionCards";
import { AddCommissionForm } from "components/container/Form/CommissionForm";

export function CommissionProfile() {
  const params = useParams();

  return (
    <>
      <div className="container">
        <div className="container-data">

          <CommissionMenuBar codeId={`${params.code}`} />
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