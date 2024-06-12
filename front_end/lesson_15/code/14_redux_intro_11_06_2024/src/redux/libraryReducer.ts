import { uid } from "uid";
import { Book, libraryAction } from "./libraryAction";

interface ILibraryState {
    books: Book[]
}

const initialState = {
    books: [
        { isbn: '1', title: 'Harry Potter', author: 'J.K. Rowling', year: 1997 }
    ]
};

export default function libraryReducer(state: ILibraryState = initialState, action: libraryAction): ILibraryState {
    switch (action.type) {
        case "library/add":
            return { ...state, books: [ ...state.books, { isbn: uid(),...action.payload }] };
        default:
            return state;
    }
}