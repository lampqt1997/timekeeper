import React, { Component } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUser, faKey } from '@fortawesome/free-solid-svg-icons';


class Login extends Component {
    state = {  }
    render() { 
        return ( 
            <div className="bg-primary h-100">
                <div className="container h-100">
                    <div className="row justify-content-center h-100 align-items-center">
                        <div className="col-sm-8 col-lg-5">
                            <div className="card">
                                <div className="card-header">
                                    <div className="card-title">Login</div>
                                </div>
                                <div className="card-body">
                                    <form action="">
                                        <div className="form-group">
                                            <label htmlFor="exampleInputEmail1">Username</label>
                                            <div className="input-group input-group-lg">
                                                    <div className="input-group-prepend">
                                                        <span className="input-group-text" id="basic-addon1">
                                                            <FontAwesomeIcon icon={faUser}/>
                                                        </span>
                                                    </div>
                                                    <input type="text" className="form-control" placeholder="Username" aria-label="Username"
                                                        aria-describedby="basic-addon1"/>
                                                </div>
                                        </div>
                                        <div className="form-group">
                                            <label htmlFor="exampleInputEmail1">Password</label>
                                            <div className="input-group input-group-lg">
                                                    <div className="input-group-prepend">
                                                        <span className="input-group-text" id="basic-addon1">
                                                            <FontAwesomeIcon icon={faKey}/>
                                                        </span>
                                                    </div>
                                                    <input type="text" className="form-control" placeholder="Password" aria-label="Password"
                                                        aria-describedby="basic-addon1"/>
                                                </div>
                                        </div>
                                        
                                        <button type="button" className="mt-4 btn btn-primary btn-lg btn-block">Sign in</button>

                                    </form>
                                </div>
                            
                            </div>
                        </div>
                    </div>
                </div>
            </div>

         );
    }
}
 
export default Login;