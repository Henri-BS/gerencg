import Home from "pages/main/Home";
import NavBar from "components/shared/Navbar";
import Footer from "components/shared/Footer";
import { ProductsList, ProductValidateList } from "pages/lists/ProductListing";
import { BrowserRouter, Route, Routes } from "react-router-dom"
import { CategoryList } from "pages/lists/CategoryListing";
import { MeasureList } from "pages/lists/MeasureListing";
import { OrderCodeList } from "pages/lists/OrderListing";
import { CategoryProfile, CategoryStatsDashboard } from "pages/profiles/CategoryProfile";
import { OrderProfile , ItemProfile, OrderStatsDashboard, OrderStatsProfile, OrderTagProfile } from "pages/profiles/OrderProfile";
import { ProductDashboard, ProductProfile, ProductHistoryProfile, MeasureProfile } from "pages/profiles/ProductProfile";

function PageRoutes() {

    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/home" element={<Home />} />

                <Route path="/product" element={<ProductsList />} />
                <Route path="/products-stats" element={<ProductDashboard />} />

                <Route path="/find-by-validate" element={<ProductValidateList />} />

                <Route path="/product">
                    <Route path=":productId" element={<ProductProfile />} />
                </Route>
                <Route path="/history" >
                    <Route path=":historyId" element={<ProductHistoryProfile />} />
                </Route>

                <Route path="/category" element={<CategoryList />} />
                <Route path="/category-stats" element={<CategoryStatsDashboard />} />

                <Route path="/category">
                    <Route path=":categoryId" element={<CategoryProfile />} />
                </Route>

                <Route path="/measure">
                    <Route path=":measureId" element={<MeasureProfile />} />
                </Route>
                <Route path="/measure/list" element={<MeasureList />} />

                <Route path="/order" element={<OrderCodeList />} />

                <Route path="/order">
                    <Route path=":codeId" element={<OrderProfile />} />
                </Route>

                <Route path="/item">
                    <Route path=":itemId" element={<ItemProfile />} />
                </Route>

                <Route path="/stats" element={<OrderStatsDashboard />} />

                <Route path="/stats">
                    <Route path=":statsId" element={<OrderStatsProfile />} />
                </Route>

                <Route path="/order-tag">
                    <Route path=":tagId" element={< OrderTagProfile/>} />
                </Route>

            </Routes>
            <Footer />
        </BrowserRouter>
    );
}

export default PageRoutes;

