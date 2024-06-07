import { FC } from 'react'

const NavItem: FC<{ title: string }> = ({ title }) => {
  return (
    <li className="commonButton">{title}</li>
  )
}

export default NavItem