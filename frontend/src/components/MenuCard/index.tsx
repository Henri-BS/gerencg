import './styles.css'

const categoryDashboard = {
description: "Categorias",
image: "https://cdn.iconscout.com/icon/free/png-256/category-1-1-267498.png"
}

const product = {
    description: "Products",
    image: "https://cdn2.iconfinder.com/data/icons/business-office-6/100/cart_upload-01-512.png"
}

export function MenuCard() {

    return (
        <div>
            <img className="quest-card-image"
                src={categoryDashboard.image}
                alt={categoryDashboard.description} />
            <div className="card-bottom-container">
                <h3>{categoryDashboard.description}</h3>
            </div>
        </div>
    );

}

export function ProdCard() {

    return (
        <div>
            <img className="quest-card-image"
                src={product.image}
                alt={product.description} />
            <div className="card-bottom-container">
                <h3>{product.description}</h3>
            </div>
        </div>
    );

}