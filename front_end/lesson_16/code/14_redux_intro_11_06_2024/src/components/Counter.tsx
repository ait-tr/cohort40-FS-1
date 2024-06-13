import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { RootState } from '../redux/store'
import { counterSlice } from '../redux_rtk/counterSlice';

const Counter = () => {
    const counter = useSelector((state: RootState) => state.counter.value);
    const dispatch = useDispatch();

    const handleMinus = () => {
        dispatch(counterSlice.actions.minus(1))
    }

    const handlePlus = () => {
        dispatch({ type: 'counter/plus', payload: 1 })
    }

  return (
    <div>
        <div>Counter: {counter}</div>
        <button onClick={handleMinus}>Minus (Decrement)</button>
        <button onClick={handlePlus}>Plus (Increment)</button>
    </div>
  )
}

export default Counter