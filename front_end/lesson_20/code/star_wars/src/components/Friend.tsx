import {useNavigate} from "react-router-dom";
import {navItems} from "../utils/constants.tsx";
import {characters} from "../utils/characters.tsx";

interface Props {
    friend:string,
    pos:number
}

const Friend = ({friend,pos}:Props) => {
    const navigate = useNavigate();
    let styles = "col-4 p-1";
    if(pos===7){
        styles = "bottom-left col-4 p-1";
    }
    if(pos === 9 ){
        styles = "bottom-right col-4 p-1";
    }
    return (
        <img onClick={()=> navigate(`/${navItems[0].route}/${friend}`)}
             className={styles} src={characters[friend].img} alt="friend"/>
    );
};

export default Friend;