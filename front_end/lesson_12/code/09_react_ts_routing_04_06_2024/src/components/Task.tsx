import { useRef, useState, FC } from "react";

interface ITaskProps {
  title: string;
  del: () => void;
}

const Task: FC<ITaskProps> = ({ title, del }) => {
  // const isEdit = false;
  const [isEdit, setIsEdit] = useState<boolean>(false); // [isEdit, setIsEdit] Array(2)
  // React.useState() - хук (инструмент или метод), который принимает дефолтное значение локального состояния
  // возвращает кортеж (массив с заранее известными элементами и его длиной(2))
  // 1. локальное состояние (переменная) и 2. метод, с помощью которого будет изменяться значение локального состояния

  // isEdit = true;      ОШИБКА! Значение локального состояния изменилось, но React не следит за подобными изменениями
  // setIsEdit(true)     Корректный способ изменения значения локального состояния

  const [updatedTask, setUpdatedTask] = useState<string>(title);

  // 1. Получение абстрактной ссылки, которую впоследствии можно повесить на любой из элементов
  const textId = useRef<HTMLTextAreaElement>(null);

  const handleClickSave = () => {
    // ! - игнорирует проверку на null or undefined
    // ? - делает проверку на null or undefined и в случае, если проверка дала положительный
    // рез-тат возвращает undefined
    setUpdatedTask(textId.current!.value);
    setIsEdit(false);
  };

  return (
    <div className="card mb-3 shadow-sm">
      <div className="card-body">
        {isEdit ? (
          <>
            <textarea
              ref={textId}
              defaultValue={updatedTask}
              className="form-control mb-2"
            ></textarea>
            <div className="d-flex justify-content-center">
              <button
                className="btn btn-success me-2"
                onClick={handleClickSave}
              >
                Save
              </button>
              <button
                className="btn btn-secondary"
                onClick={() => setIsEdit(false)}
              >
                Cancel
              </button>
            </div>
          </>
        ) : (
          <>
            <h5 className="card-title">{updatedTask}</h5>
            <div className="d-flex justify-content-center">
              <button
                className="btn btn-warning me-2"
                onClick={() => setIsEdit(true)}
              >
                Edit
              </button>
              <button className="btn btn-danger" onClick={del}>
                Delete
              </button>
            </div>
          </>
        )}
      </div>
    </div>
  );
};

export default Task;
