import Categ from 'assets/img/categ.jpg'
import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { Link } from "react-router-dom";
import "./styles.css"

const Home = () => {
    return (
        <>
        <NavBar/>
        <div className="container" >
            <div className="jumbotron" >            
            <h1 className="display-4">Gerenciar Categorias </h1>
        <p className="lead">Gereng Categories permite ao usuário uma forma de administrar as categorias de seu interessse através de informações referentes a:
        <p>• Categoria mais relevante</p>
        <p>• Fluxo de movimento com a média de entradas e saídas</p>
        <p>• Valor atual de cada categoria</p>
        <p>• Quantidade de itens adicionados e removidos em determinado periodo</p>
        <p>• Data de registro das atualizações</p>
        <p>Clique no botão abaixo para acessar o Dashboard</p>
        </p>
        <hr/>
            <Link className="gerencg-btn" to="/dashboard"> Dashboard </Link>
            </div>
        </div>
        <Footer/>
        </>
    );
}

export default Home;