import React, { Component } from 'react';

class EmployeeList extends Component {
    state = {  }
    render() { 
        return ( 
            <div class="content bg-white h-100">
            <div class="container-fluid">

                   <div class="row border-bottom border-info pb-3">
                       <div class="col-auto">
                           <label class="text-dark h4 mt-0">Nhân viên</label>
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
                         <tr>
                           <th scope="col" class="text-primary">#</th>
                           <th scope="col" class="text-primary">Họ và tên lót</th>
                           <th scope="col" class="text-primary">Tên</th>
                           <th scope="col" class="text-primary">Phòng ban</th>
                           <th scope="col" class="text-primary">Timecheck code</th>
                           <th scope="col" class="text-primary">Vị trí</th>
                           <th scope="col" class="text-primary">Số điện thoại</th>

                         </tr>
                       </thead>
                       <tbody>
                         <tr>
                           <th scope="row">1</th>
                           <td>Nguyễn Thị</td>
                           <td>Cường</td>
                           <td>Y tế</td>
                           <td>134r3</td>
                           <td>Bác sĩ</td>
                           <td>0908238919</td>


                         </tr>
                         <tr>
                           <th scope="row">1</th>
                           <td>Nguyễn Thị</td>
                           <td>Cường</td>
                           <td>Y tế</td>
                           <td>12/9/2019</td>
                           <td>13/9/2019</td>
                           <td>0908238919</td>


                         </tr>
                         <tr>
                           <th scope="row">1</th>
                           <td>Nguyễn Thị</td>
                           <td>Cường</td>
                           <td>Y tế</td>
                           <td>12/9/2019</td>
                           <td>13/9/2019</td>
                           <td>0908238919</td>


                         </tr>
                       </tbody>
                     </table>
                     

                </div>
            </div>
        </div>
       
         );
    }
}
 
export default EmployeeList;