
import {MenuCard, ProdCard} from "components/MenuCard";
import { Link } from "react-router-dom";
import "./styles.css"

const Home = () => {
    return (
        <>     
        <div className="container"  >
            <div className="jumbotron" >     
            <h1 className="display-5 mt-3">Gerenciar Categorias </h1>
              <hr/>   
              <p className="lead">Gereng Categories permite ao usuário uma forma de administrar as categorias de seu interessse através de informações referentes a: </p>
              <ul>     
        </ul>
     <p><b>Acesse informações relacionadas as categorias:</b></p>
        <div className="row">
        <div className="mb-5 col-sm-6 col-lg-6 col-xl-4 mb-4">
        <Link to="/gerencg/dashboard"> <MenuCard /> </Link>
        </div>
        <div className="col-sm-6 col-lg-6 col-xl-4 mb-4">
        <Link to="/gerencg/listing"> <ProdCard /> </Link>
        </div>
        </div>

        <hr className="mb-0 mt-5"/>
            </div>
        </div>
        </>
    );
}

export default Home;