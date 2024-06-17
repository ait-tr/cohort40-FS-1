import { Route, Routes } from "react-router-dom";
import "./App.css";
import Counter from "./components/Counter";
import Library from "./components/Library";
import Sandwich from "./components/Sandwich";
import Layout from "./components/Layout";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Counter />}/>
        <Route path="/sandwich" element={<Sandwich />}/>
        <Route path="/library" element={<Library />}/>   
      </Route>
    </Routes>
  );
}

export default App;
