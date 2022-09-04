export type Measure = {
  description: string;
  abbreviation: string;
};

export type MeasurePage = {
  content?: Measure[];
  last?: boolean;
  totalElements?: number;
  totalPages?: number;
  size?: number;
  number?: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
}

