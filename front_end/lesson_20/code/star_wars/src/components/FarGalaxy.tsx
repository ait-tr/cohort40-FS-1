import {useEffect, useState} from 'react';
import {base_url} from "../utils/constants.tsx";
import styles from "../css/farGalaxy.module.css"

const FarGalaxy = () => {
    const [text, setText] = useState('Loading...');

    useEffect(() => {
        const opening_crawl = sessionStorage.getItem('opening_crawl')
        if (opening_crawl) {
            setText(opening_crawl);
        } else {
            const episode = Math.floor(1 + Math.random() * 6);
            fetch(`${base_url}/v1/films/${episode}`)
                .then(response => response.json())
                .then(data => {
                    setText(data.opening_crawl);
                    sessionStorage.setItem('opening_crawl', data.opening_crawl);
                })
        }
    }, []);

    return (
        <p className={styles.farGalaxy}>{text}</p>
    );
}

export default FarGalaxy;