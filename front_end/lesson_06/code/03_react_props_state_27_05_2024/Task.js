const root = ReactDOM.createRoot(document.getElementById("root"));

const Task = ({ title, del }) => {
  // const isEdit = false;
  const [isEdit, setIsEdit] = React.useState(false); // [isEdit, setIsEdit] Array(2)
  // React.useState() - хук (инструмент или метод), который принимает дефолтное значение локального состояния
  // возвращает кортеж (массив с заранее известными элементами и его длиной(2))
  // 1. локальное состояние (переменная) и 2. метод, с помощью которого будет изменяться значение локального состояния

  // isEdit = true;      ОШИБКА! Значение локального состояния изменилось, но React не следит за подобными изменениями
  // setIsEdit(true)     Корректный способ изменения значения локального состояния

  const [updatedTask, setUpdatedTask] = React.useState(title);

  // 1. Получение абстрактной ссылки, которую впоследствии можно повесить на любой из элементов
  const textId = React.useRef();

  const handleClickSave = () => {
    setUpdatedTask(textId.current.value);
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
      <div className="border border-primary-subtle w-50" style={{ margin: '0 auto'}}>
        <p className='mt-2'>{updatedTask}</p>
        <div className='d-flex justify-content-center mb-5'>
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

const TaskList = () => {
  const [tasks, setTasks] = React.useState(["Task 1", "Task 2", "Task 3"]);
  const [newTask, setNewTask] = React.useState("");

  const deleteTask = (i) => {
    // CRUD - Create Read Update Delete
    // 1. Глубокая копия массива
    const tasksCopy = [...tasks];

    // 2. Поверхностная копия массива
    // const tasksCopy2 = tasks;
    // Удаление i-ого элемента массива в копии
    tasksCopy.splice(i, 1);
    // Обновлённую копию передали в качестве нового значения локального состояния
    setTasks(tasksCopy);
  };

  const addTask = () => {
    if (newTask.trim()) {
      const tasksCopy = [...tasks]; // 1. Создание копии
      tasksCopy.push(newTask); // 2. Изменение копии
      setTasks(tasksCopy); // 3. Обновление значения оригинала на копию
    }
    setNewTask(""); // 4. Удаляем сохранённую информацию о новой задаче после её добавления в список и тем самым очищаем input
  };

  return (
    <>
      <h1 className="text-center">Todo List App</h1>
      <div style={{ margin: "0 auto" }} className="w-50 d-flex">
        <input
          className="form-control"
          value={newTask}
          onChange={(e) => setNewTask(e.target.value)}
          placeholder="Введите новую задачу..."
        />
        <button
          style={{ width: "160px" }}
          className="btn btn-primary"
          onClick={addTask}
        >
          Add Task
        </button>
      </div>
      <div className="d-flex flex-column text-center">
        {tasks.map((task, i) => (
          <Task
            // Свойство key является обязательным (служебный инструмент для библиотеки React)
            // У нас нет доступа до значения, переданного с помощью props key
            key={Math.random()}
            // index={i}
            title={task}
            del={() => deleteTask(i)}
          />
        ))}
      </div>
    </>
  );
};

root.render(<TaskList />);
