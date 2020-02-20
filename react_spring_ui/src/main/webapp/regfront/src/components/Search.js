import React, {Component} from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import axios from 'axios';
import styles from './HomePageStyle.module.css';
import Translate from 'react-translate-component';
const DEFAULT_STATE = {
		searchMessage:""
}
class Search extends Component{
	constructor(props){
		super(props)
		this.state={
			data: [],
			firstName: '',
			dob:'',
			lastName:'',
			patientId:'',
			firstNameError: "",
            lastNameError: "",
            dobError: "",

		}
		 {/*Binds all the functions defined in this component*/}
		this.handleSuccessfulResponse= this.handleSuccessfulResponse.bind(this);
		this.searchByIdFirstnameLastnameDob=this.searchByIdFirstnameLastnameDob.bind(this);
		}
	componentDidMount() {
		this.state = {
				show: false
		};

	}
	handleIdChange=(event)=>{
		this.setState({
			[event.target.name]: event.target.value 
		})
	}

	
	/*Function to pass the values entered by the user based on which the */
	searchByIdFirstnameLastnameDob=(event)=>{
		        event.preventDefault();
        		axios.get('http://localhost:8082/searchByIdFirstNameLastNameDob/',{
        		params:{
					id:this.state.patientId,
					firstName:this.state.firstName,
					lastName:this.state.lastName,
					dob:this.state.dob
				
				}
			
			}).then(res=>{
				if(res.data==="Server is down.Please check if the server is working" || res.data==="No patients available" ||res.data==="Patient Not Found" ){
					this.handleSuccessfulResponse(res.data)
					event.preventDefault();
					this.setState({
						show: false
					});
				}
				else{
					this.setState(DEFAULT_STATE);
					console.log(this.state.searchMessage);	
					this.handleSuccessfulResponse(this.state.searchMessage)
					console.log(res.data)
					this.setState({ 
						data: res.data
				});
			/*Display the result in a table only when the data is retrieved from the backend*/
			this.setState({
				show: true
			});
			console.log(this.state.data);
			event.preventDefault()
				}	
		})
		event.preventDefault();
	}   
	
	handleSubmit=(event)=>{
		console.log("Submitted")
		let patientId=this.state.patientId
		if(!this.state.patientId)
		{
			axios.get("http://localhost:8082/getAll").then(res => {
				if(res.data==="Server is down.Please check if the server is working" || res.data==="No patients available" ){
					this.handleSuccessfulResponse(res.data)
					event.preventDefault();
					
				}
				else{

					this.setState({
						data: res.data
					});
					/*Display the result in a table only when the data is retrieved from the backend*/
					this.setState({
						show: true
					});
					console.log(this.state.data);
					event.preventDefault();
				}
			})
			this.state.data=[];
			event.preventDefault();
		}
		else{	
			axios.get(`http://localhost:8082/searchById/${patientId}`).then(res=>{
				if(res.data==="Server is down.Please check if the server is working"|| res.data==="Patient Not Found" || res.data==="No patients available"){
					this.handleSuccessfulResponse(res.data)
					event.preventDefault();
				}
				else{
					console.log(res.data)
					this.setState({ 
						data: res.data
					})
					this.setState({
						show: true
					});
					console.log(this.state.data);
					event.preventDefault();
				}
			})
			console.log('it is in else part')
			event.preventDefault();
		}
		event.preventDefault();
	}

	handleSuccessfulResponse=(res)=>{
		this.setState({searchmessage: res})
		console.log(this.state.searchmessage);
	}
	render(){

		var { data = [] } = this.props;
		return(
				<div className="d-flex flex-wrap justify-content-center align-items-center container">
				<Form id="form">
				<br></br>
				<div className="text-center">
				{this.state.searchmessage}
				</div>
				<br></br>
				<div>
				<div className="form-group row">                                                                           
				<Translate component= "label" className="col-sm-3 col-form-label" content="patientid"/>    
					<div className="col-sm-8">                                                                             
					<Translate component= "input" type="text" className="form-control" id="pid"  
					attributes={{placeholder: "enterpatientid"}}
				name="patientId"                                                         
					value={this.state.patientId}                                                                    
				onChange={this.handleIdChange}/> 
				</div>
				</div>
				<div className="form-group row">

				<Translate component= "label" className="col-sm-3 col-form-label" content="firstname"/>  
					<div className="col-sm-8"> 
					<Translate component= "input" type="text" className="form-control" id="firstName"  
					attributes={{placeholder: "enterpatientfirstname" }}
					name="firstName"                                                         
					value={this.state.firstName}   
					onChange={this.handleIdChange}/> 
				</div>  
					{this.state.firstNameError ? (<div className={styles.error}>{this.state.firstNameError}</div>) : null}
				</div>
				<div className="form-group row">
				<Translate component= "label" className="col-sm-3 col-form-label" content="lastname"/>  
					<div className="col-sm-8"> 
					<Translate component= "input" type="text" className="form-control" id="lastName"  
					attributes={{placeholder: "enterpatientlastname" }}
					name="lastName"                                                         
					value={this.state.lastName}                                                                    
					onChange={this.handleIdChange}/> 
				</div>  

				</div>
				<div className="form-group row">

				<label className="col-sm-3 col-form-label">D.O.B:</label>  
					<div className="col-sm-8"> 
					<Translate component= "input" type="text" className="form-control" id="dob"  
					attributes={{placeholder: "enterpatientdob" }}
				name="dob"                                                         
					value={this.state.dob}                                                                    
				onChange={this.handleIdChange}/> 
				</div>  
					{this.state.dobError ? (<div className={styles.error}>{this.state.dobError}</div>) : null}
				</div>
				<br></br>
				<br></br>

				</div>
				<div className="row-md-3 text-center"> 
						<Translate component="Button" className="btn btn-primary mr-3" onClick={this.searchByIdFirstnameLastnameDob} content="searchByidfirstnamelastnamedob"/>
				</div>
				</Form>
				
				<div className="table-wrapper-scroll-y my-custom-scrollbar">
				{
					this.state.show &&
					<table className="table">
					<thead>
					<tr>
					<Translate component="th" content="patientid"/>
						<Translate component="th" content="firstname"/>
						<Translate component="th" content="lastname"/>
						<th>D.O.B</th>
						<Translate component="th" content="gender"/>
						<Translate component="th" content="email"/>
						<Translate component="th" content="addressline1"/>
						<Translate component="th" content="addressline2"/>
						<Translate component="th" content="city"/>
						<Translate component="th" content="state"/>
						<Translate component="th" content="country"/>
						</tr>
						</thead>
						<tbody> 
						{
							this.state.data.map(
									(data, index)=>
									<tr key={data.id}>
									<td >{data.id}</td>
									<td >{data.firstName}</td>
									<td >{data.lastName}</td>
									<td width="22%">{data.dob}</td>
									<td >{data.gender}</td>
									<td width="20%">{data.email}</td>
									<td width="5%">{data.address.addressLine1}</td>
									<td width="5%">{data.address.addressLine2}</td>
									<td width="21%">{data.address.city}</td>
									<td width="20%">{data.address.state}</td>
									<td >{data.address.country}</td>
									</tr>
							)
						}
						</tbody>
						</table>
				}
				</div>
				</div>
		)
	}
}
export default Search;


