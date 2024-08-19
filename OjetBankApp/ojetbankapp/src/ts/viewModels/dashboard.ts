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
import "ojs/ojbutton";
import "ojs/ojformlayout";
import "oj-c/input-password";
import 'oj-c/button';
class DashboardViewModel {
  username : ko.Observable<string> | ko.Observable<any>;
  password:ko.Observable<string> |ko.Observable<any>;
  constructor() {
    this.username = ko.observable(null);
    this.password = ko.observable(null);
  }
  public buttonAction = async(event:Event)=>{
    const data = {
    login_id:this.username(),
     password:this.password()

    }
    console.log(data);
    fetch('http://localhost:8080/customercrudapi/find', {
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
      alert('Login  successfully');
      window.location.href = "?ojr=customers";

    })
    .catch(error => {
      console.error('Error:', error);
      alert('An error occurred while login');
    });
    return true;
 }

  
}

export = DashboardViewModel;
