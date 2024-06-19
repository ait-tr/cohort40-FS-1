import {useEffect, useState} from 'react';
import {base_url, navItems, period_month} from "../utils/constants.tsx";
import "../css/contact.css";
import {withHeroId} from "../hoc/withHeroId.tsx";

const Contact = () => {
    const [planets, setPlanets] = useState(['wait...']);

    const fillPlanets = async function (url:string) {
        const response = await fetch(url);
        const json: {name:string}[] = await response.json();
        const planets = json.map(item => item.name);
        setPlanets(planets);
        const info = {
            payload: planets,
            time: Date.now()
        }
        // 2. Пример работы с localStorage и объектом JSON
        // 2.1. Добавляем новую пару ключ - значение в localStorage
        // 2.2. С помощью JSON.stringify() переводим объект info в формат строки
        localStorage.setItem('planets', JSON.stringify(info));
    }

    useEffect(() => {
        const planetsInfo = JSON.parse(localStorage.getItem("planets")!);
        if (planetsInfo && ((Date.now() - planetsInfo.time) < period_month)) {
            setPlanets(
                planetsInfo.payload
            )
        } else {
            fillPlanets(`${base_url}/v1/planets`);
        }
    },[]);

    return (
        <div>
            <form onSubmit={(e) => {
                e.preventDefault();
            }}>
                <label>First Name
                    <input type="text" name="firstname" placeholder="Your name.."/>
                </label>
                <label>Planet
                    <select name="planet">{
                        planets.map((item, index) => <option value={item} key={index}>{item}</option>)
                    }
                    </select>
                </label>
                <label>Subject
                    <textarea name="subject" placeholder="Write something.."/>
                </label>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    )

}

export default withHeroId(navItems[3].route)(Contact);