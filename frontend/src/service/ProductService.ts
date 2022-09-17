import axios from "axios";
import { BASE_URL } from "utils/requests";

class ProductService {

findProductsByValidate() {
    return axios.get(`${BASE_URL}/product/list?sort=validate`)
}

};
export default new ProductService();