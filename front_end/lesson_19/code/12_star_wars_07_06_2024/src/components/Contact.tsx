import axios from 'axios'
import React, { useEffect, useState } from 'react'

interface IPlanet {
  name: string
}

const Contact = () => {

  const [planets, setPlanets] = useState<string[]>([]);

  useEffect(() => {
    const fetchPlanets = async () => {
      try {
        // const response = await fetch('https://sw-info-api.herokuapp.com/v1/planets');
        // const data = await response.json();
        // return data
        const data = (await axios.get<IPlanet[]>('https://sw-info-api.herokuapp.com/v1/planets')).data;
        setPlanets(data.map(e => e.name));
      } catch (error) {
        console.log(error);
      }
    }

    fetchPlanets();
  }, [])

  return (
    <form style={{ display: 'flex', flexDirection: 'column' }}>
      <label>FirstName:
        <input type="text" placeholder='FirstName...'/>
      </label>
      <label>LastName:
        <input type="text" placeholder='LastName...'/>
      </label>
      <label>Planets:
        <select required>
          <option value="">Choose your planet:</option>
          { planets.map(planetName => (
            <option key={planetName} value={planetName}>{planetName}</option>
          )) }
        </select>
      </label>
      <label>Comment:
        <textarea cols={30} rows={10}></textarea>
      </label>
      <label>Gender:
        <label>Male <input type="radio" value='male' name='gender' /></label>
        <label>Female <input type="radio" value='female' name='gender' /></label>
        <label>Other <input type="radio" value='other' name='gender' /></label>
      </label>
      <label>Confirm:
        <input type='checkbox' />
        I agree...
      </label>

      <button type='submit'>Submit</button>
    </form>
  )
}

export default Contact