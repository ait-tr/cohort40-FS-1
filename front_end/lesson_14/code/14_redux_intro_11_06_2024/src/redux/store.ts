import { combineReducers, legacy_createStore } from "redux";
import counterReducer from "./counterReducer";

const store = legacy_createStore(combineReducers({
    counter: counterReducer
}))

export default store;

export type RootState = ReturnType<typeof store.getState>;