import { Link } from "react-router-dom";
import { OrdersTagProps, TagProps } from "types/tag";


export function TagCard({ tag }: TagProps) {
    return (
        <Link to={`/order-tag/${tag.tagId}`} className="text-decoration-none">
            <abbr title={tag.tagId}>
                <div className="tag-card-container ">
                    {tag.tagId}
                </div>
            </abbr>
        </Link>
    );
}


export function OrderTagCard({ orderTag }: OrdersTagProps) {
    return (
        <Link to={`/order-tag/${orderTag.tagId}`} className="text-decoration-none">
            <div className="tag-card-container">
                {orderTag.tagId}
            </div>
        </Link>
    );
}