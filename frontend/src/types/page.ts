import { CategoryStats } from "./categoryStats";
import { Product } from "./product";

export type Page = {
    content?: Product[] | CategoryStats[];
    last: boolean;
    first: boolean;
    empty?: boolean;
    totalPages: number;
    totalElements: number;
    numberOfElements?: number;
    size?: number;
    number: number;
  };