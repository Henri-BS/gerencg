import { CommissionMenuBar } from "components/container/Bar/CommissionBar";
import ItemDataTable from "components/dashboard/DataTable/CommissionDataTable";
import NavBar from "components/shared/NavBar";
import Footer from "components/shared/Footer";

import { useParams } from "react-router-dom";
import { CommissionItemCard } from "components/container/Card/CommissionCards";
import { AddCommissionForm } from "components/container/Form/CommissionForm";

export function CommissionProfile() {
  const params = useParams();

  return (
    <>
      <NavBar />
      <div className="container">
        <div className="container-data">

          <CommissionMenuBar codeId={`${params.code}`} />
        </div>
        <ItemDataTable codeId={`${params.code}`} />
      </div>
      <Footer />
    </>
  );
}

export function UpdateProductByItem() {
  const params = useParams();

  return (
    <>
      <NavBar />
      <div className="container">
        <CommissionItemCard itemId={`${params.itemId}`} />
      </div>
      <Footer />
    </>
  );
}

//Add commission page
export function SaveCommission() {

  return (
    <div className="container p-0">
      <div className="container-blur">
        <AddCommissionForm />
      </div>
    </div>
  );
}