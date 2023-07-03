import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter,Routes,Route } from 'react-router-dom';
import PostComponent from './Component/PostComponent';
import AuthorwiseComponent from './Component/AuthorwiseComponent';
import TitlewiseComponent from './Component/TitlewiseComponent';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<App /> } />
      <Route path="/addpost" element={<PostComponent />} />
      <Route path="/searchbyauthor" element={<AuthorwiseComponent />} />
      <Route path="/searchbytitle" element={<TitlewiseComponent />} />
      <Route path="*" element={"Not Found"}/>
    </Routes>
    </BrowserRouter>
     
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
