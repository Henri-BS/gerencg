import { Page } from "types/page";

type Props = {
    page: Page;
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