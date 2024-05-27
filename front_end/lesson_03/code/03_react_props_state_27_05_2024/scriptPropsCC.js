const root = ReactDOM.createRoot(document.getElementById("root"));

class Student extends React.Component {
    render() {
        // 2. Использование props
        // const { name, age } = this.props;
        return (
            <>
                <h1>Name: {this.props.name}</h1>
                <h2>Age: {this.props.age}</h2>
            </>
        )
    }
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