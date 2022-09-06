import { Link } from 'react-router-dom';
import IGithub from 'assets/img/git.svg'
import ILinkedIn from 'assets/img/linked.svg'
import IGmail from 'assets/img/gmail.svg'
import "./styles.css";

const links = {
    github: "https://github.com/Henri-BS",
    email: "mailto:hbsantos720@gmail.com",
    linkedin: "https://www.linkedin.com/in/h-b-santos-1758351a3/"
}


function Footer() {
    return (
        <footer className='background-dark'>
            <div className='row footer-container '>

                <div className='footer-title'>
            <h5 >Contato com o Desenvolvedor </h5> 
            </div>
            
                <div className="col-4 ">
                    <a href={links.github} color="inherit">
                        <img className='footer-logo' src={IGithub} alt='logo' />
                        Github
                    </a>
                </div>

                <div className="col-4  ">
                    <a href={links.email} color="inherit">
                        <img className='footer-logo' src={IGmail} alt='logo' />
                        Gmail
                    </a>
                </div>

                <div className="col-4  ">
                    <a href={links.linkedin} color="inherit">
                        <img className='footer-logo' src={ILinkedIn} alt='logo' />
                        LinkedIn
                    </a>
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
