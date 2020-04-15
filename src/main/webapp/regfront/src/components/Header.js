import React,{Component}from 'react';
import { Link} from 'react-router-dom';
import counterpart from 'counterpart';
import Translate from 'react-translate-component';
import en from './en';
import de from './de';
import RegistrationForm from './RegistrationForm';

counterpart.registerTranslations('en', en);
counterpart.registerTranslations('de', de);
counterpart.setLocale('en');
class Header extends Component{
	constructor(props) {
        super(props)
        this.state = {
        	lang:'en',
        	lnk: false
        }
        
	}
	onLangChange = (e) => {
	    this.setState({lang: e.target.value});
	    counterpart.setLocale(e.target.value);
	    console.log("agdfs");
	  }
	
	
	render(){
		
		return(
				<div>
				
					<header>
					<nav className="navbar navbar-expand-md navbar-dark bg-success">
						<div><a className="navbar-brand" href="/">PATIENT PORTAL</a></div>
						<ul className="navbar-nav">
							<li ><Link to="/Register" className="nav-link">REGISTER</Link></li>
							<li ><Link to="/Search" className="nav-link" >SEARCH</Link></li>
						</ul>
						<ul className="navbar-nav navbar-collapse mr-auto justify-content-end">
						<li>
						<Translate component="label" content="changelanguage" className="nav-link"/>
						</li>
						<li className="nav-item dropdown">
                        <select value={this.state.lang} onChange={this.onLangChange}>
                            <option value="en">English</option>
                            <option value="de">German</option>
                        </select>
                        </li>
                        </ul>
                       
					</nav>
					
			
					</header>
					
					
					</div>
					
					
		)
	}
}
export default Header;