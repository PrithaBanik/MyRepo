import React,{Component} from 'react';
import {BrowserRouter as Router} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './components/Header';
import ActionFront from './controllers/ActionFront';

class App extends Component{
	render()
	{
		return(
				<div className="App">
				<Router>
				<Header/>
				<ActionFront/>
				</Router>
				</div>
		)
	}
}
//export App
export default App;
