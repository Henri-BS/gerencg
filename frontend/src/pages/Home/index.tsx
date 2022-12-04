
import { AddProduct } from "components/container/Form/ProductForm";
import { category, categoryStats, product, commission } from "components/shared/MenuList";
import { MdClose } from "react-icons/md";
import { Link } from "react-router-dom";
import "./styles.css"


function Home() {

    return (
        <>
            <div className="container"  >
                <div className="jumbotron" >
                    <h1 className="display-5 mt-3">Gerenciador Comercial </h1>
                    <p className="lead">Acompanhe a lista de produtos e tenham acesso as atuais informações de cada produto,
                        tenha acesso a lista de categorias e veja as atuais estatísticas</p>
                        <h4>Bem Vindo </h4>
                    <hr />
                    <div className="container-menu row">
                        <Link className="menu-item col-sm-3" to={product.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={product.image} alt={product.title} />
                                <h3>{product.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={commission.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={commission.image} alt={commission.title} />
                                <h3>{commission.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={category.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={category.image} alt={category.title} />
                                <h3>{category.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={categoryStats.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={categoryStats.image} alt={categoryStats.title} />
                                <h3>{categoryStats.title}</h3>
                            </div>
                        </Link>

                    </div>
                    <hr className="mb-0 mt-5" />
                </div>
            </div> 
            
            <div className="modal fade" role="dialog" id="saveProductModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <div className="modal-title" id="productLabel">Adicionar um novo produto</div>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-body"><AddProduct/></div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Home;