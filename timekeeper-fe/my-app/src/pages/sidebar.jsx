import React, { Component } from 'react';
import { Link } from 'react-router-dom';


class Navbar extends Component {
    state = {  }
    render() { 
        return (          
        <div class="sidebar" data-image="./assets/img/sidebar-5.jpg" data-color="blue">
            
             <div class="sidebar-wrapper">
                 <div class="logo">
                     <Link className="simple-text" to="/Index">
                        HR Website
                     </Link>
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
                    
                 </ul>
             </div>
         </div> );
    }
}
 
export default Navbar;