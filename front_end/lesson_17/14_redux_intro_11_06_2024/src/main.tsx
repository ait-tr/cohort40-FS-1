import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.tsx";
import "./index.css";
import { Provider } from "react-redux";
import { storeRTK } from "./redux_rtk/storeRTK.ts";

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <Provider store={storeRTK}>
      <App />
    </Provider>
  </React.StrictMode>
);
