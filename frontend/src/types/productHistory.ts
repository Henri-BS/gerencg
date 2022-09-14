export type ProductHistory = {
    id: number;
    description: string;
    image: string;
    price: number;
    quantity: number;
    validate: string;
    createdDate: string;
  };

  export type ProductHistoryPage = {
    content: ProductHistory[],
    size: number,
    pageNumber?: number;
    numberOfElements?: number;
    totalElements?: number;
    totalPages?: number;
    number?: number;
    empty?: boolean;
    first?: boolean;
    last?: boolean;
  };