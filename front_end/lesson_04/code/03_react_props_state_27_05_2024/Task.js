const root = ReactDOM.createRoot(document.getElementById("root"));

const Task = () => {
    // const isEdit = false;
    const [isEdit, setIsEdit] = React.useState(false); // [isEdit, setIsEdit] Array(2)
    // React.useState() - хук (инструмент или метод), который принимает дефолтное значение локального состояния 
    // возвращает кортеж (массив с заранее известными элементами и его длиной(2))
    // 1. локальное состояние (переменная) и 2. метод, с помощью которого будет изменяться значение локального состояния

    // isEdit = true;      ОШИБКА! Значение локального состояния изменилось, но React не следит за подобными изменениями
    // setIsEdit(true)     Корректный способ изменения значения локального состояния

    const [updatedTask, setUpdatedTask] = React.useState('Task 1');

    // 1. Получение абстрактной ссылки, которую впоследствии можно повесить на любой из элементов
    const textId = React.useRef();

    const handleClickSave = () => {
        setUpdatedTask(textId.current.value);
        setIsEdit(false);
    }

    if (isEdit) {
        return (
            <>
                {/* 2. Соединяем абстрактную ссылку с конкретным элементом, на который данная ссылка будет вести */}
                <textarea ref={textId} defaultValue={updatedTask}></textarea>
                {/* () => setIsEdit(false)     setIsEdit(false)        setIsEdit*/}
                <button onClick={handleClickSave}>Save</button>
            </>
        )
    } else {
        return (
            <>
                <p>{updatedTask}</p>
                <button onClick={() => setIsEdit(true)}>Edit</button>
                <button>Delete</button>
            </>
        )
    }
}

root.render(
    <Task />
)