@Login
Feature: Login

  Scenario: Test the drop down page
    When I want to test the drop down page
    Then the drop down page is displayed
@form_authentication
  Scenario: Test the login form authentication
    Given I want to test form authentication
    When I test form authentication
    Then I can successfully login
