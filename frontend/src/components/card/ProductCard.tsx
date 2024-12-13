import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { MdClose } from "react-icons/md";
import { Link, useParams } from "react-router-dom";
import { ProductHistory, ProductHistoryProps, ProductPage, ProductProps } from "types/product";
import { Props} from "types/page";
import { BASE_URL } from "utils/requests";


export function ProductCard({ product }: ProductProps) {

    return (
        <Link to={`/product/${product?.id}`}>
            <div className={"product-card-container"}>
                <img className="product-card-image" src={product?.image} alt={product?.description} />
                <div className="product-info-box">
                    <h3 className="product-info-title">{product?.description} • {product?.measureValue} {product?.measure.abbreviation}</h3>

                    <div className="product-info-item">
                        <h6>Preço: {product?.price.toFixed(2)} R$</h6>
                    </div>
                </div>
            </div>
        </Link>
    );
}

export function GetLastProductCard() {

    const [productList, setProductList] = useState<ProductPage>({ content: [], number: 0 });
    useEffect(() => {
        axios.get(`${BASE_URL}/product/search?size=1&sort=dateCreated,desc`)
            .then((response) => {
                setProductList(response.data);
            });
    }, []);


    return (
        <div>
            Último Produto Adcionado:
            {productList.content?.map(x => (
                <ProductCard product={x} />
            ))}
        </div>
    );
}


export function ProductValidateCard({ product }: ProductProps) {

    return (
        <Link to={`/product/${product?.id}`}>
            <div className="product-card-container">
                <img className="product-card-image" src={product?.image} alt={product?.description} />
                <div className="product-info-box">
                    <h3>{product?.description}</h3>

                    <div className="product-info-item">
                        <h2>Valido até: {moment(product?.validate).format("DD/MM/yyyy")}</h2>
                    </div>
                </div>
            </div>
        </Link>
    );
}

export function ProductHistoryCard({ history }: ProductHistoryProps) {

    const params = useParams();
    return (
        <>   <Link to={`/history/${history.id}`}>
            <div className="small-card-container">
                <h5>Data de Registro: {moment(history.dateCreated).format("DD/MM/YYYY")}
                </h5>
            </div> </Link>
            <div className="modal fade" role="dialog" id="deleteHistoryModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <label className="modal-title" id="historyLabel">Deseja deletar estes valores do histórico</label>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span className="text-close" aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <GetHistoryCard id={`${params.historyId}`} />
                    </div>
                </div>
            </div>
        </>
    );
}

export function GetHistoryCard({ id: historyId }: Props) {

    const [history, setHistory] = useState<ProductHistory>();
    useEffect(() => {
        axios.get(`${BASE_URL}/history/${historyId}`)
            .then((response) => {
                setHistory(response.data);
            });
    }, [historyId]);

    useEffect(() => {
        axios.put(`${BASE_URL}/history/update-value/${historyId}`)
            .then((response) => {
                setHistory(response.data);
            });
    }, [historyId]);

    return (
        <>
            <div className="gerencg-item-card">
                <div className="gerencg-box border-dark">
                    <h4>Data de registro: {moment(history?.dateCreated).format("DD/MM/YYYY")}</h4>
                </div>
                <Link to={`/product/${history?.productId}`} className="gerencg-box">
                    Produto: {history?.productDescription}
                </Link>
                <div className="gerencg-box">
                    Quantidade em estoque: {history?.quantity}
                </div>
                <div className="gerencg-box">
                    Preço: {history?.price.toFixed(2)}
                </div>
                <div className="gerencg-box">
                    Validade: {moment(history?.validate).format("DD/MM/YYYY")}
                </div>
                <div className="gerencg-box">
                    Expectativa de Renda: {history?.income}
                </div>
            </div>
        </>
    );
}