/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import ko = require("knockout");
import * as AccUtils from "../accUtils";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import "oj-c/input-password";
import "oj-c/input-date-text";
import ArrayDataProvider = require('ojs/ojarraydataprovider');
import { ojButton } from "ojs/ojbutton";
import "ojs/ojbutton";
import 'oj-c/radioset';
import 'oj-c/message-banner';
import 'oj-c/button';
import 'ojs/ojformlayout';
import "oj-c/progress-bar";
import { MessageBannerItem, CMessageBannerElement } from 'oj-c/message-banner';
  
import MutableArrayDataProvider = require('ojs/ojmutablearraydataprovider');
type DemoMessageBannerItem = MessageBannerItem & {
  id: string;
};

class DashboardViewModel {
  value: ko.Observable<string>;
  firstname : ko.Observable<string> | ko.Observable<any>;
  salary:ko.Observable<number>| ko.Observable<any>;
  password:ko.Observable<string> |ko.Observable<any>;
  date: ko.Observable<Date> | ko.Observable<any>;
  activatedButton: ko.Observable<string>;
  readonly personalInformationMessages: MutableArrayDataProvider<string, DemoMessageBannerItem>;
  private counter: number;
  readonly closePersonalInformationMessage = (
    event: CMessageBannerElement.ojClose<string, DemoMessageBannerItem>
  ) => {
    // remove the message from the data to close it
    let data = this.personalInformationMessages.data.slice();
    const closeMessageKey = event.detail.key;

    data = data.filter((message) => (message as any).id !== closeMessageKey);
    this.personalInformationMessages.data = data;
  };
  readonly updatePersonalInfo = () => {
    // remove the message from the data to close it
    let data = this.personalInformationMessages.data.slice();
    data.push({
      id: `message-${++this.counter}`,
      severity: 'confirmation',
      summary: 'Updated personal information',
      detail: 'The provided personal information of the employee has been updated in the database.'
    });
    this.personalInformationMessages.data = data;
  };
  private readonly step = ko.observable(0);
    readonly progressValue = ko.pureComputed(() => {
      return Math.min(this.step(), 100);
    });
    constructor() {
      this.value = ko.observable("red");
      this.firstname = ko.observable(null);
      this.salary = ko.observable(null);
      this.password = ko.observable(null);
      this.date = ko.observable(null);
      this.activatedButton = ko.observable("(None activated yet)");
      const initialPersonalSectionData = [
        {
          id: 'message',
          severity: 'confirmation',
          summary: 'Updated personal information',
          detail:
            'The provided personal information of the employee has been updated in the database.',
          timestamp: new Date().toISOString()
        }
      ];
      this.personalInformationMessages = new MutableArrayDataProvider(initialPersonalSectionData, {
        keyAttributes: 'id'
      });
      this.counter = 0;
      window.setInterval(() => {
        this.step((this.step() + 1) % 200);
      }, 30);
    }
    
    public buttonAction = (event: ojButton.ojAction) => {
      this.activatedButton((event.currentTarget as HTMLElement).id);
      return true;
    };
}

export = DashboardViewModel;
