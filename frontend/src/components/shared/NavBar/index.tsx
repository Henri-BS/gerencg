import { Link } from "react-router-dom";
import "./styles.css"
import Logo from 'assets/img/logo-g.png'
import * as AiIcons from 'react-icons/ai'
import { useState } from "react";

function NavBar() {
    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);
    const closeMobileMenu = () => setClick(false);

    return (
        <nav className='navbar'>

            <Link to="/" onClick={closeMobileMenu}>
                <img className='navbar-logo' src={Logo} alt='logo' />
            </Link>

            <div className="menu-icon" onClick={handleClick}>
                <i className={click ? "fa fa-times" : "fas fa-list"} />
            </div>

            <ul className={click ? "navbar-menu active" : "navbar-menu"}>
                <li className="navbar-item">
                    <div className="navbar-link " data-bs-toggle="modal" data-bs-target="#saveProductModal" onClick={closeMobileMenu}>
                        <AiIcons.AiOutlinePlus />  Novo Produto
                    </div>
                </li>

                <li className="navbar-item">
                    <Link className="navbar-link " to="/category-stats/add" onClick={closeMobileMenu}>
                        <AiIcons.AiOutlineOrderedList />  Novo Registro
                    </Link>
                </li>

                <li className="navbar-item">
                    <Link className="navbar-link" to="/save-commission" onClick={closeMobileMenu}>
                        <AiIcons.AiOutlineProfile /> Novo Pedido
                    </Link>
                </li>

                <li className="navbar-item">
                    <Link className="navbar-link" to="/find-by-validate" onClick={closeMobileMenu}>
                        <AiIcons.AiFillClockCircle /> Validades
                    </Link>
                </li>

                <li className="navbar-item">
                    <Link className="navbar-link" to="/measure/list" onClick={closeMobileMenu}>
                        <AiIcons.AiOutlineDashboard /> Medidas
                    </Link>
                </li>
            </ul>
        </nav>

    );
}

export default NavBar;