import { Category } from "./category"

export type CategoryStats = {
        id: number;
        addedProducts: number;
        removedProducts: number;
        income: number;
        expense: number;
        registrationDate: string;
        category: Category;
}

export type StatsPage = {
        content?: CategoryStats[];
        last?: boolean;
        totalElements?: number;
        totalPages?: number;
        size?: number;
        number: number;
        first?: boolean;
        numberOfElements?: number;
        empty?: boolean
}

export type CategoryValue = {
        categoryName: string;
        income: number;
        expense: number;
}

export type FlowCategory = {
        categoryName: string;
        addedProduct: number;
        removedProduct: number;
}