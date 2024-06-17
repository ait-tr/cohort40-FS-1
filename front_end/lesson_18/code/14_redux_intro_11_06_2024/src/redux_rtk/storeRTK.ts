import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "./counterSlice";
import sandwichReducer from "./sandwichSlice";
import libraryReducer from "./librarySlice";

export const storeRTK = configureStore({
    reducer: {
        counter: counterReducer,
        sandwich: sandwichReducer,
        library: libraryReducer
    }
});

export type RootState = ReturnType<typeof storeRTK.getState>;

export type AppDispatch = typeof storeRTK.dispatch;