import Home from "pages/Home";
import { ProductsList, ProductValidateList } from "pages/Listings/ProductListing";
import { BrowserRouter, Route, Routes } from "react-router-dom"
import { ProductProfile, MeasureProfile, SaveProduct, UpdateProduct, ProductDashboard} from "pages/Profiles/ProductProfile";
import { CategoryList } from "pages/Listings/CategoryListing";
import { MeasureList } from "pages/Listings/MeasureListing";
import { CommissionCodeList } from "pages/Listings/CommissionListing";
import { CommissionProfile, ItemProfile } from "pages/Profiles/CommissionProfile";
import { CategoryProfile, CategoryStatsDashboard, SaveCategoryStats } from "pages/Profiles/CategoryProfile";
import NavBar from "components/shared/NavBar";
import Footer from "components/shared/Footer";


function PageRoutes() {


    return (
        <BrowserRouter>
        <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/home" element={<Home />} />

                <Route path="/product-list"element={<ProductsList/>}/>
                <Route path="/products-stats" element={<ProductDashboard />} />

                <Route path="/product-add" element={<SaveProduct />} />
                <Route path="/find-by-validate" element={<ProductValidateList />} />

                <Route path="/product">
                    <Route path=":productId" element={<ProductProfile />} />
                </Route>
                <Route path="/product-edit" >
                    <Route path=":productId" element={<UpdateProduct />} />
                </Route>

                <Route path="/category/list" element={<CategoryList />} />
                <Route path="/category-stats" element={<CategoryStatsDashboard />} />
                <Route path="/category-stats/add" element={<SaveCategoryStats />} />

                <Route path="/category">
                    <Route path=":categoryId" element={<CategoryProfile />} />
                </Route>

                <Route path="/measure">
                    <Route path=":measureId" element={<MeasureProfile />} />
                </Route>
                <Route path="/measure/list" element={<MeasureList />} />

                <Route path="/commission-list" element={<CommissionCodeList />} />

                <Route path="/commission">
                    <Route path=":codeId" element={<CommissionProfile />} />
                </Route>

                <Route path="/item">
                    <Route path=":itemId" element={<ItemProfile />} />
                </Route>

            </Routes>
            <Footer />
        </BrowserRouter>

        
    );
}

export default PageRoutes;

