export type Hero =  {
    "id": number,
    "name": string,
    "height": string,
    "mass": string,
    "hair_color": string,
    "skin_color": string,
    "eye_color": string,
    "birth_year": string,
    "gender": string
};

export interface Character {
    "name": string,
    "img": string,
    "url": string
}

export interface Characters {
    [key: string]: Character;
}

export interface ItemForNavigation {
    title:string,
    route:string
}

export interface ReactProps{
    [key: string]:any;
}

export interface HeroForContext{
    hero:string,
    setHero:(hero:string)=>void
}