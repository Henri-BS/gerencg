import Footer from "components/Footer";
import NavBar from "components/NavBar";
import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import Listing from "pages/Listing";
import { BrowserRouter, Route, Routes } from "react-router-dom"

const PageRoutes = () => {
    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/categories-stats" element={<Dashboard />} />
                <Route path="/listing" element={<Listing />}>
                    <Route path=":categoryId" />
                </Route>
            </Routes>
            <Footer />
        </BrowserRouter>
    );
}

export default PageRoutes;