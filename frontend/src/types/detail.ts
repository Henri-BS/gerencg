import { Category } from "./category"

export type Detail = {
        id: number;
        prod_adc: number;
        prod_remov: number;
        upd_val: number;
        date: string;
        category: Category;
}

export type DetailPage = {
        content?: Detail[];
        last: boolean;
        totalElements: number;
        totalPages: number;
        size?: number;
        number: number;
        first: boolean;
        numberOfElements?: number;
        empty?: boolean
}

export type CategoryValue = {
        categoryName: string;
        sum: number;
}

export type FlowCategory = {
        categoryName: string;
        prod_adc: number;
        prod_remov: number;
}