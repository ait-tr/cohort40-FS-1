import { configureStore } from "@reduxjs/toolkit";
import { counterSlice } from "./counterSlice";

export const storeRTK = configureStore({
    reducer: {
        counter: counterSlice.reducer
    }
});

export type RootState = ReturnType<typeof storeRTK.getState>;