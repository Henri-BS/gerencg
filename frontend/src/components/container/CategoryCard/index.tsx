import moment from "moment";
import { Link } from "react-router-dom";
import { Category } from "types/category";
import "./styles.css"

    type Props = {
        category: Category;
    }

function CategoryCard({category}: Props) {
    
        return (
            <Link to={`/category/${category?.name}`}>
                <div className="category-display-card">
                    <img className="category-card-image" 
                    src={category?.image} 
                    alt={category?.name} />
                    <div className="category-card-container">
                        <h3><b>{category?.name}</b></h3>
    
                        <div className="category-products-container">
                            <h2>Atualizado em: {moment(category?.lastModifiedDate).format('DD/MM/YYYY, hh:mm')}</h2>
                        </div>
                    </div>
                </div>
            </Link>
        );
    }
export default CategoryCard;