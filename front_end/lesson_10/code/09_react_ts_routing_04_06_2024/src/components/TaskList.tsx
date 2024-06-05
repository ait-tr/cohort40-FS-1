import { useEffect, useState } from "react";
import Task from "./Task";

interface ITaskJson {
  userId: number;
  id: number;
  title: string;
  completed: boolean;
}

const TaskList = () => {
  const [tasks, setTasks] = useState<string[]>([]);
  const [newTask, setNewTask] = useState<string>("");

  useEffect(
    () => {
      // 1. Вариант с async / await
      const fetchTasks = async () => {
        try {
          const response = await fetch(
            "https://jsonplaceholder.typicode.com/todos"
          );
          const data = await response.json();
          setTasks(data.slice(0, 10).map((e: ITaskJson) => e.title));
        } catch (error) {
          console.log(error);
        }
      };

      // 2. Вариант с Promise
      // fetch('https://jsonplaceholder.typicode.com/todos')
      //         .then(response => response.json())
      //         .then(response => response.map(item => item.title))
      //         .then(response => setTasks(response.slice(0,10)))
      //         .catch(reject => console.log(reject));

      fetchTasks();

      return () => console.log("Компонент размонтирован");
    },
    [
      /* здесь можно передать те значения, при изменении которых должен перезапуститься эффект (2. Обновление (updating)) */
    ]
  );

  /*
        Этапы жизненного цикла компонентов:
    1. Монтирование (mounting) - отрисовка компонента
    2. Обновление (updating) - обновление контента компонента
    3. Размонтирование компонента (unmounting) - удаление компонента
  */

  const deleteTask = (i: number) => {
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

export default TaskList;
