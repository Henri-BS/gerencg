import axios from "axios";
import { BASE_URL } from "utils/requests";

class ProductService {

findProductById(id: string) {
    return axios.get(`${BASE_URL}/product/${id}`)
}

saveProduct(productData: any) {
    return axios.post(`${BASE_URL}/product/add`, productData)
}

updateProduct(id: string, productData: any){
    return axios.put(`${BASE_URL}/product/edit/${id}`, productData)
}

};
export default new ProductService();