import Footer from "components/shared/Footer";
import NavBar from "components/shared/NavBar";
import {Dashboard, ProductDashboard} from "pages/DashboardPages";
import Home from "pages/Home";
import { CategoryList, MeasureList, ProductsList, ProductValidateList } from "pages/Listings";
import { BrowserRouter, Route, Routes } from "react-router-dom"
import { ProductProfile, CategoryProfile, MeasureProfile, SaveProduct, UpdateProduct, SaveCategoryStats} from "pages/Profiles";


function PageRoutes() {


    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />

                <Route path="/product/list"element={<ProductsList/>}/>
                <Route path="/products-stats" element={<ProductDashboard />} />

                <Route path="/product/add" element={<SaveProduct />} />
                <Route path="/find-by-validate" element={<ProductValidateList />} />

                <Route path="/product">
                    <Route path=":productId" element={<ProductProfile />} />
                </Route>

                <Route path="/product/edit" >
                    <Route path=":productId" element={<UpdateProduct />} />
                </Route>

                <Route path="/category/list" element={<CategoryList />} />
                <Route path="/category-stats" element={<Dashboard />} />
                <Route path="/category-stats/add" element={<SaveCategoryStats />} />

                <Route path="/category">
                    <Route path=":categoryId" element={<CategoryProfile />} />
                </Route>

                <Route path="/measure">
                    <Route path=":measureId" element={<MeasureProfile />} />
                </Route>

                <Route path="/measure/list" element={<MeasureList />} />

            </Routes>
            <Footer />
        </BrowserRouter>
    );
}

export default PageRoutes;