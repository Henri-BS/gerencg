import CategoryColumn from "components/container/CategoryColumn";
import { useParams } from "react-router-dom";

function CategoryProfile() {

    const params = useParams();
    return(
<>
<div className="profile">
    <CategoryColumn categoryId={`${params.categoryId}`} />
</div>
</>
    );
}

export default CategoryProfile;