import Footer from "components/shared/Footer";
import NavBar from "components/shared/NavBar";
import Dashboard from "pages/StatsDashboard";
import Home from "pages/Home";
import Listing from "pages/Listing";
import ProductsList from "pages/ProductList";
import { BrowserRouter, Route, Routes } from "react-router-dom"

const PageRoutes = () => {
    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/categories-stats" element={<Dashboard />} />
                <Route path="/product/list" element={<ProductsList />} />
                <Route path="/listing" element={<Listing />}>
                    <Route path=":categoryId" />
                </Route>
            </Routes>
            <Footer />
        </BrowserRouter>
    );
}

export default PageRoutes;