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
  income: number;
  category: string;
};

export type CategoryStatsPage = {
  content: CategoryStats[];
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
};

export type CategoryStatsValue = {
  maxValue: number;
  totalValue: number;
};
