import axios, { AxiosRequestConfig } from "axios";
import moment from "moment";
import { ReactElement, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { Item, ItemProps } from "types/commission";
import { Product } from "types/product";
import { BASE_URL } from "utils/requests";


export function AddCommissionForm() {
    const navigate = useNavigate();

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        const code = (event.target as any).code.value;
        const commissionDate = (event.target as any).commissionDate.value;
        const distributor = (event.target as any).distributor.value;

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            url: "/save-commission",
            method: "POST",
            data: {
                code: code,
                commissionDate: commissionDate,
                distributor: distributor
            }
        }
        axios(config).then((response) => {
            navigate("/commission-list");
        })
    }
    return(
        <div className="form-container">
            <div className="form-card-container">
                <h1>Resgistrar um novo pedido</h1>
                <form className="gerencg-form" onSubmit={handleSubmit}>
                <div className="form-group gerencg-form-group">
                        <label htmlFor="code">Código do Pedido: </label>
                        <input 
                        type="text" 
                        className="form-control" 
                        id="code" 
                        placeholder="ex: 00.00.0000.00-aa"
                        />
                    </div>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="commissionDate">Data do Pedido: </label>
                        <input 
                        type="text" 
                        className="form-control" 
                        id="commissionDate" 
                        placeholder="0000-00-00"
                        />
                    </div>
                    <div className="form-group gerencg-form-group">
                        <label htmlFor="distributor">Distribuidora: </label>
                        <input 
                        type="text" 
                        className="form-control" 
                        id="distributor" 
                        placeholder="ex: Comercial Novo"
                        />
                    </div>

                    <div className="form-btn-container">
                        <button type="submit" className="gerencg-btn" >
                            Registrar Pedido
                        </button>
                    </div>
                
                <Link to="/commission-list">
                    <h5 className=" form-links mt-5">Ir para a Lista de Pedidos</h5>
                </Link>
                </form>
            </div>
        </div>
    );
}

