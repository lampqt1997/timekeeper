import React, { Component } from "react";
import { Switch, Route } from "react-router-dom";

import Header from "./header";
import Greeting from "../pages/greeting";
import EmployeeList from "../pages/employeeList";
import Department from "../pages/department";
import TimeKeeper from "../pages/timeKeeper";
import Shift from "../pages/shift";
import TimeKeepingManagement from "../pages/timeKeepingManagement";
import HolidayManagement from "../pages/holidayManagement";

class MainPanel extends Component {
    state = {};
    render() {
        return (
            <div class="main-panel">
                <Header />
                <Switch>
                    <Route path="/" exact component={Greeting} />
                    <Route path="/employee" component={EmployeeList} />
                    <Route path="/department" component={Department} />
                    <Route path="/timekeeper" component={TimeKeeper} />
                    <Route path="/shift" component={Shift} />
                    <Route
                        path="/timekeeping-management"
                        component={TimeKeepingManagement}
                    />
                    <Route path="/holiday" component={HolidayManagement} />
                </Switch>
            </div>
        );
    }
}

export default MainPanel;
