import React, { Component } from 'react';
import Dialog from 'react-bootstrap-dialog';
import Cookies from "js-cookie";

class Header extends Component {
    constructor(props){
        super(props);
        this.logoutComfirm=this.logoutComfirm.bind(this)
    }
    logoutComfirm=()=>{
        this.dialog.show({
          title: 'Đăng xuất?',
          body: 'Bạn muốn đăng xuất?',
          actions: [
            Dialog.CancelAction(),
            Dialog.OKAction(() => {
                Cookies.remove("loginUser");
                window.location.href = "/";
                
                //this.props.history.push("/employee")

            })
          ],
          bsSize: 'small',
          onHide: (dialog) => {
            dialog.hide()
          }
        })
    }


	render() { 
		return ( 
			<nav
                    class="navbar navbar-expand-lg bg-light "
                    color-on-scroll="500"
                >
                    <div class="container-fluid">
                        {/* <a class="navbar-brand" href="#pablo"> Quản lý Công nhân </a>  */}
                        <button
                            href=""
                            class="navbar-toggler navbar-toggler-right"
                            type="button"
                            data-toggle="collapse"
                            aria-controls="navigation-index"
                            aria-expanded="false"
                            aria-label="Toggle navigation"
                        >
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                        <div
                            class="collapse navbar-collapse justify-content-end"
                            id="navigation"
                        >
                            <ul class="navbar-nav ml-auto ">
                                <li class="nav-item">
                                    <a class="nav-link" href="#pablo">
                                        <span class="no-icon">Account</span>
                                    </a>
                                </li>
                               
                                <li class="nav-item">
                                    <a class="nav-link"  onClick={()=>this.logoutComfirm()}>
                                        <span class="no-icon">Log out</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Dialog ref={(el) => { this.dialog = el }} />
                </nav>

        
		 );
	}
}

export default Header;