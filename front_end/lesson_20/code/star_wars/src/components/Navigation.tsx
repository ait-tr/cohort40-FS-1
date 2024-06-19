import {navItems} from "../utils/constants.tsx";
import NavItem from "./NavItem.tsx";

const Navigation = () => {
    return (
        <nav className="fixed-top mt-2 ms-5">
            <ul className="nav">
                {navItems.map(item => <NavItem key={item.title}
                                               item={item}/>)}
            </ul>
        </nav>
    );
};

export default Navigation;