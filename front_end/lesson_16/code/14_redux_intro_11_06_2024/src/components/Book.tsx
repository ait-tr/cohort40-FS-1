import React, { FC, useState } from "react";
import { Book as BookType } from "../redux/libraryAction";
import { useDispatch } from "react-redux";

const Book: FC<{ info: BookType }> = ({ info }) => {
  const [isEdit, setIsEdit] = useState(false);
  const [title, setTitle] = useState<string>(info.title);
  const [author, setAuthor] = useState<string>(info.author);
  const [year, setYear] = useState<number>(info.year);

  const dispatch = useDispatch();

  const handleSaveBook = () => {
      dispatch({ type: "library/edit", payload: { isbn: info.isbn, title, author, year } })
      setIsEdit(false);
  }

  const handleEditBook = () => {
    setIsEdit(true);
  }

  return isEdit ? (
    <li>
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
        <button onClick={handleSaveBook}>Save Book</button>
    </li>
  ) : (
    <li>
      {info.title} by {info.author} ({info.year})<button onClick={handleEditBook}>Edit Book</button>
      <button
        onClick={() => dispatch({ type: "library/delete", payload: info.isbn })}
      >
        Delete Book
      </button>
    </li>
  );
};

export default Book;
