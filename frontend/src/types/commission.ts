import { CommissionCodeList } from "pages/Listings/CommissionListing";
import { Product } from "./product";

export type Commission = {
  id: number;
  commiddionCode: string;
  totalValue: number;
  quantity: number;
  product: Product;
};

export type CommissionPage = {
    content?: Commission[];
    last?: boolean;
  totalElements?: number;
  totalPages?: number;
  size?: number;
  number: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
};

export type Code = {
    code: string;
    commissionDate: string;
    distributor: string;
};

export type CodePage = {
    content?: Code[];
    last?: boolean;
  totalElements?: number;
  totalPages?: number;
  size?: number;
  number: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
};

export type CodeProps= {
    code: string;
}