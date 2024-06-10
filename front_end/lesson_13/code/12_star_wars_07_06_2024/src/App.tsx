import { createContext, useState } from "react";
import "./App.css";
import Footer from "./components/Footer";
import Header from "./components/Header";
import Main from "./components/Main";
import { navItems } from "./utils/constants";

export const PageContext = createContext<((newValue: string) => void) | null>(null);

function App() {
  const [page, setPage] = useState(navItems[0]);

  console.log(page);

  return (
    <>
      <PageContext.Provider value={setPage}>
        <Header setPage={setPage} />
        <Main page={page} />
      </PageContext.Provider>
      <Footer />
    </>
  );
}

export default App;
