import LoginForm from "components/container/Form/LoginForm";
import ILogo from "assets/img/full-logo.png"
import "./styles.css"
export function Login() {

    return (
        <>
            <div className="container-blur">
                <div className="img-logo-container">
                    <img className="img-item" src={ILogo} alt="full-logo" />
                </div>
                <LoginForm />
            </div>
        </>
    );
}