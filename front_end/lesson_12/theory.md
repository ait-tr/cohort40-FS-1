**Основные особенности, связанные с типизацией React-приложения** 

**1. Single Page Application (SPA)**

Single Page Application (SPA) - это веб-приложение или веб-сайт, который взаимодействует с пользователем, переписывая текущее содержимое страницы вместо загрузки целых новых страниц с сервера. Это позволяет более быстрый и плавный пользовательский опыт, похожий на настольное приложение.

**2. Routing**

Routing - это метод, с помощью которого мы определяем, как различные URL-адреса в приложении сопоставляются с компонентами. В SPA маршрутизация осуществляется на стороне клиента, то есть JavaScript библиотекой.

**3. ***react-router-dom*** library**

***react-router-dom*** - это библиотека для маршрутизации в React-приложениях. Она позволяет создавать маршруты, переключаться между ними, а также определять компоненты, которые должны отображаться для каждого маршрута.

**4. Создание компонента Layout**

Компонент Layout используется для определения общей структуры страницы, такой как хедер, футер и основные элементы навигации.

```jsx
import React from 'react';
import { Outlet } from 'react-router-dom';

const Layout = () => {
  return (
    <div>
      <header>
        <h1>My Application</h1>
      </header>
      <nav>
        {/* Здесь будет компонент для навигации */}
      </nav>
      <main>
        <Outlet />
      </main>
      <footer>
        <p>Footer Content</p>
      </footer>
    </div>
  );
};

export default Layout;
```

**5. Создание компонента для навигации**

Компонент Navigation используется для создания меню или набора ссылок для перемещения между различными маршрутами.

```jsx
import React from 'react';
import { NavLink } from 'react-router-dom';

const Navigation = () => {
  return (
    <nav>
      <ul>
        <li><NavLink to="/">Home</NavLink></li>
        <li><NavLink to="/about">About</NavLink></li>
        <li><NavLink to="/contact">Contact</NavLink></li>
      </ul>
    </nav>
  );
};

export default Navigation;
```

**6. Link**

Компонент Link используется для создания ссылок, которые ведут на другие маршруты в приложении без перезагрузки страницы.

```jsx
import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <div>
      <h1>Home Page</h1>
      <Link to="/about">Go to About Page</Link>
    </div>
  );
};

export default Home;
```

**7. NavLink**

Компонент NavLink похож на Link, но предоставляет дополнительные возможности для стилизации активных ссылок.

```jsx
import React from 'react';
import { NavLink } from 'react-router-dom';

const Navigation = () => {
  return (
    <nav>
      <ul>
        <li><NavLink to="/" activeClassName="active">Home</NavLink></li>
        <li><NavLink to="/about" activeClassName="active">About</NavLink></li>
        <li><NavLink to="/contact" activeClassName="active">Contact</NavLink></li>
      </ul>
    </nav>
  );
};

export default Navigation;
```

**8. Route, Routes**

Route и Routes используются для определения маршрутов и компонентов, которые должны отображаться при переходе по этим маршрутам.

```jsx
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Layout from './Layout';
import Home from './Home';
import About from './About';
import Contact from './Contact';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="about" element={<About />} />
          <Route path="contact" element={<Contact />} />
        </Route>
      </Routes>
    </Router>
  );
};

export default App;
```