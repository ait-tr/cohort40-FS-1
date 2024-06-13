import React, { FormEvent, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/store";
import Book from "./Book";

const Library = () => {
  const [title, setTitle] = useState<string>("");
  const [author, setAuthor] = useState<string>("");
  const [year, setYear] = useState<number>(0);

  const books = useSelector((state: RootState) => state.library.books);
  const dispatch = useDispatch();

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    dispatch({ type: "library/add", payload: { title, author, year } });
    setTitle('');
    setAuthor('');
    setYear(0);
  }

  return (
    <div>
      <h2>Add Book</h2>

      <form onSubmit={handleSubmit}>
        <label>
          Title:
          <input type="text" placeholder="Title" value={title} onChange={e => setTitle(e.target.value)} />
        </label>
        <label>
          Author:
          <input type="text" placeholder="Author" value={author} onChange={e => setAuthor(e.target.value)} />
        </label>
        <label>
          Year:
          <input type="text" placeholder="Year" value={year} onChange={e => setYear(+e.target.value)} />
        </label>
        <button>Add Book</button>
      </form>

      <h2>Book List:</h2>

      <ul>
        {books.map((book) => (
          <Book key={book.isbn} info={book} />
        ))}
      </ul>
    </div>
  );
};

export default Library;
