
import { category, categoryStats, product, commission } from "components/shared/MenuList";
import { Link } from "react-router-dom";
import "./styles.css"


function Home() {
/** 
    const getToken = () => {
        return localStorage.getItem('USER_KEY');
    }

    const [data, setData] = useState<User>();

    const navigate = useNavigate();
       const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: "GET",
            url: "/auth/user-info",
            headers: {
                'Authorization': 'Bearer '+getToken()
            }
        };
        axios(config).then((response) => {
            setData(response.data);
        }).catch((e) => {
            localStorage.clear();
             navigate("/");
        })

        const logOut = () => {
            localStorage.clear();
            navigate("/");
        }
*/     
    return (
        <>
            <div className="container"  >
                <div className="jumbotron" >
                    <h1 className="display-5 mt-3">Gerenciador Comercial </h1>
                    <p className="lead">Acompanhe a lista de produtos e tenham acesso as atuais informações de cada produto,
                        tenha acesso a lista de categorias e veja as atuais estatísticas</p>
                        <h4>Bem Vindo </h4>
                    <hr />
                    <div className="container-menu row">
                        <Link className="menu-item col-sm-3" to={product.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={product.image} alt={product.title} />
                                <h3>{product.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={commission.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={commission.image} alt={commission.title} />
                                <h3>{commission.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={category.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={category.image} alt={category.title} />
                                <h3>{category.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={categoryStats.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={categoryStats.image} alt={categoryStats.title} />
                                <h3>{categoryStats.title}</h3>
                            </div>
                        </Link>

                    </div>
                    <hr className="mb-0 mt-5" />
                </div>
            </div> 
        </>
    );
}

export default Home;