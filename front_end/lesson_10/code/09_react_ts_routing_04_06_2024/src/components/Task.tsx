import { useRef, useState, FC } from "react";

interface ITaskProps {
  title: string,
  del: () => void
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

  if (isEdit) {
    return (
      <>
        {/* 2. Соединяем абстрактную ссылку с конкретным элементом, на который данная ссылка будет вести */}
        <textarea ref={textId} defaultValue={updatedTask}></textarea>
        {/* () => setIsEdit(false)     setIsEdit(false)        setIsEdit*/}
        <button className="btn btn-success" onClick={handleClickSave}>
          Save
        </button>
      </>
    );
  } else {
    return (
      <div
        className="border border-primary-subtle w-50"
        style={{ margin: "0 auto" }}
      >
        <p className="mt-2">{updatedTask}</p>
        <div className="d-flex justify-content-center mb-5">
          <button className="btn btn-warning" onClick={() => setIsEdit(true)}>
            Edit
          </button>
          <button className="btn btn-danger" onClick={del}>
            Delete
          </button>
        </div>
      </div>
    );
  }
};

export default Task;