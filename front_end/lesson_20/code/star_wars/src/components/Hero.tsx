import {useContext} from 'react';
import {UserContext} from "../utils/useContext.tsx";
import {characters} from "../utils/characters.tsx";

const Hero = () => {
    const {hero} = useContext(UserContext);
    return (
        <section className="float-start w-25">
            <img className="w-100" src={characters[hero].img} alt="hero"/>
        </section>
    );
};

export default Hero;