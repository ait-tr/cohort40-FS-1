import { FC } from 'react'
import Navigation from './Navigation'

const Header: FC<{ setPage: (newValue: string) => void }> = ({ setPage }) => {
  return (
    <header>
      <Navigation setPage={setPage} />
      <h1>Luke Skywalker</h1>
    </header>
  )
}

export default Header