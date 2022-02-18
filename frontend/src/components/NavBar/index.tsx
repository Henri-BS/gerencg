import { Link } from "react-router-dom";
import "./styles.css"
import Logo from 'assets/img/logo-g.png'

const NavBar = () => {
    return (
                <nav className='navbar'>
                    <Link to="/">
                        <img className='navbar-logo' src={Logo} alt='logo' />
                    </Link>
                </nav>
    );
}

export default NavBar;