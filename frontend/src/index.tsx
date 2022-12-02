import React from "react"; 
import  ReactDOM  from "react-dom";
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/js/src/modal'
import './assets/css/styles.css';
import App from './App';
import store from "service/store";
import { Provider } from "react-redux";


ReactDOM.render(
<React.StrictMode>
<Provider store={store}>
  <App />
  </Provider>
</React.StrictMode>, document.getElementById('root')
);

