import { Category } from "./category";
import { Measure } from "./measure";

export type Product = {
  id: number;
  description: string;
  image: string;
  price: number;
  quantity: number;
  validate: string;
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
