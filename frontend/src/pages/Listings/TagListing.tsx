import axios from "axios";
import { TagCard } from "components/container/Card/TagCard";
import { useEffect, useState } from "react";
import { CodeProps } from "types/order";
import { OrderTag } from "types/tag";
import { BASE_URL } from "utils/requests";

export function TagListByOrder({ codeId }: CodeProps) {
    const [tagList, setTagList] = useState<OrderTag[]>();

    useEffect(() => {
        axios.get(`${BASE_URL}/order-tag/find-by-code/${codeId}`)
            .then((response) => {
                setTagList(response.data)
            });
    }, [codeId]);

    return (
        <div className="horizontal-list">
            {tagList?.map((x) => (
                <div key={x.tagId} className="list-item">
                    <TagCard tag={x} />
                </div>
            ))}
        </div>
    );
}