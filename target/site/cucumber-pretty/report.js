$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/PhpAddCustomer.feature");
formatter.feature({
  "name": "Add customer functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to URL https://www.phptravels.net/admin",
  "keyword": "Given "
});
formatter.match({
  "location": "PhpTravel_StepDefinition.navigateToPhptravelsDemoSite(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "phptravels User enter valid admin username admin@phptravels.com and password demoadmin",
  "keyword": "And "
});
formatter.match({
  "location": "PhpTravel_StepDefinition.phptravelsUserLogin(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "phptravels User admin is able to login successfully",
  "keyword": "And "
});
formatter.match({
  "location": "PhpTravel_StepDefinition.checkPhpTravelsLoginSuccess(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify user is able to add new customer",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User navigates to Add Customer page",
  "keyword": "When "
});
formatter.match({
  "location": "PhpTravel_StepDefinition.userNavigatesToAddCustomerPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Submits the new customer details as below",
  "rows": [
    {
      "cells": [
        "FirstName",
        "LastName",
        "EmailID",
        "Password",
        "MobNumber",
        "Country",
        "Add1",
        "Add2"
      ]
    },
    {
      "cells": [
        "Kaustubh",
        "Pandhare",
        "santosh.pandhare15@gmail.com",
        "pwd123",
        "9967887511",
        "Malta",
        "thane1",
        "thane2"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "PhpTravel_StepDefinition.submitsTheNewCustomerDetailsAsBelow(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});