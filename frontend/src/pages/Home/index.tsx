
import { category, categoryStats, product, productStats } from "components/shared/MenuList";
import { Link, useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import "./styles.css"
import axios, { AxiosRequestConfig } from "axios";
import { BASE_URL } from "utils/requests";


function Home() {

    const getToken = () => {
        return localStorage.getItem('USER_KEY');
    }

    const [loading, setLoading] = useState(false);
    const [data, setData] = useState({});

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

    return (
        <>
            <div className="container"  >
                <div className="jumbotron" >
                    <h1 className="display-5 mt-3">Gerenciador Comercial </h1>
                    <p className="lead">Acompanhe a lista de produtos e tenham acesso as atuais informações de cada produto,
                        tenha acesso a lista de categorias e veja as atuais estatísticas</p>
                    <hr />
                    <div className="container-menu row">
                        <Link className="menu-item col-sm-3" to={product.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={product.image} alt={product.title} />
                                <h3>{product.title}</h3>
                            </div>
                        </Link>

                        <Link className="menu-item col-sm-3" to={productStats.path}>
                            <div className="item-card-bottom-container">
                                <img className="item-card-image" src={productStats.image} alt={productStats.title} />
                                <h3>{productStats.title}</h3>
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