import Home from "pages/Home";
import { ProductsList, ProductValidateList } from "pages/Listings/ProductListing";
import { BrowserRouter, Route, Routes } from "react-router-dom"
import { ProductProfile, MeasureProfile, ProductDashboard, ProductHistoryProfile } from "pages/Profiles/ProductProfile";
import { CategoryList } from "pages/Listings/CategoryListing";
import { MeasureList } from "pages/Listings/MeasureListing";
import { OrderCodeList } from "pages/Listings/OrderListing";
import { OrderProfile , ItemProfile, OrderStatsDashboard, OrderStatsProfile, OrderTagProfile } from "pages/Profiles/OrderProfile";
import { CategoryProfile, CategoryStatsDashboard } from "pages/Profiles/CategoryProfile";
import NavBar from "components/shared/NavBar";
import Footer from "components/shared/Footer";


function PageRoutes() {


    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/home" element={<Home />} />

                <Route path="/product-list" element={<ProductsList />} />
                <Route path="/products-stats" element={<ProductDashboard />} />

                <Route path="/find-by-validate" element={<ProductValidateList />} />

                <Route path="/product">
                    <Route path=":productId" element={<ProductProfile />} />
                </Route>
                <Route path="/history" >
                    <Route path=":historyId" element={<ProductHistoryProfile />} />
                </Route>

                <Route path="/category/list" element={<CategoryList />} />
                <Route path="/category-stats" element={<CategoryStatsDashboard />} />

                <Route path="/category">
                    <Route path=":categoryId" element={<CategoryProfile />} />
                </Route>

                <Route path="/measure">
                    <Route path=":measureId" element={<MeasureProfile />} />
                </Route>
                <Route path="/measure/list" element={<MeasureList />} />

                <Route path="/order/list" element={<OrderCodeList />} />

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

