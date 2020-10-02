import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

const newDate = new Date().toLocaleDateString();
const newTime = new Date().toLocaleTimeString();

ReactDOM.render(<App/>,
  document.getElementById('root')
);
