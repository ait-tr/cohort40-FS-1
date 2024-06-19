import styles from '../css/farGalaxy.module.css';
import {navItems} from "../utils/constants.tsx";
import {withHeroId} from "../hoc/withHeroId.tsx";

const StarWars = () => {
    const starWarsInfo = sessionStorage.getItem('opening_crawl');
    return (
        <div className={styles.farGalaxy}>
            {starWarsInfo}
        </div>
    );
};

export default withHeroId(navItems[2].route)(StarWars);