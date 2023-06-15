import { Category, CategoryStats } from "./category";
import { Measure } from "./measure";
import { Code, Item } from "./order";
import { Product, ProductHistory } from "./product";
import { Tag } from "./tag";

export type Props = {
    id: String
}

export  type Page = {
    content?:Product[] | CategoryStats[] | Category[] | Measure[] |
    ProductHistory[] | Code[] | Item[] | Tag[];
    size?: number;
    pageNumber?: number;
    numberOfElements?: number;
    totalElements?: number;
    totalPages?: number;
    number: number;
    empty?: boolean;
    first?: boolean;
    last?: boolean;
}