import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { Link } from "react-router-dom";
import "./styles.css"

const Home = () => {
    return (
        <>
        <NavBar/>
        <div className="container">
            <div className="jumbotron">            
            <h1 className="display-4">Gerenciar Categorias </h1>
        <p className="lead">Analise o desempenho de cada categoria</p>
        <hr/>
            <Link className="gerencg-btn" to="/dashboard"> Dashboard </Link>
          
            </div>
        </div>
        <Footer/>
        </>
    );
}

export default Home;