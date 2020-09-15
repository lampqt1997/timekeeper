import React, { Component } from 'react';
import {Route, Redirect} from 'react-router-dom'
import auth from './pages/common/auth';

export const ProtectedRoute = ({componet: Component, ...rest}) =>{
    return(
        <Route {...rest} render={ props=>{
            if(auth.authenticated())
            {
                return <Component {...props}/>;
            }
            else
            {
                return <Redirect to ={{pathname: "/Login", state: {from: props.location}}} />;
            }
        }
    }/>
    );

};