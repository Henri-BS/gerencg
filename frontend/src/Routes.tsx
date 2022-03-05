import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import Listing from "pages/Listing";
import { BrowserRouter, Route, Switch } from "react-router-dom"

const Routes = () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/gerencg" exact>
                    <Home />
                </Route>
                <Route path="/gerencg/dashboard">
                    <Dashboard />
                </Route>
                <Route path="/gerencg/listing">
                    <Route path=":categoryId" />
                    {<Listing />}
                </Route>
            </Switch>
        </BrowserRouter>
    );
}

export default Routes;