import { CommissionMenuBar } from "components/container/Bar/CommissionBar";
import ItemDataTable from "components/dashboard/DataTable/CommissionDataTable";
import NavBar from "components/shared/NavBar";
import Footer from "components/shared/Footer";

import { useParams } from "react-router-dom";
import { UpdateByItemForm } from "components/container/Form/CommissionForm";

export function CommissionProfile() {
    const params = useParams();
  
    return(
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
  
    return(
    <>
      <div className="container-blur">
        <UpdateByItemForm productId={`${params.productId}`} itemId={`${params.itemId}`}/>
      </div>
      
    </>
    );
  }