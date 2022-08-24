
import { MenuCard } from "components/MenuCard";
import { Link } from "react-router-dom";
import "./styles.css"

const product = {
    title: 'Produtos',
    path: '/product',
    image: "https://cdn2.iconfinder.com/data/icons/shopping-e-commerce-3/512/full-basket-512.png",
    cName: 'menu-link'
}
    
    const category = {
        title: 'Categorias',
        path: '/category',
        image: "https://cdn1.iconfinder.com/data/icons/ecommerce-basic-1-filled-outline/468/16-menu-512.png",
        cName: 'menu-link'
    }

    const categoryStats = {
        title: 'Estatísticas de Categorias',
        path: '/categories-stats',
        image: "https://cdn1.iconfinder.com/data/icons/web-design-and-development-2-2/512/66-512.png",
        cName: 'menu-link'
    }



const Home = () => {


    
    return (
        <>
            <div className="container"  >
                <div className="jumbotron" >
                    <h1 className="display-5 mt-3">Gerenciar Categorias </h1>
                    <hr />
                    <p className="lead">Gereng Categories permite ao usuário uma forma de administrar as categorias de seu interessse através de informações referentes a: </p>
                      
<div className="container-menu">
    <Link className="menu-item" to={product.path}>
        <img className="item-card-image" src={product.image} alt={product.title} />
        <div className="item-card-bottom-container">
            <h3>{product.title}</h3>        
            </div>
    </Link>
    <Link className="menu-item" to={category.path}>
        <img className="item-card-image" src={category.image} alt={category.title} />
        <div className="item-card-bottom-container">
            <h3>{category.title}</h3>        
            </div>
    </Link>
    <Link className="menu-item" to={categoryStats.path}>
        <img className="item-card-image" src={categoryStats.image} alt={categoryStats.title} />
        <div className="item-card-bottom-container">
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