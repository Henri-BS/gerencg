import moment from "moment";
import { Link } from "react-router-dom";
import { Product } from "types/product";
import { ProductHistory } from "types/productHistory";
import "./styles.css"

type Props = {
    product: Product;
}

export function ProductCard({ product }: Props) {

    return (
        <Link to={`/product/${product?.id}`}>
            <div className="product-display-card">
                <img className="product-card-image" src={product?.image} alt={product?.description} />
                <div className="product-card-container">
                    <h3>{product?.description} • {product?.measureValue} {product?.measure}</h3>

                    <div className="product-price-container">
                        <h2>Preço: {product?.price.toFixed(2)} R$</h2>
                    </div>
                </div>
            </div>
        </Link>
    );
}

//Card with Validade

export function ProductValidateCard({ product }: Props) {

    return (
        <Link to={`/product/${product?.id}`}>
            <div className="product-display-card">
                <img className="product-card-image" src={product?.image} alt={product?.description} />
                <div className="product-card-container">
                    <h3>{product?.description}</h3>

                    <div className="product-price-container">
                        <h2>Validao até: {moment(product?.validate).format('DD/MM/YYYY')} </h2>
                    </div>
                </div>
            </div>
        </Link>
    );
}



type Cons = {
    history: ProductHistory
}

export function ProductHistoryCard({ history }: Cons) {
    return (
        <div className="product-history-card">
            <div className="product-history-box  border-dark">
                <h2>Data da Atualização: {moment(history.createdDate).format("DD/MM/YYYY")}</h2>
            </div>
            <div className="product-history-box">
                <h4>Descrição: {history.description}</h4>
            </div>
            <div className="product-history-box">
                <h3>Preço: {history.price.toFixed(2)}</h3>
            </div>
            <div className="product-history-box">
                <h3>Quantidade: {history.quantity}</h3>
            </div>
            <div className="product-history-box border-0">
                <h3>Validade: {moment(history.validate).format("DD/MM/YYYY")}</h3>
            </div>
        </div>
    );

}