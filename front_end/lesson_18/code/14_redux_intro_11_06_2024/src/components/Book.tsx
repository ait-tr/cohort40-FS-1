import { FC, useState } from "react";
import { Book as BookType } from "../redux/libraryAction";
import { useDispatch } from "react-redux";
import { deleteBook, editBook } from "../redux_rtk/librarySlice";

const Book: FC<{ info: BookType }> = ({ info }) => {
  const [isEdit, setIsEdit] = useState(false);
  const [title, setTitle] = useState<string>(info.title);
  const [author, setAuthor] = useState<string>(info.author);
  const [year, setYear] = useState<number>(info.year);

  const dispatch = useDispatch();

  const handleSaveBook = () => {
    dispatch(editBook({ isbn: info.isbn, title, author, year }));
    setIsEdit(false);
  };

  const handleEditBook = () => {
    setIsEdit(true);
  };

  return isEdit ? (
    <li className="list-group-item">
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
      <button className="btn btn-primary" onClick={handleSaveBook}>
        Save Book
      </button>
    </li>
  ) : (
    <li className="list-group-item">
      {info.title} by {info.author} ({info.year})
      <button className="btn btn-secondary mx-1" onClick={handleEditBook}>
        Edit Book
      </button>
      <button
        className="btn btn-danger"
        onClick={() => dispatch(deleteBook(info.isbn))}
      >
        Delete Book
      </button>
    </li>
  );
};

export default Book;
