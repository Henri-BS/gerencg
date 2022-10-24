import LoginForm from "components/container/Form/LoginForm";
import Footer from "components/shared/Footer";
import ILogo from "assets/img/full-logo.png"
import "./styles.css"
import { useParams } from "react-router-dom";
export function Login() {

    const params = useParams();

    return (
        <>
            <div className="container-blur">
                <div className="img-logo-container">
                    <img className="img-item" src={ILogo} alt="full-logo" />
                </div>
                <LoginForm loading={`${params.loading}`} error={`${params.error}`} />
            </div>
            <Footer />
        </>
    );
}