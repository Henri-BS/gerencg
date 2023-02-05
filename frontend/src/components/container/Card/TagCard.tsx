import { Link } from "react-router-dom";
import { OrderTag, Tag } from "types/tag";

export type Props = {
    tag: Tag;
}

export function TagCard({ tag }: Props) {
    return (
        <Link to={`/order-tag/${tag.tagId}`} className="text-decoration-none">
            <div className="tag-card-container">
                {tag.tagId}
            </div>
            </Link>
    );
}

export type Cons = {
    orderTag: OrderTag;
}

export function OrderTagCard({ orderTag: tag }: Cons) {
    return (
        <Link to={`/order-tag/${tag.tagId}`} className="text-decoration-none">
            <div className="tag-card-container">
                {tag.tagId}
            </div>
            </Link>
    );
}