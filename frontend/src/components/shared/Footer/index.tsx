import { Link } from 'react-router-dom';
import IGithub from 'assets/img/git.svg'
import ILinkedIn from 'assets/img/linked.svg'
import IGmail from 'assets/img/gmail.svg'
import "./styles.css";


function Footer() {
    return (
        <footer className='background-dark'>
            <div className='row footer-container '>

                <div className='footer-title'>
            <h5 >Contato com o Desenvolvedor </h5> 
            </div>
            
                <div className="col-4 ">
                    <Link to="https://github.com/Henri-BS" color="inherit">
                        <img className='footer-logo' src={IGithub} alt='logo' />
                        Github
                    </Link>
                </div>

                <div className="col-4  ">
                    <Link to="mailto:hbsantos720@gmail.com" color="inherit">
                        <img className='footer-logo' src={IGmail} alt='logo' />
                        Gmail
                    </Link>
                </div>

                <div className="col-4  ">
                    <Link to="https://www.linkedin.com/in/h-b-santos-1758351a3/" color="inherit">
                        <img className='footer-logo' src={ILinkedIn} alt='logo' />
                        LinkedIn
                    </Link>
                </div>
                <hr/>
                <div className='footer-box'>
            <h5 >Gerencg 2022©️</h5> 
            </div>

                </div>
          
        </footer>
    );
}
export default Footer;
