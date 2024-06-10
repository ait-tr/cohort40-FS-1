import { FC, useContext } from 'react'
import { PageContext } from '../App'

const NavItem: FC<{ title: string, setPage: (newValue: string) => void }> = ({ title, setPage }) => {
  const change = useContext(PageContext);
  return (
    <li onClick={() => change!(title)} className="commonButton">{title}</li>
  )
}

export default NavItem