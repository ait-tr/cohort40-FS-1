const root = ReactDOM.createRoot(document.getElementById("root"));

const Task = () => {
    // const isEdit = false;
    const [isEdit, setIsEdit] = React.useState(false); // [isEdit, setIsEdit] Array(2)
    // React.useState() - хук (инструмент или метод), который принимает дефолтное значение локального состояния 
    // возвращает кортеж (массив с заранее известными элементами и его длиной(2))
    // 1. локальное состояние (переменная) и 2. метод, с помощью которого будет изменяться значение локального состояния

    // isEdit = true;      ОШИБКА! Значение локального состояния изменилось, но React не следит за подобными изменениями
    // setIsEdit(true)     Корректный способ изменения значения локального состояния

    if (isEdit) {
        return (
            <>
                <textarea defaultValue=''></textarea>
                <button onClick={() => setIsEdit(false)}>Save</button>
            </>
        )
    } else {
        return (
            <>
                <p>Name</p>
                <button onClick={() => setIsEdit(true)}>Edit</button>
                <button>Delete</button>
            </>
        )
    }
}

root.render(
    <Task />
)