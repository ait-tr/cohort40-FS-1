import {useContext, useEffect, useState} from 'react';
import {navItems, period} from "../utils/constants.tsx";
import "../css/aboutMe.css";
// 1. Пример использования модулей для работы со стилистикой
// import style from '../css/aboutMe.module.css';
import {characters} from "../utils/characters.tsx";
import {withHeroId} from "../hoc/withHeroId.tsx";
import {UserContext} from "../utils/useContext.tsx";
import {Hero} from "../utils/types.ts";

const AboutMe = () => {
    const [hero, setHero] = useState<Hero>();
    const {hero: heroId} = useContext(UserContext)

    useEffect(() => {
        const hero = JSON.parse(localStorage.getItem(heroId)!);
        if (hero && ((Date.now() - hero.time) < period)) {
            setHero(hero.payload);
        } else {
            const char = characters[heroId];
            fetch(char.url)
                .then(response => response.json())
                .then(data => {
                    const hero = {
                        "id": data.id,
                        "name": data.name,
                        "height": data.height,
                        "mass": data.mass,
                        "hair_color": data.hair_color,
                        "skin_color": data.skin_color,
                        "eye_color": data.eye_color,
                        "birth_year": data.birth_year,
                        "gender": data.gender
                    };
                    setHero(hero)
                    const info = {
                        payload: hero,
                        time: Date.now()
                    }
                    localStorage.setItem(heroId, JSON.stringify(info));
                });
        }
    },[heroId])


    return (
        <div>
            {(hero) &&
                // <div className={style.hero_titles}>
                <div className={"farGalaxy hero_box"}>
                    <p><span className={"hero_text"}>Name:</span>{hero.name}</p>
                    <p><span className={"hero_text"}>Id:</span>{hero.id}</p>
                    <p><span className={"hero_text"}>Height:</span> {hero.height}</p>
                    <p><span className={"hero_text"}>Birth Year:</span> {hero.birth_year}</p>
                    <p><span className={"hero_text"}>Eye color:</span> {hero.eye_color}</p>
                    <p><span className={"hero_text"}>Gender:</span> {hero.gender}</p>
                    <p><span className={"hero_text"}>Mass:</span> {hero.mass}</p>
                </div>
            }
        </div>
    );
}

export default withHeroId(navItems[1].route)(AboutMe);