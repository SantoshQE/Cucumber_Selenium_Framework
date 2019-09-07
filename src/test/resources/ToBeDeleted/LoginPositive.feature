
Feature: Verify login with valid user credentials
  Background:
    Given User is on login page URL https://twitter.com/
    And Clicks on Login Button

  Scenario: Verify user is able to successful to log into mercury tours web application
    When User enter valid username 9967887510 and password Tcs@1983
    Then User is able to login successfully
    #And  Close the browser

