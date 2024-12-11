import { Props } from "types/page";
import { categoryMockdata, categoryStatsMockdata, productMockdata } from "./MockData";
import { categoryIcons, productIcons } from "components/shared/MenuIcons";
import { Link } from "react-router-dom";
import moment from "moment";

export function ProductMockSideBar({ id: productId }: Props) {

    const filterById = (id: any) => {
        return productMockdata.filter(item => item.id.toString() === id);
    };
    
    const result = filterById(productId);

    return (
        <>
            {result.map((product, index) => {
                return (
                    <div key={index} className="max-sidebar-container">
                        <div className="column-container">
                            <div className="column-image-container">
                                <img className="column-card-image" src={product?.image} alt={product?.description} />
                            </div>
                            <h1>{product?.description}</h1>

                            <div className="column-item-container">
                                <div className="column-icon-container"> {productIcons.priceIcon} </div>
                                <h3>Preço: {product?.price.toFixed(2)} R$</h3>
                            </div>
                            <Link to={`/measure/${product?.measure}`} className="column-item-container">
                                <div className="column-icon-container">{productIcons.measureIcon}</div>
                                <h3>Medida: {product?.measureValue} {product?.measure}</h3>
                            </Link>
                            <div className="column-item-container">
                                <div className="column-icon-container">{productIcons.quantityIcon}</div>
                                <h3>Quantidade: {product?.quantity}</h3>
                            </div>
                            <Link to={`/find-by-validate`} className="column-item-container">
                                <div className="column-icon-container">{productIcons.validateIcon}</div>
                                <h3>Validade: {moment(product?.validate).format('DD/MM/YYYY') ?? "Indefinido"} </h3>
                            </Link>
                            <Link to={`/category/${product?.category}`} className="column-item-container">
                                <div className="column-icon-container">{productIcons.categoryIcon}</div>
                                <h3>Category: {product?.category} </h3>
                            </Link>
                        </div>
                        <div className="column-card-bottom">
                            <h4>Última Atualização: {moment(product?.dateUpdate).format('DD/MM/YYYY')}</h4>
                        </div>
                    </div>
                )
            })}
        </>
    );
}


export function CategoryMockSideBar({ id: categoryId }: Props) {
  
    const filterById = (id: any) => {
        return categoryMockdata.filter(item => item.name === id);
    };
    
    const result = filterById(categoryId);

    return (
        <>
            {result.map((category, index) => {
                return (
                    <div key={index} className="max-sidebar-container">
                <div className="column-container">
                    <div className="column-image-container">
                        <img className="column-card-image" src={category?.image} alt={category?.name} />
                    </div>
                    <h1>{category?.name}</h1>
                    <div className="column-item-container">
                        <div className="column-icon-container">{categoryIcons.totalProductsIcon}</div>
                        <h3>Total de Produtos: {category?.totalProducts} </h3>
                    </div>
                    <div className="column-item-container">
                        <div className="column-icon-container">{categoryIcons.totalRegistersIcon}</div>
                        <h3>Total de Registros: {category?.totalRegisters}</h3>
                    </div>
                    <div className="column-item-container">
                        <div className="column-icon-container">{categoryIcons.createdDateIcon}</div>
                        <h3>Data de Criação: {moment(category?.dateCreated).format('DD/MM/YYYY')}</h3>
                    </div>
                </div>
                
                <div className="column-card-bottom">
                    <h4>Última Alteração: {moment(category?.dateUpdated).format('DD/MM/YYYY')} </h4>
                </div>
            </div>
                )
            })}
        </>
    );
}
