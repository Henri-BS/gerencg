import { Product } from "./product";

export type Code = {
  code: string;
  commissionDate: string;
  distributor: string;
  totalValue: number;
  totalQuantity: number;
  amountItems: number;
  totalPackage: number;
  packageType: string;
  statsId: string;
categoryId: string;
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

export type CodeProps = {
  codeId: string;
};

export type Item = {
  id: number;
  commissionCode: string;
  unitValue: number;
  totalValue: number;
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
  itemId: string;
};

export type CommissionStats = {
  initialDate: string;
  finalDate: string;
  totalValue: number;
  averageWeek: number;
  amountCommission: number;
  amountItems: number;
}

export type CommissionResults = {
  commissionCode: string;
  totalQuantity: number;
  totalValue: number;
}