import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Category, CategoryProps, CategoryStats } from "types/category";
import { BASE_URL } from "utils/requests";
import "./styles.css"

type Props = {
    category: Category;
}

export function CategoryCard({ category }: Props) {

    return (
        <Link to={`/category/${category?.name}`}>
            <div className="category-display-card">
                <img className="category-card-image"
                    src={category?.image}
                    alt={category?.name} />
                <div className="category-card-container">
                    <h3><b>{category?.name}</b></h3>
                    <div className="category-details-container">
                        <h2>Atualizado em: {moment(category?.lastModifiedDate).format('DD/MM/YYYY, hh:mm')}</h2>
                    </div>
                </div>
            </div>
        </Link>
    );
}


