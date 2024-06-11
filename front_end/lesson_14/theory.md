**Redux** 

Основная идея Redux заключается в том, чтобы обеспечить предсказуемость и централизованное управление состоянием приложения

**1. Установка Redux и React-Redux:**

***Redux*** и ***React-Redux*** — это две разные библиотеки. Redux предоставляет управление состоянием, а React-Redux связывает его с React-компонентами. Установите их с помощью npm:

``` sh
  npm i redux react-redux
```

**2. Настройка хранилища (store)**

Создайте файл для конфигурации хранилища, например, src/store.ts:

``` ts
import { combineReducers, legacy_createStore } from "redux";
import counterReducer from "./counterReducer";

const store = legacy_createStore(combineReducers({
    counter: counterReducer
}))

export default store;

export type RootState = ReturnType<typeof store.getState>;
```

**3. Создание reducer (вместе с типизацией Action)**

Создайте reducer с типизацией, например, src/reducers/index.ts

``` ts
const initialState = {
  count: 0
};

type State = typeof initialState;
type Action = { type: 'INCREMENT' } | { type: 'DECREMENT' };

function rootReducer(state: State = initialState, action: Action): State {
  switch (action.type) {
    case 'INCREMENT':
      return {
        ...state,
        count: state.count + 1
      };
    case 'DECREMENT':
      return {
        ...state,
        count: state.count - 1
      };
    default:
      return state;
  }
}

export default rootReducer;
```

**4. Подключение хранилища к приложению**

Обновите src/main.tsx, чтобы подключить хранилище к вашему приложению:

``` tsx
import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.tsx";
import "./index.css";
import { Provider } from "react-redux";
import store from "./redux/store.ts";

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <Provider store={store}>
      <App />
    </Provider>
  </React.StrictMode>
);
```

**5. Использование состояния и действий в компонентах**

Создайте компонент с типизацией, например, src/Counter.tsx:

``` tsx
import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { RootState } from '../redux/store'

const Counter = () => {
    const counter = useSelector((state: RootState) => state.counter.value);
    const dispatch = useDispatch();

    const handleMinus = () => {
        dispatch({ type: 'counter/minus', payload: 1 })
    }

    const handlePlus = () => {
        dispatch({ type: 'counter/plus', payload: 1 })
    }

  return (
    <div>
        <div>Counter: {counter}</div>
        <button onClick={handleMinus}>Minus (Decrement)</button>
        <button onClick={handlePlus}>Plus (Increment)</button>
    </div>
  )
}

export default Counter
```