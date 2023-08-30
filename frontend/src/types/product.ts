import { Category } from "./category";
import { Measure } from "./measure";

export type Product = {
  id: number;
  description: string;
  image: string;
  price: number;
  quantity: number;
  validate: string;
  dateCreated: string;
  dateUpdate: string;
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

export type ProductProps = {
  product: Product;
}

export type QuantityTimelineChart = {
  description: string;
  quantity: number;
};

export type ProductHistory = {
  id: number;
  price: number;
  quantity: number;
  validate: string;
  income: number;
  dateCreated: string;
  productId: number;
  productDescription: string;
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

export type ProductHistoryProps = {
  history: ProductHistory
}