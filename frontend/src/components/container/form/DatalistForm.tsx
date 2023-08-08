import axios from "axios";
import { useEffect, useState } from "react";
import { MeasurePage } from "types/measure";
import { ProductPage } from "types/product";
import { BASE_URL } from "utils/requests";

export function ProductDatalist(){
    const [productPage, setProductPage] = useState<ProductPage>({
        content: [],
        number: 0
    })
    const [value, setValue] = useState("");
    useEffect(() => {
        axios.get(`${BASE_URL}/product/search?description=${value}`)
            .then(response => {
                setProductPage(response.data);
            });
    }, [value]);

    return (
        <div className="form-group gerencg-form-group">
                        <label htmlFor="product">Produto: </label>
                        <input type="text" list="productDescription" value={value} onChange={(e) => setValue(e.target.value)} id="product" className="form-control" placeholder="busque pelo produto..." />
                        <datalist id="productDescription" >
                            {productPage.content?.filter((product) =>
                                product.description.toLowerCase().includes(value.toLocaleUpperCase().toLocaleLowerCase()))
                                .map((product) => (
                                    <option id="value" key={product.id} value={product.description}>
                                        {product.description} - {product.measureValue} {product.measure}
                                    </option>
                                ))}
                        </datalist>
                    </div>
    );
}

