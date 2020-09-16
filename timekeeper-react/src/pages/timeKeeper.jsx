import React, { Component } from "react";

class TimeKeeper extends Component {
    state = {};
    render() {
        return (
            <div class="content bg-white">
                <div class="container-fluid">
                    <div class="row">
                        <ControlBar />
                        <ResultTable/>
                    </div>
                </div>
            </div>
        );
    }
}

class ControlBar extends Component {
    state = {};
    render() {
        return (
            <div class="filter-table col-12">
                <div class="row border-bottom border-info pb-3">
                    <div class="col-auto">
                        <label class="text-dark h4 mt-0">Chấm công</label>
                    </div>
                    <div class="col-5">
                        <div class="form-row">
                            <div class="col-auto">
                                <select
                                    class="form-control"
                                    id="exampleFormControlSelect1"
                                >
                                    <option>01</option>
                                    <option>02</option>
                                </select>
                            </div>
                            <div class="col-auto">
                                <select
                                    class="form-control"
                                    id="exampleFormControlSelect1"
                                >
                                    <option>Tháng 1</option>
                                    <option>Tháng 2</option>
                                    <option>Tháng 3</option>
                                </select>
                            </div>
                            <div class="col-auto">
                                <select
                                    class="form-control"
                                    id="exampleFormControlSelect1"
                                >
                                    <option>2020</option>
                                    <option>2021</option>
                                    <option>2022</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row  my-4">
                    <div class="col-auto">
                        <label for="">Phòng ban</label>
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <input
                                class="form-control"
                                type="text"
                                name="inlineRadioOptions"
                            />
                        </div>
                    </div>

                    <div class="col align-self-end">
                        <button class="btn btn-success float-right mt-0">
                            Xuất file
                        </button>
                        <button class="btn btn-warning float-right mt-0  mx-2">
                            Nạp file
                        </button>
                    </div>
                </div>
                <div class="row">
                    <span class="col-auto align-self-center">Hiện</span>
                    <div class="form-group align-self-center">
                        <select class="form-control">
                            50
                            <option value="">50</option>
                            <option value="">100</option>
                            <option value="">200</option>
                        </select>
                    </div>

                    <span class="col-auto align-self-center">kết quả</span>
                </div>
            </div>
        );
    }
}

class ResultTable extends Component {
    state = {};
    render() {
        return (
            <div class="main-table col-12  p-3 mt-3">
                <div class="">
                    <table class="table table-hover table-bordered">
                        <thead class="thead-light">
                            <th scope="col">#</th>
                            <th>Mã nhân viên</th>
                            <th>Tên nhân viên</th>
                            <th>Phòng ban</th>
                            <th>Vị trí</th>

                            <th></th>
                        </thead>
                        <TableBody/>
                    </table>
                </div>
            </div>
        );
    }
}

class TableBody extends Component {
    state = {};

    renderTableRows(num) {
        const elementList = [];
        for (let i = 0; i < num; i++) {
            elementList.push(<TableRow/>);
        }
        console.log(elementList);
        return elementList;
    }

    render() {
        return (
            <tbody>
                {this.renderTableRows(24)}
            </tbody>
        );
    }
}

class TableRow extends Component {
    state = {};
    render() {
        return (
            <tr>
                <td>1</td>
                <td>NHV0001</td>
                <td>Lê Tùng Dương</td>
                <td>D23 Dongjin</td>
                <td>Công nhân </td>

                <td>
                    <a href="" class="btn-link">
                        <i class="fa fa-info"></i>
                    </a>
                </td>
            </tr>
        );
    }
}

export default TimeKeeper;
