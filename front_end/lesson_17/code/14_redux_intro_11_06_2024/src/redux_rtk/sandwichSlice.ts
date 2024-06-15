import { PayloadAction, createSlice } from "@reduxjs/toolkit"

type Ingredient = 'bread' | 'cheese' | 'salami';

const initialState = {
    ingredients: ''
}

export const sandwichSlice = createSlice({
    name: 'sandwich',
    initialState,
    reducers: {
        addIngredient(state, action: PayloadAction<Ingredient>) {
            state.ingredients = `${state.ingredients} ${action.payload}`;
        },
        clear(state) {
            state.ingredients = '';
        }
    }
})

export const { addIngredient, clear } = sandwichSlice.actions;

export default sandwichSlice.reducer;