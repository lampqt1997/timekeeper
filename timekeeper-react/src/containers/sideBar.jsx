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
                        <li>
                            <a class="nav-link" href="./quanlyca.html">
                                <i class="nc-icon nc-circle-09"></i>
                                <p>Ca làm việc</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./quanlyngaynghi.html">
                                <i class="nc-icon nc-notes"></i>
                                <p>Ngày nghỉ</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./typography.html">
                                <i class="nc-icon nc-paper-2"></i>
                                <p>Nhân viên</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./icons.html">
                                <i class="nc-icon nc-atom"></i>
                                <p>Kết quả chấm công</p>
                            </a>
                        </li>
                        {/* <li>
                            <a class="nav-link" href="./maps.html">
                                <i class="nc-icon nc-pin-3"></i>
                                <p>Maps</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./notifications.html">
                                <i class="nc-icon nc-bell-55"></i>
                                <p>Notifications</p>
                            </a>
                        </li>  */}
                    </ul>
                </div>
            </div>
        );
    }
}

export default SideBar;