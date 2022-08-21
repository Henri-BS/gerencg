import Footer from "components/Footer";
import NavBar from "components/NavBar";
import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import Listing from "pages/Listing";
import { BrowserRouter, Route, Routes } from "react-router-dom"

const PageRoutes = () => {
    return (
        <BrowserRouter>
            <NavBar/>
                <Routes>
                <Route path="/gerencg" element={<Home />}/>
                <Route path="/gerencg/dashboard"element={ <Dashboard />}/>
                <Route path="/gerencg/listing"element={<Listing />}>
                    <Route path=":categoryId" />
                </Route>
                </Routes>
                <Footer />
        </BrowserRouter>
    );
}

export default PageRoutes;