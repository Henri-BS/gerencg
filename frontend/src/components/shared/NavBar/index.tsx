import { Link } from "react-router-dom";
import "./styles.css"
import Logo from 'assets/img/logo-g.png'
import * as AiIcons from 'react-icons/ai'


function NavBar() {
    return (
                <nav className='navbar'>
                    <Link to="/">
                        <img className='navbar-logo' src={Logo} alt='logo' />
                    </Link>
                    <Link className="navbar-item" to="/product/add">
<AiIcons.AiOutlinePlus/>  Novo Produto
                    </Link>
                    <Link className="navbar-item" to="/find-by-validate">
                    <AiIcons.AiFillClockCircle/> Validades
                    </Link>
                    <Link className="navbar-item" to="/find-by-measure">
                    <AiIcons.AiOutlineDashboard/> Medidas
                    </Link>
                </nav>
                
    );
}

export default NavBar;