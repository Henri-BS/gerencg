import ProductColumn from "components/container/ProductColumn";
import { useParams } from "react-router-dom";

function ProductProfile() {
    const params = useParams();
  
    return (
      <>
        <div className="container">
              < ProductColumn productId={`${params.productId}`} />
            </div>
      </>
    );
  
  }
  
  export default ProductProfile;