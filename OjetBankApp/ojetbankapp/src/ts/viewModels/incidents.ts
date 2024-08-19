/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import ko = require("knockout");
import "oj-c/input-text";
import "ojs/ojknockout";
import "ojs/ojlabel";
import "oj-c/input-number";
import "ojs/ojbutton";
import "ojs/ojformlayout";
import "oj-c/input-password";
import 'oj-c/button';
class IncidentsViewModel {
  name : ko.Observable<string> | ko.Observable<any>;
  email : ko.Observable<string> | ko.Observable<any>;
  phone : ko.Observable<number> | ko.Observable<any>;
  login_id : ko.Observable<string> | ko.Observable<any>;
  password : ko.Observable<string> | ko.Observable<any>;
  address : ko.Observable<string> | ko.Observable<any>;
  state: ko.Observable<string> | ko.Observable<any>;
  country: ko.Observable<string> | ko.Observable<any>;


  constructor() {
    this.name = ko.observable(null);
    this.email= ko.observable(null);
    this.phone = ko.observable(null);
    this.login_id = ko.observable(null);
    this.password = ko.observable(null);
    this.address = ko.observable(null);
    this.state = ko.observable(null);
    this.country = ko.observable(null);
  }
  public buttonAction = async(event:Event)=>{
    const data = {
      name:this.name(),
      email:this.email(),
      phone:this.phone(),
      login_id:this.login_id(),
      password:this.password(),
      address:this.address(),
      state:this.state(),
      country:this.country()

    }
    console.log(data);
    fetch('http://localhost:8080/customercrudapi/customers', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
      console.log(result);
      sessionStorage.setItem("id",result.login_id);
      if(result==true){
      alert('Register successfully');
      // window.location.href = "?ojr=dashboard";
      }
      else{
        alert('Something went wrong');
      }
      
    })
    .catch(error => {
      console.error('Error:', error);
      alert('An error occurred while register');
    });
    return true;
 }
 
}

export = IncidentsViewModel;
