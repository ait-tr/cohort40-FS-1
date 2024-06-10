import NavItem from './NavItem'
import { navItems } from '../utils/constants'
import { FC } from 'react'

const Navigation: FC<{ setPage: (newValue: string) => void }>  = ({ setPage }) => {
  return (
    <nav>
        <ul>
            { navItems.map(title => (
                <NavItem key={title} title={title} setPage={setPage}/>
            )) }
        </ul>
    </nav>
  )
}

export default Navigation