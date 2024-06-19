import Hero from "./Hero.tsx";
import DreamTeam from "./DreamTeam.tsx";
import FarGalaxy from "./FarGalaxy.tsx";
import {navItems} from "../utils/constants.tsx";
import {withHeroId} from "../hoc/withHeroId.tsx";

const Home = () => {
    return (
        <div>
            <Hero/>
            <DreamTeam/>
            <FarGalaxy/>
        </div>
    );
};

export default withHeroId(navItems[0].route)(Home);