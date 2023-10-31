import React from 'react';
import { Route,Routes } from 'react-router-dom';
import Home from './pages/home/Home';
import QuestionDetails from './pages/questionDetails/QuestionDetails';
import ErrorPage from './pages/errorPage/ErrorPage';

function App() {
  return (
    <Routes>
      <Route path='/' element={<Home/>}/>
      <Route path='questionDetails' element={<QuestionDetails/>} />
      <Route path='*' element = {<ErrorPage/>} />
    </Routes>
  )
}

export default App;
