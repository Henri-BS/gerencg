import { Category } from "./category";
import { Measure } from "./measure";

/** Product types */

export type ProductProps = {
  productId: string;
}

export type Product = {
  id: number;
  description: string;
  image: string;
  price: number;
  quantity: number;
  validate: string;
  lastUpdateDate: string;
  measureValue: number;
  measure: Measure;
  category: Category;
};

export type ProductPage = {
  content?: Product[];
  size?: number;
  pageNumber?: number;
  numberOfElements?: number;
  totalElements?: number;
  totalPages?: number;
  number: number;
  empty?: boolean;
  first?: boolean;
  last?: boolean;
};

export type QuantityTimelineChart = {
  description: string;
  quantity: number;
};

/** ProductHistory types */

export type ProductHistory = {
  id: number;
  price: number;
  quantity: number;
  validate: string;
  income: number;
  createdDate: string;
  productId: number;
};

export type ProductHistoryPage = {
  content: ProductHistory[],
  size: number,
  pageNumber?: number;
  numberOfElements?: number;
  totalElements?: number;
  totalPages?: number;
  number: number;
  empty?: boolean;
  first?: boolean;
  last?: boolean;
};

export type HistoryProps = {
  historyId: string;
}
