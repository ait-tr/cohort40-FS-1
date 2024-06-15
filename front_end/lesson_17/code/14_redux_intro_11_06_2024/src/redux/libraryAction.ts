/*
    1. Add book;
    2. Delete book;
    3. Edit Book
*/

export type Book = {
  isbn: string; // (unique)
  title: string;
  year: number;
  author: string;
};

export type libraryAction = 
| { type: "library/add"; payload: Omit<Book, 'isbn'> }
| { type: "library/edit"; payload: Book }
| { type: "library/delete"; payload: string }
