import { Product } from "./product";


export type Order = {
  code: string;
  orderDate: string;
  distributor: string;
  expense: number;
  income: number;
  totalQuantity: number;
  amountItems: number;
  totalPackage: number;
  measure: string;
  dateCreated: string;
  dateUpdated: string;
  statsId: string;
  categoryId: string;
};

export type OrderPage = {
  content: Order[];
  last?: boolean;
  totalElements?: number;
  totalPages?: number;
  size?: number;
  number: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
};

export type OrderProps = {
  order: Order;
};

export type Item = {
  id: number;
  orderCode: string;
  costValue: number;
  unitValue: number;
  expense: number;
  income: number;
  quantity: number;
  packageQuantity: number;
  itemValidate: string;
  productId: Product;
  productDescription: string;
  productMeasure: string;
  productMeasureValue: number;
};

export type ItemPage = {
  content?: Item[];
  last?: boolean;
  totalElements?: number;
  totalPages?: number;
  size?: number;
  number: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
};

export type ItemProps = {
  item: Item;
};


export type OrderStats = {
  id: string;
  initialDate: string;
  finalDate: string;
  expense: number;
  income: number;
  expenseAverageWeek: number;
  incomeAverageWeek: number;
  amountOrder: number;
  amountItems: number;
};

export type OrderStatsPage = {
  content: OrderStats[];
  last?: boolean;
  totalElements: number;
  totalPages?: number;
  size?: number;
  number: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
};

export type OrderStatsProps = {
  stats: OrderStats;
}

export type OrderStatsTotalValue = {
  statsId: string;
  sumExpense: number;
  maxExpense:number;
  sumIncome: number;
  maxIncome:number;
  amountOrders: number;
  amountItems: number;
};

