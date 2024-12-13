import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/js/src/modal'
import './assets/css/main.css';
import './assets/css/card.css';
import './assets/css/form.css';
import './assets/css/bar.css';
import './assets/css/dataTable.css';
import './assets/css/page.css';

import App from './App';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);


