import { Product } from "./product";

//Code

export type Code = {
  code: string;
  orderDate: string;
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
  content: Code[];
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

//Item

export type Item = {
  id: number;
  orderCode: string;
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

//Stats

export type OrderStats = {
  id: string;
  initialDate: string;
  finalDate: string;
  totalValue: number;
  averageWeek: number;
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
  statsId: string;
}

export type OrderStatsTotalValue = {
  totalValue: number;
  maxValue:number;
  amountOrders: number;
  amountItems: number;
};

export type OrderStatsQuantityGroup = {
  statsId: string;
  sumOrders: number;
}

export type OrderStatsValueGroup = {
  statsId: string;
  value: number;
}

export type OrderStatsValueGroupByCategory = {
  categoryName: string;
  value: number;
}


export type CommissionResults = {
  commissionCode: string;
  totalQuantity: number;
  totalValue: number;
};
