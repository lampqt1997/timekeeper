import React, { Component } from 'react';
import TimeKeeper from './timeKeeper';
import TimeKeepingService from '../service/TimeKeepingService';


class TimeKeepingManagement extends Component {
    constructor(props) {
        super(props);
        this.state = {
            timekeepers: [],
            timekeeper: {},
            modalShow: false,
            modalTitle: '',
            modalNew: '',
            selectDay: '',
            selectMonth: '',
            selectYear: '',
            txtDepartment: ''
        }
    }
    
    loadData = () => {
        let page = 1;
        let numberOfResult = 50;
        let date = '2020-08-25';
        TimeKeepingService.list(page, numberOfResult, date).then(res => {
            console.log(res.data.data);
            this.setState({ timekeepers: res.data.data.data });
        })
    }
    componentDidMount() {
        this.loadData();
    }

    renderTime = (time) => {
        let e = [];
        time.map((t,i) =>{
            if (i % 2 ==0) {
                e.push(<a className="d-inline text-primary mr-2 cursor" >{t}</a>);
            } else {
                e.push(<a className="d-inline text-danger mr-2 cursor">{t}</a>);
            }  
        })
        
        return e;
        
    }


    render() {
        return (
            <div className="content bg-white">
                <div className="container-fluid">
                    <div className="row">
                    <div className="filter-table col-12">
                <div className="row border-bottom border-info pb-3">
                    <div className="col-2">
                        <label className="text-dark h4 mt-0">Chấm công hằng ngày</label>
                    </div>
                    <div className="col-5">
                        <div className="form-row">
                            <div className="col-auto">
                                <select className="form-control" id="exampleFormControlSelect1">
                                    <option>01</option>
                                    <option>02</option>

                                </select>
                            </div>
                            <div className="col-auto">
                                <select className="form-control" id="exampleFormControlSelect1">
                                    <option>Tháng 1</option>
                                    <option>Tháng 2</option>
                                    <option>Tháng 3</option>

                                </select>
                            </div>
                            <div className="col-auto">
                                <select className="form-control" id="exampleFormControlSelect1">
                                    <option>2020</option>
                                    <option>2021</option>
                                    <option>2022</option>

                                </select>
                            </div>
                        </div>


                    </div>


                </div>
                <div className="row  my-4">
                    <div className="col-auto">
                        <label >Phòng ban</label>
                    </div>
                    <div className="col-3">
                        <div className="form-group">
                            <input className="form-control" type="text" name="inlineRadioOptions" />
                        </div>
                    </div>

                    <div className="col align-self-end">

                        <button className="btn btn-success float-right mt-0">Xuất file</button>
                        <button className="btn btn-warning float-right mt-0  mx-2">Nạp file</button>
                    </div>

                </div>
                <div className="row justify-content-center">
                    <div className="col-auto">
                        <div className="form-check form-check-inline text-info mr-5">
                            <input className="form-check-input" type="radio" name="inlineRadioOptions"
                                value="option1" />
                            <label className="form-check-label ml-0 pl-1" >Tất cả</label>
                        </div>

                        <div className="form-check form-check-inline text-danger">
                            <input className="form-check-input" type="radio" name="inlineRadioOptions"
                                value="option3" />
                            <label className="form-check-label ml-0 pl-1" >Chưa hợp lệ</label>
                        </div>

                    </div>
                </div>
            </div>

      
            <div className="main-table col-12  p-3 mt-3">
                <div className="">
                    <table className="table table-hover table-bordered">
                        <thead className="thead-light">
                            <th scope="col">#</th>
                            <th>Mã nhân viên</th>
                            <th>Tên nhân viên</th>
                            <th>Phòng ban</th>
                            <th>Vị trí</th>
                            <th>Ca làm việc</th>

                            <th colspan="2">Thời gian</th>

                        </thead>
                        <tbody>
                            {
                                this.state.timekeepers.map( (timekeeper, idx) => {
                                    return (

                                        <tr key={timekeeper.employeeId}>
                                            <td>{idx + 1}</td>
                                            <td>{timekeeper.employeeCode}</td>
                                            <td>{timekeeper.fullName}</td>
                                            <td>{timekeeper.department}</td>
                                            <td>{timekeeper.position}</td>
                                            <td>{timekeeper.shift}</td>
                                            <td>
                                                {this.renderTime(timekeeper.time)}
                                            </td>
                                            <td>
                                                <span onClick={() => { this.showModal(timekeeper.employeeId) }} className="cussor"> <i className="fa fa-edit text-success"></i> </span>
                                                <a onClick={(e) => { e.preventDefault(); this.showConfirm(timekeeper.employeeId); }} className="cussor"> <i className="fa fa-trash text-danger"></i> </a> 
                                            </td>
                                        </tr>
                                    );
                                })
                            }
                        </tbody>
                    </table>

                </div>
            </div>

        
                    </div>
                </div>
            </div>
        );
    }
}
















export default TimeKeepingManagement;