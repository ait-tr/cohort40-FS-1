import { combineReducers, legacy_createStore } from "redux";
import counterReducer from "./counterReducer";
import sandwichReducer from "./sandwichReducer";

const rootReducer = combineReducers({
    counter: counterReducer,
    sandwich: sandwichReducer
})

const store = legacy_createStore(rootReducer);

export default store;

export type RootState = ReturnType<typeof store.getState>;