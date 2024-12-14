import axios from "axios";
import { OrderCardByTag } from "components/card/OrderCard";
import { OrderTagCard, TagCard } from "components/card/TagCard";
import Pagination from "components/shared/Pagination";
import { TagMockList } from "mock/MockList";
import { useEffect, useState } from "react";
import { MdLibraryBooks } from "react-icons/md";
import { Link } from "react-router-dom";
import { Props } from "types/page";
import { OrderTag, TagPage } from "types/tag";
import { BASE_URL } from "utils/requests";

export function TagList() {

    const [pageNumber, setPageNumber] = useState(0);

    const [tagList, setTagList] = useState<TagPage>({ content: [], number: 0 });
    useEffect(() => {
        axios.get(`${BASE_URL}/tag/list?page=${pageNumber}&size=15&sort=tagId,ASC`)
            .then((response) => {
                setTagList(response.data);
            });
    }, [pageNumber]);

    const handlePage = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            {tagList.content.length === 0 ?  <TagMockList /> :
                <div>
                    <Pagination page={tagList} onPageChange={handlePage} />
                    <div className="row p-2">
                        {tagList.content?.map(x => (
                            <div key={x.tagId} className="col-4 p-1">
                                <TagCard tag={x} />
                            </div>
                        ))}
                    </div>
                </div>
            }
        </>
    );
}

export function TagListByOrder({ id: orderId }: Props) {
    const [tagList, setTagList] = useState<OrderTag[]>();

    useEffect(() => {
        axios.get(`${BASE_URL}/order-tag/find-by-order/${orderId}`)
            .then((response) => {
                setTagList(response.data)
            });
    }, [orderId]);

    return (
        <div className="horizontal-list">
            {tagList?.map((x) => (
                <div key={x.tagId} className="list-item">
                    <OrderTagCard orderTag={x} />
                </div>
            ))}
        </div>
    );
}


export function OrderListByTag() {
    const [orderList, setOrderList] = useState<TagPage>({
        content: [],
        number: 0
    });
    useEffect(() => {
        axios.get(`${BASE_URL}/tag/list`)
            .then((response) => {
                setOrderList(response.data);
            });
    }, []);

    return (
        <div className="horizontal-list">
            {orderList.content?.map((x) => (
                <div key={x.tagId} className="list-item">
                    <TagCard tag={x} />
                </div>
            ))}
        </div>
    )
}

export function OrderTagList({ id: tagId }: Props) {
    const [orderList, setOrderList] = useState<OrderTag[]>();
    useEffect(() => {
        axios.get(`${BASE_URL}/order-tag/find-by-tag/${tagId}`)
            .then((response) => {
                setOrderList(response.data);
            });
    }, [tagId]);


    return (
        <>
            <div>
                <div className="container">
                    <nav className=" header-container">
                        <Link to={`/order`} className=" text-decoration-none">
                            <h4 className="link-primary"> <MdLibraryBooks />Retornar para a lista completa</h4>
                        </Link>
                        <h2 >Lista de Pedidos com a tag: {tagId}</h2>

                    </nav>
                    <hr />
                    <OrderListByTag />
                    <hr />

                    <div className="row">
                        {orderList?.map((order) => (
                            <div key={order.orderId} className="col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 mb-3">
                                <OrderCardByTag orderTag={order} />
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </>
    );
}