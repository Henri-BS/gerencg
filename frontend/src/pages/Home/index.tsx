import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { Link } from "react-router-dom";

const Home = () => {
    return (
        <>
        <NavBar/>
        <div className="container">
            <div className="jumbotron">            
            <h1 className="display-4">Gerenciar Categorias </h1>
        <p className="lead">Analise o desempenho de cada categoria</p>
        <hr/>
        <p>Dashboard para a visualização de informações sobre cada categoria</p>
            <Link className="btn btn-primary btn-lg" to="/dashboard"> Dashboard </Link>
          
            </div>
        </div>
        <Footer/>
        </>
    );
}

export default Home;