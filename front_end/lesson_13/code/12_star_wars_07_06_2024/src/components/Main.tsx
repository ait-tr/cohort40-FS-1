import React, { FC } from "react";
import Hero from "./Hero";
import DreamTeam from "./DreamTeam";
import FarGalaxy from "./FarGalaxy";

const Main: FC<{ page: string }> = () => {
  return (
    <main>
      <Hero />
      <DreamTeam />
      <FarGalaxy />
    </main>
  );
};

export default Main;
