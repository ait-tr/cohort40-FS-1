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
    <div className="container my-3">
      <h1>Choose your sandwich:</h1>
      <p>Sandwich: {ingredients}</p>
      <div className="btn-group">
        <button className="btn btn-outline-primary" onClick={handleAddBread}>Add bread</button>
        <button className="btn btn-outline-primary" onClick={handleAddCheese}>Add cheese</button>
        <button className="btn btn-outline-primary" onClick={handleAddSalami}>Add salami</button>
        <button className="btn btn-outline-danger" onClick={handleDelete}>Delete all ingredients</button>
      </div>
    </div>
  );
};

export default Sandwich;
