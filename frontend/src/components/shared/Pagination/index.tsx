import { CategoryPage } from "types/category";
import { StatsPage } from "types/categoryStats";
import { MeasurePage } from "types/measure";
import { ProductPage } from "types/product";
import { ProductHistoryPage } from "types/productHistory";
type Props = {
    page: ProductPage | StatsPage | CategoryPage | MeasurePage | ProductHistoryPage;
    onPageChange: Function;
}

const Pagination = ({ page, onPageChange } : Props) => {

    return (
        
            <nav>
                <ul className="pagination ">
                    <li className={`page-item ${page.first ? 'disabled' : ''} `}>
                        <button className="page-link" onClick={() => onPageChange(page.number - 1)}>Anterior</button>
                    </li>
                    <li className="page-item disabled">
                        <span className="page-link">{page.number + 1} de {page.totalPages}</span>
                    </li>
                    <li className={`page-item ${page.last ? 'disabled' : ''} `}>
                        <button className="page-link" onClick={() => onPageChange(page.number + 1)}>Próxima</button>
                    </li>
                </ul>
            </nav>
        
    )
}

export default Pagination;