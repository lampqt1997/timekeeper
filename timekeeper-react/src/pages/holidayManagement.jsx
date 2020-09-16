import React, { Component } from "react";
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";

class HolidayManagement extends Component {
    state = {};

    render() {
        return (
            <div class="content bg-white">
                <div class="container-fluid">
                    <FullCalendar
                        plugins={[dayGridPlugin]}
                        initialView="dayGridMonth"
                    />
                </div>
            </div>
        );
    }
}

export default HolidayManagement;
