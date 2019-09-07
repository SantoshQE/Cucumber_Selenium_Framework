
Feature: Verify login with valid user credentials
  Background:
    Given  User navigates to URL https://www.phptravels.net/admin
    #And User clicks on Login Button

  Scenario: Verify user is able to successful to log into phpTravels web application
    When phptravels User enter valid admin username admin@phptravels.com and password demoadmin
    Then phptravels User admin is able to login successfully

