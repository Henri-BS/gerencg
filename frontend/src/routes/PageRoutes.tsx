import {Dashboard, ProductDashboard} from "pages/DashboardPages";
import Home from "pages/Home";
import { ProductsList, ProductValidateList } from "pages/Listings/ProductListing";
import { BrowserRouter, Route, Routes } from "react-router-dom"
import { ProductProfile, CategoryProfile, MeasureProfile, SaveProduct, UpdateProduct, SaveCategoryStats} from "pages/Profiles";
import { CategoryList } from "pages/Listings/CategoryListing";
import { MeasureList } from "pages/Listings/MeasureListing";
import { CommissionCodeList } from "pages/Listings/CommissionListing";
import { CommissionProfile, UpdateProductByItem } from "pages/Profiles/CommissionProfile";


function PageRoutes() {


    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/home" element={<Home />} />

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

                <Route path="/commission/list" element={<CommissionCodeList />} />

                <Route path="/commission">
                    <Route path=":code" element={<CommissionProfile />} />
                </Route>

                <Route path="/update-by-item">
                    <Route path=":itemId" element={<UpdateProductByItem />} />
                </Route>

            </Routes>
        </BrowserRouter>
    );
}

export default PageRoutes;