
import './App.css';
import {Create} from "./Component/Create-student";
import React from "react";
import {ToastContainer} from "react-toastify";

function App() {
  return (
      <>
        <Create/>
        <ToastContainer/>
      </>
  );
}

export default App;
