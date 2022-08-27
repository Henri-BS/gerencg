export type Category = {
    id: number;
    name: string;
    totalProducts: number;
    totalRegisters: number;
    lastModifiedDate: string;
}

export type CategoryPage = {
    content?: Category[];
    last: boolean;
        totalElements: number;
        totalPages: number;
        size?: number;
        number: number;
        first: boolean;
        numberOfElements?: number;
        empty?: boolean
}