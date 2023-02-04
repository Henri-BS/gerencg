import { OrderTag } from "types/tag";

export type Props = {
tag: OrderTag;
}

export function TagCard({tag}: Props){
    return(
            <div className="tag-card-container">
                {tag.tagId}
            </div>
    );
}