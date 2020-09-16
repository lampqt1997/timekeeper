import React, { Component } from "react";

import SideBar from "./sideBar";
import MainPanel from "./mainPanel";

import "../styles/assets/css/demo.css";
import "../styles/assets/css/bootstrap.min.css";
import "../styles/assets/css/light-bootstrap-dashboard.css?v=2.0.0";

class DashBoard extends Component {
    state = {};
    render() {
        return (
            <div class="wrapper">
                <SideBar />
                <MainPanel />
            </div>
        );
    }
}

export default DashBoard;
