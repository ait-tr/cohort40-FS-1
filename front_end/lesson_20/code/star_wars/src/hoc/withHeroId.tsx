import {useNavigate, useParams} from "react-router-dom";
import React, {useContext, useEffect} from "react";
import {UserContext} from "../utils/useContext.tsx";
import {characters} from "../utils/characters.tsx";
import {defaultHero} from "../utils/constants.tsx";
import {ReactProps} from "../utils/types.ts";

// HOC - High order component - компонент обертка для компонентов с общим набором функционала
export const withHeroId = (route: string) => (Component: React.FunctionComponent) => (props:ReactProps)=>{
    // Используем параметры из динамической маршрутизации
    const {heroId} = useParams();
    const {setHero: changeMainHero} = useContext(UserContext);
    // Для служебного перехода на маршрут
    const navigate = useNavigate();

    useEffect(()=>{
        if(!Object.keys(characters).includes(heroId!)){
            // Переадресация маршрута на шаблонный вариант
            navigate(`/${route}/${defaultHero}`);
        }else {
            changeMainHero(heroId!);
        }
    },[heroId])

    return (
        <Component {...props}/>
    )
}