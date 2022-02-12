import { Link } from "react-router-dom";
import "./styles.css"

const NavBar = () => {
    return (
                <nav className="navbar">
                    <Link to="/">
                        <h1 className="navbar-logo"> Gerencg</h1>
                    </Link>
                </nav>
    );
}

export default NavBar;