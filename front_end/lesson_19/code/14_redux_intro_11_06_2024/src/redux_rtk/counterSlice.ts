import { PayloadAction, createAsyncThunk, createSlice } from "@reduxjs/toolkit"

interface IUser {
    id: number;
    name: string
}

interface ICounterUserState {
    user: IUser | null,
    status: 'idle' | 'loading' | 'success' | 'error',
    value: number
}

export const fetchUser = createAsyncThunk('fetchUser', async () => {
    const response = await fetch('https://jsonplaceholder.typicode.com/users/1');
    const data = await response.json() as IUser;
    return data
})

const initialState: ICounterUserState = {
    value: 0,
    status: 'idle',
    user: null
}

export const counterSlice = createSlice({
    name: 'counter',
    initialState,
    reducers: {
        minus(state, action: PayloadAction<number>) {
            state.value = state.value - action.payload;
        },
        plus(state, action: PayloadAction<number>) {
            state.value = state.value + action.payload;
        }
    },
    extraReducers: (builder) => {
        builder
            .addCase(fetchUser.pending, (state) => {
                state.status = 'loading'
            })
            .addCase(fetchUser.fulfilled, (state, action) => {
                state.status = 'success'
                state.user = action.payload
            })
            .addCase(fetchUser.rejected, (state) => {
                state.status = 'error'
            })
    }
})

export const { minus, plus } = counterSlice.actions;

export default counterSlice.reducer;