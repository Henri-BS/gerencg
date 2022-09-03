import ProductColumn from "components/container/ProductColumn";
import { useParams } from "react-router-dom";
import "./styles.css"
import ProductMenuBar from "components/container/ProductMenuBar";

function ProductProfile() {
  const params = useParams();

  return (
    <>
      <div className="profile row">

        <div className="col-6-sm col-md-4 p-0">
          < ProductColumn productId={`${params.productId}`} />
        </div>

        <div className="col-6-sm col-md-8 p-0">
          <ProductMenuBar />
          <hr/>
        </div>

      </div>
    </>
  );

}

export default ProductProfile;