import { Link } from "react-router-dom";
import "./styles.css";
function CategoryCard() {

    const category = {
        id: 1,
        image: "https://th.bing.com/th/id/R.cd47cfe5d35976c29a4089ba8d956595?rik=s0Q58BKLtkebuw&riu=http%3a%2f%2fwww.ninos-felices.com.mx%2fwp-content%2fuploads%2f2014%2f08%2feat4.png&ehk=PXorkH%2bYrhBsYUYviRrUztj2P7R7n9KRnA%2f2eNSCJlY%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1",
        title: "Alimentícios",
    };
    
    return (
    <div> 
        <Link to="gerencg/category/1">
        <img className="gerencg-card-image" src={category.image} alt={category.title} />
        <div className="gerencg-card-container">  <h3>{category.title}</h3>         
     </div>
     </Link>
    </div>
    );
    
    }

export default CategoryCard;