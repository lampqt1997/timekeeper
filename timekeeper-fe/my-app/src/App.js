import React from "react";
import logo from "./logo.svg";
import "./App.css";
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Link,
  Redirect,
} from "react-router-dom";
import MainPage from "./pages/Components/index";
import Employees from "./pages/Components/employees";
import NotFound from "./pages/404";

import Sidebar from "./pages/sidebar";
import Nav from "./pages/nav";

import "./pages/assets/css/light-bootstrap-dashboard.css?v=1.4.0";
import "./pages/assets/css/bootstrap.min.css";
import "./pages/assets/css/demo.css";
import route from "./route";

function App() {
  return (
    <div class="wrapper">
      <Sidebar />
      <div class="main-panel">
        <Nav />

        <div class="content bg-white">
          <div class="container-fluid">
            <Switch>
              {route.map((route, idx) => {
                return route.component ? (
                  <Route
                    key={idx}
                    exact={route.exact}
                    path={route.path}
                    name={route.name}
                    component={route.component}
                  />
                ) : (
                  <Redirect to="/" />
                );
              })}
              <Redirect to="/404" />
            </Switch>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
