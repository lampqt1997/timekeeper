import React, { Component } from 'react';

class SideBar extends Component {
    state = {};
    render() {
        return (
            <div
                class="sidebar"
                data-image="../assets/img/sidebar-5.jpg"
                data-color="blue"
            >
                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="#" class="simple-text">
                            HR Website
                        </a>
                    </div>
                    <ul class="nav">
                        <li class="nav-item ">
                            <a class="nav-link" href="quanlychamcong.html">
                                <i class="nc-icon nc-chart-pie-35"></i>
                                <p>Chấm công</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        );
    }
}

export default SideBar;