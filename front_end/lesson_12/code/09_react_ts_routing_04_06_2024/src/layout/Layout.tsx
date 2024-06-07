import { Outlet } from 'react-router-dom'
import Navigation from './Navigation'

const Layout = () => {
  return (
    <div className="container">
      <Navigation />
      <main className="mt-4">
        <Outlet />
      </main>
    </div>
  )
}

export default Layout