import React from "react";
import {HeroForContext} from "./types.ts";

export const UserContext = React.createContext<HeroForContext>({
    hero:"",
    setHero: ()=> {}
});