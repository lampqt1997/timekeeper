import React, { Component } from 'react';


import '../styles/assets/css/light-bootstrap-dashboard.css';
import loginService from '../service/loginService';
import '../styles/assets/css/login.css';
import '../styles/assets/css/light-bootstrap-dashboard.css';
import Cookies from "js-cookie";
import cookieUlti from '../service/cookieUlti';



class Login extends Component {
    state = { validate:"", msg:"" }
    constructor() {
        super();
        this.setState({validate:"",msg:""})
        this.handleSubmit=this.handleSubmit.bind(this);
    }

    componentDidMount(){
        if(cookieUlti.getCookie("loginUser")!==null){
            this.props.history.push("/");
            this.props.history.go(0);
        }

    }

    handleSubmit(event){
        event.preventDefault();
        // const form = new FormData(event.target);

        const data={
            username: event.target.username.value,
            password: event.target.password.value
        }
        console.log(data)
        if(!data.username || !data.password)
        {
            this.setState({validate: " border border-danger"})
            this.setState({msg:"Xin hãy nhập đầy đủ thông tin"});
        }
        else
        {
            loginService.login(data).then(res =>{
                // console.log(res)
                if(res.data.errorCode > 0)
                { 
                    this.setState({msg:"Sai tên đăng nhập hoặc mật khẩu"});
                    // console.log(res)

                }
                else
                {
                    this.setState({msg:""});
                    Cookies.set("loginUser",JSON.stringify(res.data.data),{expires: res.data.expires_in});
                    //redirect to dashboard
                    this.props.history.push("/");
                    this.props.history.go(0);
                }

            })

        }


        
    }
    render() { 
        return ( 
            <div className="h-100">
                <div className="container h-100">
                    <div className="row justify-content-center h-100 align-items-center">
                        <div className="col-lg-7">
                            <div className="card shadow-lg p-3 mb-5 bg-white rounded">
                                <div className="card-header d-flex justify-content-center">
                                    <div className="card-title h4 ">Đăng nhập</div>
                                </div>
                                <form onSubmit={this.handleSubmit}>
                                <div className="card-body">

                                <div class="form-group row">
                                    <label for="username" class="text-danger">Tên đăng nhập</label>

                                    <input type="text" class={`form-control ${this.state.validate}`} name="username" placeholder="Tên đăng nhặp" />
                                </div>
                                <div class="form-group row">
                                    <label for="password" class="text-danger">Password</label>
                                    <input type="password" class={`form-control ${this.state.validate}`} name="password" placeholder="Mật khẩu" />
                                </div>
                                <div class="form-group d-flex justify-content-center">
                                    <small class="text-danger row">{this.state.msg}</small>
                                </div>
                                <div class="form-group d-flex justify-content-center">
                                    <button type="submit" class="btn btn-success mb-2">Đăng nhập</button>
                                </div>
                                

                                </div>
                                </form>
                             
                            </div>
                        </div>
                    </div>
                </div>
            </div>

         );
    }
}
 
export default Login;