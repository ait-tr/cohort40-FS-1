import { FormEvent, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux_rtk/storeRTK";
import Book from "./Book";
import { addBook } from "../redux_rtk/librarySlice";

const Library = () => {
  const [title, setTitle] = useState<string>("");
  const [author, setAuthor] = useState<string>("");
  const [year, setYear] = useState<number>(0);

  const books = useSelector((state: RootState) => state.library.books);
  const dispatch = useDispatch();

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    dispatch(addBook({ title, author, year }));
    setTitle("");
    setAuthor("");
    setYear(0);
  };

  return (
    <div className="container my-3">
      <h2>Add Book</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Title:</label>
          <input
            type="text"
            className="form-control"
            placeholder="Title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Author:</label>
          <input
            type="text"
            className="form-control"
            placeholder="Author"
            value={author}
            onChange={(e) => setAuthor(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Year:</label>
          <input
            type="number"
            className="form-control"
            placeholder="Year"
            value={year}
            onChange={(e) => setYear(+e.target.value)}
          />
        </div>
        <button className="btn btn-primary">Add Book</button>
      </form>

      <h2>Book List:</h2>
      <ul className="list-group">
        {books.map((book) => (
          <Book key={book.isbn} info={book} />
        ))}
      </ul>
    </div>
  );
};

export default Library;
