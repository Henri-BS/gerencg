
import { category, categoryStats as stats, product, order } from "components/shared/MenuList";
import { Link } from "react-router-dom";
import "./styles.css"


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
                        <Link className="menu-item col-sm-3" to={product.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={product.image} alt={product.title} />
                                <h3>{product.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={order.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={order.image} alt={order.title} />
                                <h3>{order.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={category.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={category.image} alt={category.title} />
                                <h3>{category.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={stats.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={stats.image} alt={stats.title} />
                                <h3>{stats.title}</h3>
                            </div>
                        </Link>

                    </div>
                    <hr className="mb-0 mt-5" />
                </div>
            </div> 
            
            
        </>
    );
}

export default Home;