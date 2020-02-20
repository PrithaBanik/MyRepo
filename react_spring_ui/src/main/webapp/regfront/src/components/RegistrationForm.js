import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import styles from './HomePageStyle.module.css';
import moment from 'moment';
import axios from 'axios';
import Translate from 'react-translate-component';
import Header from './Header';
{/* This is to initialize the default state of the variables as empty*/}
const DEFAULT_STATE = {
    firstName: "",
    lastName: "",
    dob: "",
    gender: "",
    phoneNo: "",
    email: "",
    address: "",
    firstNameError: "",
    lastNameError: "",
    phoneNoError: "",
    city: "",
    state: "",
    zipcode: "",
    addressLine1: "",
    addressLine2: "",
    country: ""
}

class RegistrationForm extends Component {
	
	   constructor(props) {
        super(props)
        this.state = {
            firstName: "",
            lastName: "",
            dob: "",
            gender: "",
            phoneNo: "",
            email: "",
            address: "",
            firstNameError: "",
            lastNameError: "",
            phoneNoError: "",
            city: "",
            state: "",
            zipcode: "",
            addressLine1: "",
            addressLine2: "",
            country: "",
            welcomeMessage:"",
        }
        {/*Binds all the functions defined in this component*/}
        this.handleClear = this.handleClear.bind(this)
        this.handleSuccessfulResponse= this.handleSuccessfulResponse.bind(this)

    }
	   /*Sets the state to the new values after changes are made*/
    handleChangeAll = (event) => {
        this.setState({ [event.target.name]: event.target.value })
     }
    validate = () => {
        let firstNameError = "";
        let lastNameError = "";
        let phoneNoError="";
                       
        // firstName cannot be digits
        if (this.state.firstName !== "undefined") {
            if (!this.state.firstName.match(/^[a-zA-Z ]*$/)) {
                firstNameError = "*Please enter alphabet characters only.";
            }
        }
        
        // lastName has to be characters only
        if (this.state.lastName !== "undefined") {
            if (!this.state.lastName.match(/^[a-zA-Z ]*$/)) {
                lastNameError = "*Please enter alphabet characters only.";
            }
        }
          // phone number must be of 10 digits
          if (this.state.phoneNo !== "undefined") {
            if (!this.state.phoneNo.match(/^[0-9]{10}$/)) {
               phoneNoError = "*Please enter valid mobile no.";
            }
          }
        if ( firstNameError || lastNameError ||phoneNoError) {
            this.setState({  firstNameError,lastNameError,phoneNoError });
            return false;
        }
        return true;
    };
    handleSubmit = (event) => {
        const isValid = this.validate();
        event.preventDefault();
        if (isValid) {
            console.log(this.state);
           
           let patient={
            	firstName:this.state.firstName,
            	lastName:this.state.lastName,
            	dob:this.state.dob,
            	gender:this.state.gender,
            	email:this.state.email,
            	address: {
            			city:this.state.city,
                    	state:this.state.state,
                    	addressLine1:this.state.addressLine1,
                    	addressLine2:this.state.addressLine2,
                    	country:this.state.country
            	}
            	}
                axios.post('/addPatient',patient,{
                    headers: {"Accept-Language":this.state.lang}
                
                }).then(response=>this.handleSuccessfulResponse(response),console.log(this.props.lang)); 
             }
     }
    handleSuccessfulResponse(response){
    	this.setState({welcomeMessage: response.data})
    }
    // clears form
    handleClear = (event) => {
         this.setState(DEFAULT_STATE);
      }
    render() {
    	
    
    	
            return (
            		
            <div className="RegistrationForm">
           
                <div className="d-flex justify-content-center align-items-center container ">
                
                    <Form id="form" onSubmit={this.handleSubmit}>
                    <br></br>
                    <div className="text-center">
                    	{this.state.welcomeMessage}
                    </div>
                    <div className="text-center">
                    	 <Translate component= "h7" content="pleasefillthefields"/><span className={styles.error}>*</span> 
                	</div>
                	<br></br>
                        <div className="form-group row">
                            <Translate component= "label" className="col-sm-3 col-form-label"content="firstname"/><span className={styles.error}>*</span>
                            <div className="col-sm-8">
                            <Translate component="input" type="text" className="form-control" id="fname" 
                                	attributes={{placeholder: 'firstnameplace'}}
                            		name="firstName"
                                	value={this.state.firstName} 
                                	onChange={this.handleChangeAll}
                                	ref={el => this.firstName = el}
                                	required/>

                            </div>
                            {this.state.firstNameError ? (<div className={styles.error}>{this.state.firstNameError}</div>) : null}
                        </div>

                        <div className="form-group row">
                            <Translate component= "label" className="col-sm-3 col-form-label"content="lastname"/><span className={styles.error}>*</span>
                            <div className="col-sm-8">
                                <Translate component="input" type="text" className="form-control" id="lname" 
                                	attributes={{placeholder: 'lastnameplace'}}
                                	name="lastName" 
                                	value={this.state.lastName} 
                                	onChange={this.handleChangeAll} 
                                	required/>
                            </div>
                            {this.state.lastNameError ? (<div className={styles.error}>{this.state.lastNameError}</div>) : null}
                        </div>
                        <div className="form-group row">
                            <Translate component= "label" className="col-sm-3 col-form-label" content="dob"/><span className={styles.error}>*</span>
                            <div className="col-sm-8">
                                <input type="date" className="form-control" id="dob" 
                                	name="dob" value={this.state.dob} 
                                   onChange={this.handleChangeAll}  max={moment().format("YYYY-MM-DD")}required />
                            </div>
                        </div>
                        <div className="form-group row">
                            <Translate component= "label" className="col-sm-3 col-form-label" content="gender"/><span className={styles.error}>*</span>
                            <div className="col-sm-8">
                                <Translate component="select" className="custom-select mr-sm-2" id="inlineFormCustomSelect" name="gender" 
                                	value={this.state.gender}
                                	onChange={this.handleChangeAll}>
                                    <Translate component="option" value="male"id="male" name="male" content="male"/>
                                    <Translate component="option" value="female" id="female" name="female" content="female"/>
                                    required
                                </Translate>
                                
                            </div>
                        </div>
                        <div className="form-group row">
                       <Translate component= "label" className="col-sm-3 col-form-label"content="phonenumber"/><span className={styles.error}>*</span>
                            <div className="col-sm-8">
                                <input type="number" className="form-control" id="phoneNo"
                                	name="phoneNo" value={this.state.phoneNo} 
                                    onChange={this.handleChangeAll} required/>
                            </div>
                            {this.state.phoneNoError ? (<div className={styles.error}>{this.state.phoneNoError}</div>) : null}
                        </div>
                        <div className="form-group row">
                        <Translate component= "label" className="col-sm-3 col-form-label" content="email"/>
                        <div className="col-sm-8">
                            <input type="email" className="form-control" id="address"
                            	name="email" value={this.state.email} 
                            	onChange={this.handleChangeAll} />
                        </div>
                      </div>
                      
                        <div className="form-group row">
                        <Translate component= "label" className="col-sm-3 col-form-label" content="addressline1"/>
                        <div className="col-sm-8">
                            <Translate component="input" type="text" className="form-control" 
                            	id="addressLine1" 
                            	attributes={{placeholder: 'enterstreetnumber'}} 
                            	name="addressLine1" value={this.state.addressLine1}
                            	onChange={this.handleChangeAll} />
                        </div>
                     </div>
                     <div className="form-group row">
                        <Translate component="label" className="col-sm-3 col-form-label" content="addressline2"/>
                        <div className="col-sm-8">
                            <Translate component="input" type="text" className="form-control" id="addressLine2" 
                            	attributes={{placeholder: 'enterhousenumber'}} 
                            	name="addressLine2" 
                            	value={this.state.addressLine2} onChange={this.handleChangeAll} />
                        </div>
                       </div>
                       <div className="form-group row">
                          <Translate component="label" className="col-sm-3 col-form-label" content="city"/>
                          <div className="col-sm-8">
                          <input type="text" className="form-control" id="city" 
                            	name="city" value={this.state.city} 
                           onChange={this.handleChangeAll} />
                           </div>
                         </div>
                         <div className="form-group row">
                            <Translate component= "label" className="col-sm-3 col-form-label"content="state"/>
                            <div className="col-sm-8">
                            <input type="text" className="form-control" id="state"
                            	name="state" value={this.state.state} 
                             onChange={this.handleChangeAll} />
                            </div>
                        </div>
                        <div className="form-group row">
                            <Translate component="label" className="col-sm-3 col-form-label" content="country"/>
                            <div className="col-sm-8">
                                <input type="text" className="form-control" id="country" 
                                	name="country" value={this.state.country} 
                                	onChange={this.handleChangeAll} />
                            </div>
                         </div>
                      <div className="col-md-12 text-center">                         
                        	<Translate component="Button" type="submit" value="Register" className="btn btn-primary mr-3" content="register"/>
                        		<Translate component="Button" className="btn btn-primary" onClick={this.handleClear}content="clear"/>
                        </div>
                        
                        	</Form>
                        	
                </div>
         </div>
        )
    }
}

export default RegistrationForm;