import React, { FC, useContext } from "react";
import { IPageContext, PageContext } from "../App";
import { navItems } from "../utils/constants";
import Home from "./Home";
import AboutMe from "./AboutMe";
import StarWars from "./StarWars";
import Contact from "./Contact";

const Main: FC = () => {
  const { page } = useContext(PageContext) as IPageContext;

  switch (page) {
    case navItems[0]:
      return <Home />;
    case navItems[1]:
      return <AboutMe />;
    case navItems[2]:
      return <StarWars />;
    case navItems[3]:
      return <Contact />;
    default:
      break;
  }
};

export default Main;
