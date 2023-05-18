import { Link } from "react-router-dom";
import "./styles.css"
import Logo from 'assets/img/logo-g.png'
import * as AiIcons from 'react-icons/ai'
import { useState } from "react";
import { MdClose, MdLibraryBooks } from "react-icons/md";
import { AddProductForm } from "components/container/Form/ProductForm";
import { SaveOrderForm } from "components/container/Form/OrderForm";

function NavBar() {
    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);
    const closeMobileMenu = () => setClick(false);

    return (
        <>
            <nav className='navbar'>

                <Link to="/" onClick={closeMobileMenu}>
                    <img className='navbar-logo' src={Logo} alt='logo' />
                </Link>

                <div className="menu-icon" onClick={handleClick}>
                    <i className={click ? "fa fa-times" : "fas fa-list"} />
                </div>

                <ul className={click ? "navbar-menu active" : "navbar-menu"}>
                    <li className="navbar-item">
                        <div data-bs-toggle="modal" data-bs-target="#saveProductModal" className="navbar-link " onClick={closeMobileMenu}>
                            <AiIcons.AiOutlinePlus />  Novo Produto
                        </div>
                    </li>

                    <li className="navbar-item">
                        <div data-bs-toggle="modal" data-bs-target="#saveCommissionModal" className="navbar-link" onClick={closeMobileMenu}>
                            <AiIcons.AiOutlineProfile /> Novo Pedido
                        </div>
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

            <div className="modal fade" role="dialog" id="saveProductModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <div className="modal-title" id="productLabel">Adicionar um novo produto
                                <span data-bs-dismiss="modal">
                                    <Link to="/product-list" className="form-links"> <MdLibraryBooks /></Link>
                                </span>
                            </div>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-body"><AddProductForm /></div>
                    </div>
                </div>
            </div>

            <div className="modal fade" role="dialog" id="saveCommissionModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header" >
                            <div className="modal-title" id="commissionLabel">Adicionar um novo pedido
                                <span data-bs-dismiss="modal">
                                    <Link to="/order/list" className="form-links" > <MdLibraryBooks /></Link>
                                </span>
                            </div>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-body"><SaveOrderForm /></div>
                    </div>
                </div>
            </div>

        </>

    );
}

export default NavBar;