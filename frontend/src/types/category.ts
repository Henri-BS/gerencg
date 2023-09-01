

export type Category = {
  name: string;
  image: string;
  totalProducts: number;
  totalRegisters: number;
  dateCreated: string;
  dateUpdated: string;
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
  category: Category
}

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



export type CategoryStatsValue = {
  categoryName: string;
  quantity: number;
  maxValue: number;
  totalValue: number;
};
