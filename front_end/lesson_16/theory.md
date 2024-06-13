**Redux Toolkit**

Redux Toolkit (RTK) — это официальная, рекомендованная библиотека для написания Redux-логики. Она упрощает создание и управление состоянием приложения, устраняя некоторые болевые точки, связанные с настройкой и использованием Redux. RTK включает несколько утилит и функций для упрощения задач, таких как создание экшенов, редюсеров и работы с асинхронными запросами.

**Основные концепции и использование Redux Toolkit**

**1. Настройка и создание store:**

Redux Toolkit предоставляет функцию configureStore, которая позволяет легко настроить store с хорошими стандартными настройками.

```tsx
import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "./counterSlice";
import userReducer from "./userSlice";

const store = configureStore({
  reducer: {
    counter: counterReducer,
    user: userReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;

export default store;
```

**2. Создание Slice для счетчика:**

Создайте файл для конфигурации хранилища, например, src/store.ts:

```ts
import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  value: 0,
};

export const counterSlice = createSlice({
  name: "counter",
  initialState,
  reducers: {
    minus(state, action) {
      state.value = state.value - action.payload;
    },
  },
});
```

**3. Подключение хранилища к приложению**

Обновите src/main.tsx, чтобы подключить хранилище к вашему приложению:

```tsx
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

**4. Использование состояния и действий в компонентах**

Создайте компонент с типизацией, например, src/Counter.tsx:

```tsx
import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/store";
import { counterSlice } from "../redux_rtk/counterSlice";

const Counter = () => {
  const counter = useSelector((state: RootState) => state.counter.value);
  const dispatch = useDispatch();

  const handleMinus = () => {
    dispatch(counterSlice.actions.minus(1));
  };

  return (
    <div>
      <div>Counter: {counter}</div>
      <button onClick={handleMinus}>Minus (Decrement)</button>
      <button onClick={handlePlus}>Plus (Increment)</button>
    </div>
  );
};

export default Counter;

```