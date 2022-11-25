/** Category types */

export type Category = {
  name: string;
  image: string;
  totalProducts: number;
  totalRegisters: number;
  lastModifiedDate: string;
};

export type CategoryPage = {
  content: Category[];
  last?: boolean;
  totalElements?: number;
  totalPages?: number;
  size?: number;
  number: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
};

export type CategoryProps = {
  categoryId: string
}

/** CategoryStats types */

export type CategoryStats = {
  id: number; 
  registrationDate: string;
  addedProducts: number;
  removedProducts: number;
  income: number;
  expense: number;
  category: Category;
};

export type StatsPage = {
  content?: CategoryStats[];
  last?: boolean;
  totalElements?: number;
  totalPages?: number;
  size?: number;
  number: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
};

export type CategoryValue = {
  categoryName: string;
  income: number;
  expense: number;
};

export type FlowCategory = {
  categoryName: string;
  addedProduct: number;
  removedProduct: number;
};
