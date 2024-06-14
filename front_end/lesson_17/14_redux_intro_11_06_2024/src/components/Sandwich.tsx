import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux_rtk/storeRTK";
import { addIngredient, clear } from "../redux_rtk/sandwichSlice";

const Sandwich = () => {
  const ingredients = useSelector((state: RootState) => state.sandwich.ingredients);
  const dispatch = useDispatch();

  function handleAddBread() {
    dispatch(addIngredient('bread'))
  }

  function handleAddCheese() {
    dispatch(addIngredient('cheese'))
  }

  function handleAddSalami() {
    dispatch(addIngredient('salami'))
  }

  function handleDelete() {
    dispatch(clear())
  }
  
  return (
    <div>
      <h1>Choose your sandwich: </h1>
      <p>Sandwich: {ingredients}</p>
      <button onClick={handleAddBread}>Add bread</button>
      <button onClick={handleAddCheese}>Add cheese</button>
      <button onClick={handleAddSalami}>Add salami</button>
      <button onClick={handleDelete}>Delete all ingredients</button>
    </div>
  );
};

export default Sandwich;
