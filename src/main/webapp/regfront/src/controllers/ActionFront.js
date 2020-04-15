import React, { Component } from 'react';
import {Route,Switch} from "react-router-dom";
import RegistrationForm from '../components/RegistrationForm';
import Home from '../components/Home';
import Search from '../components/Search';
class ActionFront extends Component{
    render(){
        return(
            <div className="Actionfront">
            		<Switch>
                         <Route exact path="/" component={Home}/>
                         <Route path="/Register" component={RegistrationForm}/>
                         <Route path="/Search" component={Search}/>
                         
                    </Switch>
            </div>
        )
    }
}
export default ActionFront;