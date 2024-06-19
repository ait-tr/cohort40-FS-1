import {navItems} from "../utils/constants.tsx";
import AboutMe from "./AboutMe.tsx";
import StarWars from "./StarWars.tsx";
import Contact from "./Contact.tsx";
import Home from "./Home.tsx";
import {Route, Routes} from "react-router-dom";
import ErrorPage from "./ErrorPage.tsx";

const Main = () => {
    return (
        // 3. Динамическая маршрутизация
        <Routes>
            {['/',`${navItems[0].route}/:heroId`].map(p=>
                <Route key={p} path={p} element={<Home/>}></Route>
            )}
            {[navItems[1].route, `${navItems[1].route}/:heroId`].map(p =>
                <Route key={p} path={p} element={<AboutMe/>}></Route>
            )}
            <Route path={`${navItems[2].route}/:heroId`} element={<StarWars/>}></Route>
            <Route path={`${navItems[3].route}/:heroId`} element={<Contact/>}></Route>
            <Route path={'*'} element={<ErrorPage/>}/>
        </Routes>
    )
};

export default Main;