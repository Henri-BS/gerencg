
import { Link } from "react-router-dom";
import { ProductCard } from "components/card/ProductCard";
import { ProductPage } from "types/product";
import axios from "axios";
import { useState, useEffect } from "react";
import { BASE_URL } from "utils/requests";
import { OrderCard } from "components/card/OrderCard";
import { OrderPage, OrderStatsPage } from "types/order";
import { CategoryCard } from "components/card/CategoryCard";
import { CategoryPage } from "types/category";
import { OrderStatsCharts } from "components/chart/StatsChart";
import { MdLibraryBooks } from "react-icons/md";
import { CategoryMockHomeCard, OrderMockHomeCard, ProductMockHomeCard } from "mock/MockCard";

function Home() {

    const [productPage, setProductPage] = useState<ProductPage>({ content: [], number: 0 });

    useEffect(() => {
        axios.get(`${BASE_URL}/product/search`)
            .then(response => {
                setProductPage(response.data);
            });
    }, []);

    const [orderPage, setOrderPage] = useState<OrderPage>({ content: [], number: 0 });

    useEffect(() => {
        axios.get(`${BASE_URL}/order/list`)
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
        axios.get(`${BASE_URL}/order-stats/list?size=12&sort=initialDate,desc`)
            .then((response) => {
                setStatsPage(response.data);
            });
    }, []);

    return (
        <>
            <div className="container"  >
                <div className="jumbotron" >
                    <h1 className="display-5 mt-3">Gerenciador Comercial </h1>
<b className="text-danger">Esta é uma demonstração com funcionalidades limitadas, possibilitando apenas a visualização de dados. Uma versão mais atualizada será disponibilizada em breve</b>
                    <hr />

                    <div className="item-card-bar ">
                        <div className="menu-item">
                            <Link to="/product" className="home-link">
                                Lista Completa de Produtos <MdLibraryBooks />
                            </Link>
                        </div>
                    </div>
                    <div className="horizontal-list ">
                        {productPage.content?.map(x => (
                            <div key={x.description} className="list-item">
                                <ProductCard product={x} />
                            </div>
                        ))}
                        {productPage.content?.length !== 0 ? "" :
                            <ProductMockHomeCard />
                        }
                    </div>
                    <hr />
                    <div className="item-card-bar">
                        <div className="menu-item">
                            <Link to="/order" className="home-link"> Lista Completa de Pedidos <MdLibraryBooks /> </Link>
                        </div>
                    </div>
                    <div className="horizontal-list ">
                        {orderPage.content?.map(x => (
                            <div key={x.code} className="list-item">
                                <OrderCard order={x} />
                            </div>
                        ))}
                        {orderPage.content?.length !== 0 ? "" :
                            <OrderMockHomeCard />
                        }
                    </div>

                    <hr />
                    <div className="item-card-bar ">
                        <div className="menu-item">
                            <Link to="/category" className="home-link"> Lista Completa de Categorias <MdLibraryBooks /> </Link>
                        </div>
                    </div>
                    <div className="horizontal-list ">
                        {categoryPage.content?.map(x => (
                            <div key={x.name} className="list-item">
                                <CategoryCard category={x} />
                            </div>
                        ))}
                        {categoryPage.content?.length !== 0 ? "" :
                            <CategoryMockHomeCard />
                        }
                    </div>

                    <hr />
                    <div className="item-card-bar ">
                        <div className="menu-item">
                            <Link to="/stats" className="home-link"> Página de Estatísticas <MdLibraryBooks /> </Link>
                        </div>
                    </div>
                    {statsPage.content.length === 0 ? "" :
                        <OrderStatsCharts />
                    }
                </div>
            </div>

        </>
    );

}

export default Home;