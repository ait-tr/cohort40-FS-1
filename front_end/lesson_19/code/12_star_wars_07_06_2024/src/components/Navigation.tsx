import NavItem from './NavItem'
import { navItems } from '../utils/constants'
import { FC } from 'react'

const Navigation: FC  = () => {
  return (
    <nav>
        <ul>
            { navItems.map(title => (
                <NavItem key={title} title={title} />
            )) }
        </ul>
    </nav>
  )
}

export default Navigation