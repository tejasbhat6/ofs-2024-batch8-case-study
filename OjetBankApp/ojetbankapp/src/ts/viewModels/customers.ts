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
import "ojs/ojtable";
import { RESTDataProvider } from "ojs/ojrestdataprovider";

type D = { account_id: number; account_type: string; account_balance: number; account_minimum_balance: number;account_status: string;overdraft_amount: number};
type K = D["account_id"];

class WelcomeModel {
  dataprovider: RESTDataProvider<K, D>;
  keyAttributes = "accountId";
  url = "http://localhost:8080/customercrudapi/allaccounts/1";
  constructor() {
      this.dataprovider = new RESTDataProvider({
      keyAttributes: this.keyAttributes,
      url: this.url,
      transforms: {
      fetchFirst: {
      request: async (options) => {
      const url = new URL(options.url);
      const { size, offset } = options.fetchParameters;
      url.searchParams.set("limit", String(size));
      url.searchParams.set("offset", String(offset));
      return new Request(url.href);
      },
      response: async ({ body }) => {
      // We need to assign "items" to "data"
      return { data: body };
      },
      },
      },
      });
    }
    public buttonAction = async(event:Event)=>{
      window.location.href ="?ojr=CreateAccount"
   }
  }

export = WelcomeModel;
