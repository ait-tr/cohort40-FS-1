import { createSlice } from "@reduxjs/toolkit"

const initialState = {
    value: 0
}

export const counterSlice = createSlice({
    name: 'counter',
    initialState,
    reducers: {
        minus(state, action) {
            state.value = state.value - action.payload;
        }
    }
})