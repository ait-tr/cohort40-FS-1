import NavItem from './NavItem'
import { navItems } from '../utils/constants'

const Navigation = () => {
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