
import { category, categoryStats, product } from "components/data/MenuList";
import { Link } from "react-router-dom";
import "./styles.css"


const Home = () => {

    return (
        <>
            <div className="container"  >
                <div className="jumbotron" >
                    <h1 className="display-5 mt-3">Gerenciador Comercial </h1>
                    <hr />
                    <p className="lead">Gereng Categories permite ao usuário uma forma de administrar as categorias de seu interessse através de informações referentes a: </p>

                    <div className="container-menu">
                        <Link className="menu-item" to={product.path}>
                            <div className="item-card-bottom-container">
                            <img className="item-card-image" src={product.image} alt={product.title} />

                                <h3>{product.title}</h3>
                            </div>
                        </Link>
                        <Link className="menu-item" to={category.path}>

                            <div className="item-card-bottom-container">
                            <img className="item-card-image" src={category.image} alt={category.title} />
                                <h3>{category.title}</h3>
                            </div>
                        </Link>
                        <Link className="menu-item" to={categoryStats.path}>
                            <div className="item-card-bottom-container">
                            <img className="item-card-image" src={categoryStats.image} alt={categoryStats.title} />
                                <h3>{categoryStats.title}</h3>
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