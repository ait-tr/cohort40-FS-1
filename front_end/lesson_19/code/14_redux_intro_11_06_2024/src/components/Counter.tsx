import { useDispatch, useSelector } from "react-redux";

import { fetchUser, minus, plus } from "../redux_rtk/counterSlice";
import { AppDispatch, RootState } from "../redux_rtk/storeRTK";
import { useEffect } from "react";

const Counter = () => {
  const { value, status, user } = useSelector((state: RootState) => state.counter);
  const dispatch: AppDispatch = useDispatch();

  useEffect(() => {
    if (status === 'idle') {
      dispatch(fetchUser());
    }
  }, [status, dispatch])

  const handleMinus = () => {
    dispatch(minus(1));
  };

  const handlePlus = () => {
    dispatch(plus(1));
  };

  return (
    <div className="container my-3">
      <div className="card">
        <div className="card-body">
          <h5 className="card-title">Counter: {value}</h5>
          <button className="btn btn-danger mx-1" onClick={handleMinus}>
            Minus (Decrement)
          </button>
          <button className="btn btn-success mx-1" onClick={handlePlus}>
            Plus (Increment)
          </button>
          { status === 'loading' && <p>Loading Person Info...</p> }
          { status === 'success' && user && <p>{user.name}</p> }
          { status === 'error' && <p>Error with loading person info... Try again later</p> }
        </div>
      </div>
    </div>
  );
};

export default Counter;
