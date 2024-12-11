import { categoryMockdata, orderMockdata, productMockdata } from "mock/MockData";
import moment, { now } from "moment";
import { useState } from "react";
import { Link } from "react-router-dom";

export function CategoryMockCard() {

    return (
        <div className="row">
            {categoryMockdata.map((item, index) => {
                return (
                    <div key={index} className="col-12 col-md-6 mb-3">
                        <Link to={`/category/${item?.name}`}>
                            <div className="category-display-card">
                                <img className="category-card-image" src={item.image} alt={item?.name} />
                                <div className="category-card-container">
                                    <h3><b>{item?.name}</b></h3>
                                    <div className="category-details-container">
                                        <h2>Atualizado em: {moment(now()).format('DD/MM/YYYY, hh:mm')}</h2>
                                    </div>
                                </div>
                            </div>
                        </Link>
                    </div>
                )
            })
            }
        </div>
    );
}

export function CategoryMockHomeCard() {

    return (
        <div className="horizontal-list">
            {categoryMockdata.map((category, index) => {
                categoryMockdata.length = 10
                return (
                    <div key={index} className="list-item">
                        <Link to={`/category/${category?.name}`}>
                            <div className="category-display-card">
                                <img className="category-card-image" src={category?.image} alt={category?.name} />
                                <div className="category-card-container">
                                    <h3><b>{category?.name}</b></h3>
                                    <div className="category-details-container">
                                        <h2>Atualizado em: {category?.dateUpdated}</h2>
                                    </div>
                                </div>
                            </div>
                        </Link>
                    </div>
                )
            })
            }
        </div>
    );
}

export function ProductMockCard() {

    return (
        <>

            <div className="row mt-4">
                {productMockdata.map((product, index) => {
                    return (
                        <div key={index} className="col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 mb-3">
                            <Link to={`/product/${product?.id}`}>
                                <div className={"product-card-container"}>
                                    <img className="product-card-image" src={product?.image} alt={product?.description} />
                                    <div className="product-info-box">
                                        <h3 className="product-info-title">{product?.description} • {product?.measureValue} {product?.measure}</h3>

                                        <div className="product-info-item">
                                            <h6>Preço: {product?.price?.toFixed(2)} R$</h6>
                                        </div>
                                    </div>
                                </div>
                            </Link>
                        </div>
                    )
                })
                }
            </div>
        </>
    );
}

export function ProductMockHomeCard() {

    return (
        <div className="horizontal-list">
            {productMockdata.map((product, index) => {
                productMockdata.length = 10
                return (
                    <div key={index} className="list-item">
                        <Link to={`/product/${product?.id}`}>
                            <div className={"product-card-container"}>
                                <img className="product-card-image" src={product?.image} alt={product?.description} />
                                <div className="product-info-box">
                                    <h3 className="product-info-title">{product?.description} • {product?.measureValue} {product?.measure}</h3>

                                    <div className="product-info-item">
                                        <h6>Preço: {product?.price?.toFixed(2)} R$</h6>
                                    </div>
                                </div>
                            </div>
                        </Link>
                    </div>
                )
            })
            }
        </div>
    );
}


export function OrderMockCard() {

    return (
        <>
            <div className="row mt-4">
                {orderMockdata.map((order, index) => {
                    return (
                        <div key={index} className="col-12 col-sm-6 col-md-6 col-lg-4 col-xl-4 mb-3">
                            <Link to={`/order/${order.code}`}>
                                <div className="order-card ">
                                    <div className="order-box border-dark">
                                        <h2>Código do Pedido: <p>{order.code}</p></h2>
                                    </div>
                                    <div className="order-box ">
                                        <h3>Data do Pedido: {moment(order.orderDate).format("DD/MM/YYYY")}</h3>
                                    </div>
                                    <div className="order-box ">
                                        <h3>Distribuidora: {order.distributor}</h3>
                                    </div>
                                    <div className="order-box border-0">
                                        <h3>Categoria: {order.categoryId}</h3>
                                    </div>
                                </div>
                            </Link>
                        </div>
                    )
                })
                }
            </div>
        </>
    );
}

export function OrderMockHomeCard() {

    return (
        <div className="horizontal-list">
            {orderMockdata.map((order, index) => {
                orderMockdata.length = 10
                return (
                    <div key={index} className="list-item">
                        <Link to={`/order/${order.code}`}>
                                <div className="order-card ">
                                    <div className="order-box border-dark">
                                        <h2>Código do Pedido: <p>{order.code}</p></h2>
                                    </div>
                                    <div className="order-box ">
                                        <h3>Data do Pedido: {moment(order.orderDate).format("DD/MM/YYYY")}</h3>
                                    </div>
                                    <div className="order-box ">
                                        <h3>Distribuidora: {order.distributor}</h3>
                                    </div>
                                    <div className="order-box border-0">
                                        <h3>Categoria: {order.categoryId}</h3>
                                    </div>
                                </div>
                            </Link>
                    </div>
                )
            })
            }
        </div>
    );
}
