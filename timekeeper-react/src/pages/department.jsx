import React, { Component } from 'react';

class Department extends Component {
    state = {  }
    render() { 
        return ( 
            <div class="content bg-white">
                 <div class="container-fluid">

                        <div class="row border-bottom border-info pb-3">
                            <div class="col-auto">
                                <label class="text-dark h4 mt-0">Phòng ban</label>
                            </div>
                            <div class="col-5">
                                <div class="form-row">
                                    <div class="col-auto ">
                                        <input class="form-control mr-sm-2 input-sm" type="search" placeholder="Search" aria-label="Search"/>
                                    </div>
                                </div>


                        </div>




                     </div>
                     <div class="row justify-content-center" >
                        <table class="table table-bordered w-75 table-striped">
                            <thead class="thead-light">
                              <tr class="">
                                <th scope="col" class="text-primary">#</th>
                                <th scope="col" class="text-primary">Tên phòng</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <th scope="row">1</th>
                                <td>Y tế</td>

                              </tr>
                              <tr>
                                <th scope="row">2</th>
                                <td>Lao công</td>

                              </tr>
                              <tr>
                                <th scope="row">3</th>
                                <td>Kỹ thuật</td>

                              </tr>
                            </tbody>
                          </table>
                          

                     </div>
                 </div>
             </div>
            
         );
    }
}
 
export default Department;