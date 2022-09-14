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

type Cons = {
    history: ProductHistory
}

export function ProductHistoryCard({history}: Cons) {
    return(
<div className="product-history-card">
<div className="product-history-item">
        <h2>Data da Atualização: {history.createdDate}</h2>
    </div>
    <div className="product-history-item">
        <h3>Descrição: {history.description}</h3>
    </div>
    <div className="product-history-item">
        <h3>Preço: {history.price.toFixed(2)}</h3>
    </div>
    <div className="product-history-item">
        <h3>Quantidade: {history.quantity}</h3>
    </div>
    <div className="product-history-item">
        <h3>Validade: {history.validate}</h3>
    </div>
</div>
    );

}