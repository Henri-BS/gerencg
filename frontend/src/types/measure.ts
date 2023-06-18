export type Measure = {  
  abbreviation: string;
  description: string;
  dateCreated: string;
  dateUpdated: string;
};
  
export type MeasurePage = {
  content: Measure[];
  last?: boolean;
  totalElements?: number;
  totalPages?: number;
  size?: number;
  number: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
}

export type MeasureProps = {
  measure: Measure;
}

