import React from "react";
import DashBoard from "./containers/dashBoard";
import { Switch, Route, Redirect } from "react-router-dom";
import Login from "./containers/login";
import cookieUlti from "./service/cookieUlti";
import PrivateRoute from "./containers/privateRoute";

function App() {

    return (
        <Switch>
            <PrivateRoute authed={cookieUlti.getCookie("loginUser")!==null} path="/" component={DashBoard}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path='/404' component={<h2>404 không tìm thấy</h2>} />
            <Redirect to='/404'/>
        </Switch>
    );
}


export default App;
