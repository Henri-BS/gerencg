import axios from "axios";
import moment from 'moment';
import { useEffect, useState } from "react";
import { BASE_URL } from "utils/requests";
import "./styles.css"
import { Category } from "types/category";

type Props = {
    categoryId: string;
}

function CategoryColumn({ categoryId }: Props) {

    const [category, setCategory] = useState<Category>()

    useEffect(() => {
        axios.get(`${BASE_URL}/category/${categoryId}`)
            .then(response => {
                setCategory(response.data);
            });
    }, [categoryId]);

    return (    
        <>  
        <div className="column-image-container">           
         <img className="column-card-image" src={category?.image} alt={category?.name} />    
</div>
      <div className="column-container">
      <div className="column-item-container">
              <h1>{ category?.name}</h1>
          </div>
          <div className="column-item-container">
              <h3>Última Atualização: {moment(category?.lastModifiedDate).format('lll')} </h3>
          </div>
          <div className="column-item-container">
              <h3>Total de Produtos: {category?.totalProducts} </h3>
          </div>
          <div className="column-item-container">
              <h3>Total de Registros: {category?.totalRegisters}</h3>
          </div>
          </div>     
          </>
  );
}

export default CategoryColumn;