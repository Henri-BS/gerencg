import Footer from "components/shared/Footer";
import NavBar from "components/shared/NavBar";
import Dashboard from "pages/StatsDashboard";
import Home from "pages/Home";
import ProductsList from "pages/ProductList";
import CategoryList from "pages/CategoryList";
import { BrowserRouter, Route, Routes } from "react-router-dom"
import ProductProfile from "pages/ProductProfile";


const PageRoutes = () => {
    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/categories-stats" element={<Dashboard />} />
                <Route path="/product/list" element={<ProductsList />} />
                <Route path="/category/list" element={<CategoryList/>} />

                <Route path="/product">
                        <Route path=":productId" element={<ProductProfile />} />
                    </Route>
            </Routes>
            <Footer />
        </BrowserRouter>
    );
}

export default PageRoutes;