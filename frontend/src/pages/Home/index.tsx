
import { category, categoryStats as stats, product, order } from "components/shared/MenuList";
import { Link } from "react-router-dom";
import "./styles.css"
import { GetLastProductCard } from "components/container/Card/ProductCard";

function Home() {

    return (
        <>
            <div className="container"  >
                <div className="jumbotron" >
                    <h1 className="display-5 mt-3">Gerenciador Comercial </h1>
                    <p className="lead">
                        Navegue pela lista de produtos e tenha acesso as atuais informações de cada um deles,
                        mantenha a organização através das lista de categorias e
                        consulte os seus pedidos encomendados e veja as atuais estatísticas</p>

                    <hr />
                    <div className="container-menu row">
                        <div className="menu-item col-sm-3">
                            <div className="item-card-container row">
                                <div className="col-lg-3" >
                                <div className="item-card-bar"> {product.title}</div>
                                <img className="item-card-image" src={product.image} alt={product.title} />
                            </div>
                            </div>
                        </div>

                        <div className="menu-item col-sm-3">
                            <div className="item-card-container row">
                                <div className="col-lg-3" >                                
                                <div className="item-card-bar"> {order.title}</div>
                                <img className="item-card-image" src={order.image} alt={order.title} />
                                </div>
                            </div>
                        </div>

                        <div className="menu-item col-sm-3" >
                            <div className="item-card-container row">
                                <div className="col-lg-3" >
                                <div className="item-card-bar"> {category.title}</div>
                                <img className="item-card-image" src={category.image} alt={category.title} />
                                </div>
                            </div>
                        </div>

                        <div className="menu-item col-sm-3">
                            <div className="item-card-container row">
                                <div className="col-lg-3" >
                                <div className="item-card-bar"> {stats.title}</div>
                                    <img className="item-card-image" src={stats.image} alt={stats.title} />
                                </div>
                                <div className="horizontal-list col-lg-9 ">
                                    <div className="horizonatal-list-item">
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <hr className="mb-0 mt-5" />
                </div>
            </div>


        </>
    );
}

export default Home;