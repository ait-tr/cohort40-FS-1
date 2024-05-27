const root = ReactDOM.createRoot(document.getElementById("root"));

// 2. Принимаем props
const Student = ({ name, age }) => {
    // console.log(name, age);
    // const { name, age } = props;
    return (
        <>
            {/* 3. Использование props */}
            <h1>Name: {name}</h1>
            <h2>Age: {age}</h2>
        </>
    )
}

root.render(
    <>
        {/*1. Передача props  */}
        <Student name='Peter' age={25 + 5} />
        <Student name='Mary' age={25 - 6} />
        <Student name='Boris' age={25 + 3} />
        <Student name='Katy' age={25 + 4} />
    </>
)