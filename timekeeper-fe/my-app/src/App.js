import React from 'react';
import logo from './logo.svg';
import Main from './Main'
import NotFound from "./pages/404"
import {BrowserRouter as Router, Route, Switch, Link, Redirect,withRouter} from "react-router-dom";
import Login from "./pages/login"
import { ProtectedRoute } from './protected.route';


function App(){  
    return (
        <Router>
        <Switch>
        <Route exact path="/Login" component={Login}/>
        <ProtectedRoute exact path="/" component={Main}/>
        <Route exact path="/404" component={NotFound}/>
        <Redirect to="/404"/>
        </Switch>
        </Router>

    ); 
}
export default App;