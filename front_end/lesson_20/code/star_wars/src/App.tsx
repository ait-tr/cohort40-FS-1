import {useState} from 'react';
import "./App.css";
import Header from "./components/Header.tsx";
import Main from "./components/Main.tsx";
import Footer from "./components/Footer.tsx";
import {UserContext} from "./utils/useContext.tsx";
import {defaultHero} from "./utils/constants.tsx";

const App = () => {
    const [hero,setHero] = useState(defaultHero);
    return (
        <div>
            <UserContext.Provider value={
                {hero,setHero}
            }>
                <Header/>
                <Main/>
            </UserContext.Provider>
            <Footer/>
        </div>
    );
};

export default App;