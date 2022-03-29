import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import Listing from "pages/Listing";
import { BrowserRouter, Route, Switch  as NavRoutes } from "react-router-dom"

const Routes = () => {
    return (
        <BrowserRouter>
            <NavRoutes>
                <Route path="/gerencg">
                    <Home />
                </Route>
                <Route path="/gerencg/dashboard">
                    <Dashboard />
                </Route>
                <Route path="/gerencg/listing">
                    <Route path=":categoryId" />
                    {<Listing />}
                </Route>
            </NavRoutes>
        </BrowserRouter>
    );
}

export default Routes;