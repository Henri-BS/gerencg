import { Category } from "./category"

export type Product = {
    id: number;
    description: string;
    image: string;
    price: number;
    quantity: number;
    validate: string;
    measureValue: number;
    measure: string;
    category: Category;
}

export type PageProduct = {
    content?: Product[];
size?: number;
pageNumber?: number;
numberOfElements: number;
totalElements?: number;
totalPages: number;
number: number;
empty?: boolean;
first: boolean;
last: boolean;
}