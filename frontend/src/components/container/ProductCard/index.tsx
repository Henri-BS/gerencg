import { Link } from "react-router-dom";
import { Product } from "types/product";
import "./styles.css"

type Props = {
    product: Product;
}

function ProductCard({ product }: Props) {

    return (
        <Link to={`/product/${product?.id}`}>
            <div className="product-display-card">
                <img className="product-card-image" src={product?.image} alt={product?.description} />
                <div className="product-card-container">
                    <h3>{product?.description} | {product?.measureValue} {product?.measure}</h3>

                    <div className="product-price-container">
                        <h2>Preço: {product?.price} R$</h2>
                    </div>
                </div>
            </div>
        </Link>
    );
}

export default ProductCard;