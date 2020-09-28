import React, { Component } from "react";
import { Switch, Route, Redirect,withRouter } from "react-router-dom";

import Header from "./header";
import Greeting from "../pages/greeting";
import EmployeeList from "../pages/employeeList";
import Department from "../pages/department";
import TimeKeeper from "../pages/timeKeeper";
import Shift from "../pages/shift";
import TimeKeepingManagement from "../pages/timeKeepingManagement";
import HolidayManagement from "../pages/holidayManagement";
import cookieUlti from "../service/cookieUlti";
import PrivateRoute from "./privateRoute";
import Login from "./login";
import { render } from "react-dom";


class MainPanel extends Component{
    render(){
        return (
            <div class="main-panel h-100">
                <Header />
                <Switch>
                    <PrivateRoute authed={cookieUlti.getCookie("loginUser")!==null} path="/" exact component={Greeting} />
                    <PrivateRoute authed={cookieUlti.getCookie("loginUser")!==null} path="/employee" exact component={EmployeeList} />
                    <PrivateRoute authed={cookieUlti.getCookie("loginUser")!==null} path="/department" exact component={Department} />
                    <PrivateRoute authed={cookieUlti.getCookie("loginUser")!==null} path="/timekeeper" exact component={TimeKeeper} />
                    <PrivateRoute authed={cookieUlti.getCookie("loginUser")!==null} path="/shift" exact component={Shift} />
                    <PrivateRoute authed={cookieUlti.getCookie("loginUser")!==null}
                        path="/timekeeping-management"
                        component={TimeKeepingManagement}
                    />
                    <PrivateRoute authed={cookieUlti.getCookie("loginUser")!=null} path="/holiday" component={HolidayManagement} />
                    <Route exact path="/login" component={Login}/>
                    

                </Switch>
            </div>
        );
        
    }

}

export default withRouter(MainPanel);
