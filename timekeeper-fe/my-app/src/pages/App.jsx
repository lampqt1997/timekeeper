import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch, Link, Redirect} from "react-router-dom";
import MainPage from "./pages/index"


import Sidebar from "./pages/sidebar"
import Nav from "./pages/nav"
import 'bootstrap/dist/js/bootstrap.bundle.min'
import'bootstrap/dist/css/bootstrap.css'
import './pages/assets/css/light-bootstrap-dashboard.css'

class App extends Component {
  state = {  }
  render() { 
    return ( <div>
      <Sidebar/>
        <div class="main-panel">
        <Nav/>
        <div class="content container">

        </div>

        </div>

    </div>
 );
  }
}
 
export default App();
