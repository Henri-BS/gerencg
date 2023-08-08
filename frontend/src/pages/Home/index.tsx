
import { Link } from "react-router-dom";
import "./styles.css"
import { ProductCard } from "components/container/Card/ProductCard";
import { ProductPage } from "types/product";
import axios from "axios";
import { useState, useEffect } from "react";
import { BASE_URL } from "utils/requests";
import { OrderCard } from "components/container/Card/OrderCard";
import { CodePage, OrderStatsPage } from "types/order";
import { CategoryCard } from "components/container/Card/CategoryCard";
import { CategoryPage } from "types/category";
import { OrderStatsCharts } from "components/dashboard/Chart/StatsChart";
import { MdLibraryBooks } from "react-icons/md";

function Home() {

    const [productPage, setProductPage] = useState<ProductPage>({ content: [], number: 0 });

    useEffect(() => {
        axios.get(`${BASE_URL}/product/search?description=${""}`)
            .then(response => {
                setProductPage(response.data);
            });
    }, []);

    const [orderPage, setOrderPage] = useState<CodePage>({ content: [], number: 0 });

    useEffect(() => {
        axios.get(`${BASE_URL}/order/list?code=${""}`)
            .then(response => {
                setOrderPage(response.data);
            });
    }, []);

    const [categoryPage, setCategoryPage] = useState<CategoryPage>({ content: [], number: 0 });

    useEffect(() => {
        axios.get(`${BASE_URL}/category/list`)
            .then(response => {
                setCategoryPage(response.data);
            });
    }, []);

    const [statsPage, setStatsPage] = useState<OrderStatsPage>({
        content: [],
        number: 0,
        totalElements: 0,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/page?size=12&sort=initialDate,desc`)
            .then((response) => {
                setStatsPage(response.data);
            });
    }, []);

    return (
        <>
            <div className="container"  >
                <div className="jumbotron" >
                    <h1 className="display-5 mt-3">Gerenciador Comercial </h1>
                    <p className="lead">
                        Navegue pela lista de produtos e tenha acesso as atuais informações de cada um deles,
                        mantenha a organização através das lista de categorias e
                        consulte os seus pedidos encomendados e veja as atuais estatísticas</p>

                    <hr />

                    <div className="item-card-bar ">
                        <div className="home-link">
                            <Link to="/product/list" > Lista Completa de Produtos <MdLibraryBooks /> </Link>
                        </div>
                    </div>
                    <div className="horizontal-list ">
                        {productPage.content?.map(x => (
                            <div key={x.description} className="list-item">
                                <ProductCard product={x} />
                            </div>
                        ))}

                    </div>
                    <hr />
                    <div className="item-card-bar row">
                        <div className="menu-item col-12">
                            <Link to="/order/list" className="home-link"> Lista Completa de Pedidos <MdLibraryBooks /> </Link>
                        </div>
                    </div>
                    <div className="horizontal-list ">
                        {orderPage.content?.map(x => (
                            <div key={x.code} className="list-item">
                                <OrderCard code={x} />
                            </div>
                        ))}

                    </div>

                    <hr />
                    <div className="item-card-bar ">
                        <div className="menu-item">
                            <Link to="/category/list" className="home-link"> Lista Completa de Categorias <MdLibraryBooks /> </Link>
                        </div>
                    </div>
                    <div className="horizontal-list ">
                        {categoryPage.content?.map(x => (
                            <div key={x.name} className="list-item">
                                <CategoryCard category={x} />
                            </div>
                        ))}
                    </div>

                    <hr />
                    <div className="item-card-bar ">
                        <div className="menu-item">
                            <Link to="/stats" className="home-link"> Página de Estatísticas <MdLibraryBooks /> </Link>
                        </div>
                    </div>
                    <OrderStatsCharts />
                </div>
            </div>

        </>
    );

}

export default Home;