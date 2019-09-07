Feature: Add customer functionality
  Background:
    Given  User navigates to URL https://www.phptravels.net/admin
    And phptravels User enter valid admin username admin@phptravels.com and password demoadmin
    And phptravels User admin is able to login successfully

  Scenario: Verify user is able to add new customer
    When User navigates to Add Customer page
    And Submits the new customer details as below
      |FirstName|LastName|EmailID|Password|MobNumber|Country|Add1|Add2|
      |Kaustubh |Pandhare |santosh.pandhare15@gmail.com|pwd123|9967887511|Malta|thane1|thane2|

