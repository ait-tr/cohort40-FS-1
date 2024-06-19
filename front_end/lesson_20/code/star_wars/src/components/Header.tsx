import {useContext} from 'react';
import Navigation from "./Navigation.tsx";
import {UserContext} from "../utils/useContext.tsx";
import {characters} from "../utils/characters.tsx";

const Header = () => {
    const {hero} = useContext(UserContext);
    return (
        <header>
            <Navigation/>
            <p className="text-center py-4 h1">{characters[hero].name}</p>
        </header>
    );
};

export default Header;