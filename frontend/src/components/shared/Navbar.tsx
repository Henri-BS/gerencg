import { Link } from "react-router-dom";
import Logo from 'assets/img/logo-g.png'
import * as AiIcons from 'react-icons/ai'
import { useState } from "react";
import { MdClose, MdLibraryBooks } from "react-icons/md";
import { AddProductForm } from "components/form/ProductForm";
import { OrderAddForm } from "components/form/OrderForm";
import { TagAddForm } from "components/form/TagForm";
import { TagList } from "pages/lists/TagListing";
import { CategoryAddForm } from "components/form/CategoryForm";
import { GetLastCategoryCard } from "components/card/CategoryCard";
import { GetLastProductCard } from "components/card/ProductCard";
import { GetLastOrderCard } from "components/card/OrderCard";
import { MeasureList } from "pages/lists/MeasureListing";
import { MeasureAddForm } from "components/form/MeasureForm";

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
                            <AiIcons.AiOutlineInbox /> Produto
                        </div>
                    </li>

                    <li className="navbar-item">
                        <div data-bs-toggle="modal" data-bs-target="#saveOrderModal" className="navbar-link" onClick={closeMobileMenu}>
                            <AiIcons.AiOutlineProfile /> Pedido
                        </div>
                    </li>

                    <li className="navbar-item">
                        <Link className="navbar-link" to="/find-by-validate" onClick={closeMobileMenu}>
                            <AiIcons.AiOutlineClockCircle /> Validades
                        </Link>
                    </li>

                    <li className="navbar-item">
                        <div data-bs-toggle="modal" data-bs-target="#saveCategoryModal" className="navbar-link" onClick={closeMobileMenu}>
                            <AiIcons.AiOutlineMenuUnfold /> Categorias
                        </div>
                    </li>
                    <li className="navbar-item">
                        <div data-bs-toggle="modal" data-bs-target="#saveTagModal" className="navbar-link" onClick={closeMobileMenu}>
                            <AiIcons.AiOutlineTags /> Tags
                        </div>
                    </li>
                    <li className="navbar-item">
                        <div data-bs-toggle="modal" data-bs-target="#saveMeasureModal" className="navbar-link" onClick={closeMobileMenu}>
                            <AiIcons.AiOutlineDashboard /> Medidas
                        </div>
                    </li>
                </ul>
            </nav>

            <div className="modal fade" role="dialog" id="saveProductModal">
                <div className="modal-dialog modal-lg" role="document">
                    <div className="modal-content">
                        <div className="modal-header">

                            <span data-bs-dismiss="modal ">
                                <Link to="/product" className="form-links"> <MdLibraryBooks /> Lista de Produtos</Link>
                            </span>

                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-title" id="productLabel">Adicionar um novo produto</div>
                        <div className="modal-body"><AddProductForm />
                            <hr />
                            <GetLastProductCard />
                        </div>
                    </div>
                </div>
            </div>

            <div className="modal fade" role="dialog" id="saveOrderModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header" >
                            <span data-bs-dismiss="modal">
                                <Link to="/order" className="form-links" > <MdLibraryBooks /> Lista de Pedidos</Link>
                            </span>
                            <button className="close" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-title" id="orderLabel">Adicionar um novo pedido</div>

                        <div className="modal-body"><OrderAddForm /></div>
                        <hr />
                        <GetLastOrderCard />
                    </div>
                </div>
            </div>
            <div className="modal fade" role="dialog" id="saveCategoryModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header" >
                            <span data-bs-dismiss="modal">
                                <Link to="/category" className="form-links" > <MdLibraryBooks /> Lista de Categorias</Link>
                            </span>
                            <button className="close" type="button" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-title" id="categLabel">Adicionar Categoria</div>
                        <div className="modal-body">
                            <CategoryAddForm />
                            <hr />
                            <GetLastCategoryCard />
                        </div>
                    </div>
                </div>
            </div>

            <div className="modal fade" role="dialog" id="saveTagModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header" >
                            <div className="modal-title" id="tagLabel">Adicionar Tag</div>
                            <button className="close" type="button" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-body">
                            <TagAddForm />
                            <hr />
                            <TagList />
                        </div>
                    </div>
                </div>
            </div>

            <div className="modal fade" role="dialog" id="saveMeasureModal">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header" >
                            <div className="modal-title" id="tagLabel">Adicionar Medida</div>
                            <button className="close" type="button" data-bs-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><MdClose /></span>
                            </button>
                        </div>
                        <div className="modal-body">
                            <MeasureAddForm />
                            <hr />
                            <MeasureList />
                        </div>
                    </div>
                </div>
            </div>



        </>

    );
}

export default NavBar;