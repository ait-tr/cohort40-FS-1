import React from 'react'
import { NavLink, Outlet } from 'react-router-dom'

const Layout = () => {
  return (
    <div>
        <button><NavLink to='/'>Counter</NavLink></button>
        <button><NavLink to='/sandwich'>Sandwich</NavLink></button>
        <button><NavLink to='/library'>Library</NavLink></button>
        <Outlet />
    </div>
  )
}

export default Layout