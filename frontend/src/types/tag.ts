export type OrderTag = {
  id: number;
  orderId: string;
  orderDate: string;
  distributor: string;
  category: string;
  tagId: string;
};

export type Tag = {
tagId: string;
description: string;
}

export type TagPage = {
    content: Tag[];
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

export type OrderTagPage = {
  content?: OrderTag[];
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

export type OrdersTagProps = {
  orderTag: OrderTag;
}

export type TagProps = {
  tag: Tag;
};
