import axios, { AxiosRequestConfig } from "axios";
import { connect } from 'react-redux';
import { useNavigate } from "react-router-dom";
import { authenticate, authFailure, authSuccess } from "service/authActions";
import { BASE_URL } from "utils/requests";


function LoginForm({ loading, error, ...props }: any) {
    const mapDispatchToProps = (dispatch: (arg0: { type: string; payload?: any; }) => any) => {
        return {
            authenticate: () => dispatch(authenticate()),
            setUser: (data: { token: string; }) => dispatch(authSuccess(data)),
            loginFailure: (message: string) => dispatch(authFailure(message))
        }
    }

    const mapStateToProps = ({ auth }: any) => {
        console.log("state ", auth)
        return {
            loading: auth.loading,
            error: auth.error
        }
    }

    const navigate = useNavigate();
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const userName = (event.target as any).userName.value;
        const password = (event.target as any).password.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: "POST",
            url: "/user-login",
            data: {
                userName: userName,
                password: password
            },
        };
        axios(config).then((response) => {
            if (response.status === 200) {
                props.setUser(response.data);
                navigate("/home");
            } else {
                props.loginFailure("Algo de errado ocorreu! Tente novamente");
            }
        }).catch((err) => {
            if (err && err.response) {
                switch (err.response.status) {
                    case 401:
                        console.log("401 status");
                        props.loginFailure("As Credenciais Falharam na Autenticação");
                        break;
                    default:
                        props.loginFailure("Algo de errado ocorreu! Tente novamente");
                }
            } else {
                props.loginFailure("Algo de errado ocorreu! Tente novamente");
            }
        });

        console.log("Loading ", loading)
    }

    return (
        <div className="form-container">
            <div className="form-card-container">
                <h3>Introduza os dados da sua conta</h3>
                <form className="gerencg-form" onSubmit={handleSubmit} noValidate={false}>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="userName">Nome de Usuário: </label>
                        <input type="text" className="form-control" id="userName" required />
                    </div>

                    <div className="form-group gerencg-form-group">
                        <label htmlFor="password">Senha

                        </label>
                        <input className="form-control" id="password" required />
                        <a href="forget.html" className="float-right form-links">
                            Esqueceu a Senha ?
                        </a>
                    </div>

                    <div className="form-group">
                        <div className="custom-control custom-checkbox">
                            <input type="checkbox" className="custom-control-input" id="customCheck1" />
                            <label className="custom-control-label" htmlFor="customCheck1">Mantenha-me Conectado</label>
                        </div>
                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className="gerencg-btn" >
                            Entrar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default LoginForm;