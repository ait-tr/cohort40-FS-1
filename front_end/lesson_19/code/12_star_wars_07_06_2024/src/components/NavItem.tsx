import { FC, useContext } from 'react'
import { IPageContext, PageContext } from '../App'

const NavItem: FC<{ title: string }> = ({ title }) => {
  // 3. Использование значения, полученного из контекста
  const { setPage } = useContext(PageContext) as IPageContext;
  // const context = useContext(PageContext);
  return (
    <li onClick={() => setPage(title)} className="commonButton">{title}</li>
  )
}

export default NavItem