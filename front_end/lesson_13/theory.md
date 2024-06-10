**Хук контекста** 

Хук контекста основан на двух основных инструментах: createContext и useContext 

**1. Создание контекста:**

Для начала нужно создать контекст с помощью createContext. Этот метод возвращает объект контекста, содержащий два компонента: Provider и Consumer

``` tsx
  const MyContext = React.createContext(defaultValue);
```

defaultValue — это значение по умолчанию, которое будет использовано, если компонент не обернут в провайдер данного контекста.

**2. Передача контекста:**

Provider используется для обертывания компонента или дерева компонентов, которым нужно предоставить доступ к контексту. Provider принимает prop value, который определяет текущее значение контекста.

``` tsx
const MyProvider = ({ children }) => {
  const [state, setState] = useState(initialState);

  return (
    <MyContext.Provider value={{ state, setState }}>
      {children}
    </MyContext.Provider>
  );
};
```

**3. Потребление контекста:**

Потребление контекста можно осуществить несколькими способами: через компонент **Consumer** или с помощью хука **useContext**

**Вариант с Consumer**

``` tsx
const MyComponent = () => (
  <MyContext.Consumer>
    {({ state, setState }) => (
      <div>{state.someValue}</div>
    )}
  </MyContext.Consumer>
);
```

**Вариант с useContext**

``` tsx
const MyComponent = () => {
  const { state, setState } = useContext(MyContext);

  return <div>{state.someValue}</div>;
};
```