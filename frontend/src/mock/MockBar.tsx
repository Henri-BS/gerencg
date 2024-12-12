import { Props } from "types/page";
import { categoryMockdata, orderMockdata, productMockdata } from "./MockData";
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
                        <div className="sidebar-container">
                            <div className="sidebar-image-container">
                                <img className="sidebar-card-image" src={product?.image} alt={product?.description} />
                            </div>
                            <h1>{product?.description}</h1>

                            <div className="sidebar-item-container">
                                <div className="sidebar-icon-container"> {productIcons.priceIcon} </div>
                                <h3>Preço: {product?.price.toFixed(2)} R$</h3>
                            </div>
                            <Link to={`/measure/${product?.measure}`} className="sidebar-item-container">
                                <div className="sidebar-icon-container">{productIcons.measureIcon}</div>
                                <h3>Medida: {product?.measureValue} {product?.measure}</h3>
                            </Link>
                            <div className="sidebar-item-container">
                                <div className="sidebar-icon-container">{productIcons.quantityIcon}</div>
                                <h3>Quantidade: {product?.quantity}</h3>
                            </div>
                            <Link to={`/find-by-validate`} className="sidebar-item-container">
                                <div className="sidebar-icon-container">{productIcons.validateIcon}</div>
                                <h3>Validade: {moment(product?.validate).format('DD/MM/YYYY') ?? "Indefinido"} </h3>
                            </Link>
                            <Link to={`/category/${product?.category}`} className="sidebar-item-container">
                                <div className="sidebar-icon-container">{productIcons.categoryIcon}</div>
                                <h3>Category: {product?.category} </h3>
                            </Link>
                        </div>
                        <div className="sidebar-card-bottom">
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
                        <div className="sidebar-container">
                            <div className="sidebar-image-container">
                                <img className="sidebar-card-image" src={category?.image} alt={category?.name} />
                            </div>
                            <h1>{category?.name}</h1>
                            <div className="sidebar-item-container">
                                <div className="sidebar-icon-container">{categoryIcons.totalProductsIcon}</div>
                                <h3>Total de Produtos: {category?.totalProducts} </h3>
                            </div>
                            <div className="sidebar-item-container">
                                <div className="sidebar-icon-container">{categoryIcons.totalRegistersIcon}</div>
                                <h3>Total de Registros: {category?.totalRegisters}</h3>
                            </div>
                            <div className="sidebar-item-container">
                                <div className="sidebar-icon-container">{categoryIcons.createdDateIcon}</div>
                                <h3>Data de Criação: {moment(category?.dateCreated).format('DD/MM/YYYY')}</h3>
                            </div>
                        </div>

                        <div className="sidebar-card-bottom">
                            <h4>Última Alteração: {moment(category?.dateUpdated).format('DD/MM/YYYY')} </h4>
                        </div>
                    </div>
                )
            })}
        </>
    );
}

export function OrderMockMenuBar({ id: orderId }: Props) {

    const filterById = (id: any) => {
        return orderMockdata.filter(item => item.code === id);
    };

    const result = filterById(orderId);

    return (
        <>
            {result.map((order, index) => {
                return (
                    <div key={index}>
                        <div className="bar-container">
                            <h2>Informações de Identificação</h2>
                            <div className="row">
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 ">
                                    <div className="bar-item-content"> <b>Código:</b> {order?.code}</div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 ">
                                    <div className="bar-item-content"> <b>Data de Emissão:</b> {moment(order?.orderDate).format('DD/MM/YYYY')}</div>
                                </div>
                                <div className="bar-item col-12 col-sm-12 col-md-6 col-lg-4 col-xl-4 ">
                                    <div className="bar-item-content"> <b>Distribuidora:</b> {order?.distributor}</div>
                                </div>
                            </div>
                        </div>

                        <div className="bar-container">
                            <h2>Valores Totais do Produtos</h2>
                            <div className="row">
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Quantidade de Itens:</b> {order?.amountItems}</div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Tipo de Pacote:</b> {order?.measure} </div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Total de Pacotes:</b> {order?.totalPackage} </div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Total de Unidades:</b> {order?.totalQuantity} </div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Valor Total do Pedido:</b> {order?.expense.toFixed(2)} </div>
                                </div>
                                <div className="bar-item col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div className="bar-item-content"> <b>Categoria:</b> {order?.categoryId} </div>
                                </div>
                            </div>
                        </div>
                    </div>
                )
            })}
        </>
    )
}

export function OrderStatsTotalValuesMockBar() {

    return (
        <>

            <div className="max-bar-container">
                <div className="bar-container row">
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Pedidos:</b> 10 </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Despesas:</b> 1050.75 </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Maior Despesa Mensal:</b> 336.00 </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Total de Itens:</b> 832 </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Expectativa Total de Renda:</b> 3300.70 </div>
                    </div>
                    <div className="bar-item col-12 col-sm-6 col-xl-4 ">
                        <div className="bar-item-content"> <b>Maior Renda Mensal:</b> 521.32 </div>
                    </div>
                </div>
            </div>
        </>
    )
}