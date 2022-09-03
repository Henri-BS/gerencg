
import IUpdateProduct from '../../../assets/img/update-product.png';
import IDeleteProduct from 'assets/img/delete-product.png';
import "./styles.css"

function ProductMenuBar() {

    return (
        <div className=" menu-profile-container">
            <button className="menu-option-card">
                    <img className="option-card-img" src={IUpdateProduct} alt="update-product" />
                Editar produto
            </button>

            <button className="menu-option-card">
                    <img className="option-card-img" src={IDeleteProduct} alt="delete-product" />
                Deletar produto
            </button>
        </div>
    );
}

export default ProductMenuBar;