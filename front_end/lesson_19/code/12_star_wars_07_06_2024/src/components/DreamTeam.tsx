import React from "react";
import { friends } from "../utils/constants";
import Friend from "./Friend";

const DreamTeam = () => {
  return (
    <section className="right">
      <h2>Dream Team</h2>
      { friends.map((e, i) => <Friend key={e} photo={e} num={i + 1} />) }
    </section>
  );
};

export default DreamTeam;
