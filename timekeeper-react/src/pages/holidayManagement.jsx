import React, { Component } from "react";
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";

import interactionPlugin from "@fullcalendar/interaction"; // needed for dayClick
import { Modal, Form, Button, Col, Alert, Row, ButtonGroup } from 'react-bootstrap';
import Dialog from 'react-bootstrap-dialog'

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';

import HolidayService from "../service/HolidayService";
import { log } from "util";

class HolidayManagement extends Component {
    state = {
        modalShow: false,
        modalNew: true,
        modalTitle: '',
        modalErr: '',
        dateStr: '',
        txtEvent: '',
        events: [
            // { title: 'event 1', date: '2020-09-03' },
            // { title: 'event 2', date: '2020-09-03' }
        ]
    };
    componentDidMount() {
        HolidayService.list().then((res) => {
            this.setState({ events: res.data });
        });
    }
    handleDateClick = (arg) => { // bind with an arrow function
        if (this.state.events.length == 0) {
            this.setState({ modalNew: true })
            this.setState({ modalTitle: 'Thêm mới sự kiện' })
            this.setState({ modalShow: true })
            this.setState({ dateStr: arg.dateStr })
            this.setState({ txtEvent: '' })
        } else {
            let eventsMap = this.state.events.map((e) => {
                return e
            });
            let isTexted = eventsMap.find(e => e.date == arg.dateStr);
            if (isTexted) {
                this.setState({ modalNew: false })
                this.setState({ modalTitle: 'Cập nhật sự kiện' })
                this.setState({ modalShow: true })
                this.setState({ txtEvent: isTexted.title })
                this.setState({ dateStr: arg.dateStr })

            } else {
                this.setState({ modalNew: true })
                this.setState({ modalTitle: 'Thêm mới sự kiện' })
                this.setState({ modalShow: true })
                this.setState({ dateStr: arg.dateStr })
                this.setState({ txtEvent: '' })
            }
        }
        // 


    }

    handleChange = (event) => {
        this.setState({ txtEvent: event.target.value });
    }
    closeModal = () => {
        this.setState({ modalShow: false })
    }
    deleteEvent = () => {
        
        let eMap = this.state.events.map((e) => {
            return e
        });
        let eIndex = eMap.findIndex(e => e.date == this.state.dateStr);
        eMap.splice(eIndex, 1);
        this.setState({ events: eMap })
        this.closeModal();
        HolidayService.delete(this.state.dateStr).then((res) => {
            console.log(res);
        });

    }
    saveEvent = () => {
        if (this.state.txtEvent == '') {
            this.setState({ modalErr: 'Không được để trống' })
        } else {
            this.setState({ modalErr: '' })
            if (this.state.modalNew) {
                if (this.state.events.length == 0) {
                    let eTempt = [];
                    eTempt.push({title: this.state.txtEvent, date: this.state.dateStr })
                    this.setState({ events: eTempt})
                    this.closeModal();
                    HolidayService.put(`{"title": "${this.state.txtEvent}", "date": "${this.state.dateStr}" }`).then((res) => {
                        console.log(res);
                    });
                } else {
                    let eMap = this.state.events.map((e) => {
                        return e
                    })
                    eMap.push({ title: this.state.txtEvent, date: this.state.dateStr });
                    this.setState({ events: eMap })
                    //create ar
                    this.closeModal();
                    HolidayService.put(`{"title": "${this.state.txtEvent}", "date": "${this.state.dateStr}" }`).then((res) => {
                        console.log(res);
                    });
                }

            } else {

                let eMap = this.state.events.map((e) => {
                    return e
                });
                let eIndex = eMap.findIndex(e => e.date == this.state.dateStr);
                eMap[eIndex].title = this.state.txtEvent;
                this.setState({ events: eMap });
                this.closeModal();
                HolidayService.update(`{"title": "${this.state.txtEvent}", "date": "${this.state.dateStr}" }`).then((res) => {
                    console.log(res);
                });
            }

        }



    }
    render() {
        return (
            <div className="content bg-white">
                <div className="container-fluid">
                    <FullCalendar
                        plugins={[dayGridPlugin, interactionPlugin]}
                        initialView="dayGridMonth"
                        dateClick={this.handleDateClick}
                        events={this.state.events}
                    />

                </div>

                <div>
                    <Modal show={this.state.modalShow}
                        onHide={this.closeModal}
                        keyboard={false}
                        animation={false}>

                        <Modal.Header closeButton>
                            <Modal.Title>{this.state.modalTitle}</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <Form>
                                <Form.Group >
                                    <Form.Label  >Tên sự kiện</Form.Label>
                                    <Form.Control
                                        type="text"
                                        name="txtEvent"
                                        value={this.state.txtEvent}
                                        onChange={this.handleChange}

                                    />
                                    <Form.Label className="text-danger">{this.state.modalErr}</Form.Label>
                                </Form.Group>
                            </Form>

                        </Modal.Body>
                        <Modal.Footer>

                            <Button variant="secondary" onClick={this.closeModal}>
                                Đóng
                            </Button>
                            <ButtonGroup>
                                <Button variant="primary mr-2" onClick={this.saveEvent}>
                                    Lưu
                            </Button>
                                <Button variant="danger" onClick={this.deleteEvent}>
                                    Xóa
                            </Button>
                            </ButtonGroup>

                        </Modal.Footer>
                    </Modal>
                </div>
            </div>
        );
    }
}

export default HolidayManagement;
