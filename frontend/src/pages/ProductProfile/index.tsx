import ProductColumn from "components/container/ProductColumn";
import { useParams } from "react-router-dom";
import "./styles.css"


function ProductProfile() {
    const params = useParams();
  
    return (
      <>
        <div className="profile">
              < ProductColumn productId={`${params.productId}`} />
            </div>
      </>
    );
  
  }
  
  export default ProductProfile;