@form_authentication
Feature: Form authentication
  Demonstrates 3 methods for automating logging in with supplied user credentials

  Scenario: Creates an object from the Internet Credentials class and builds it with values from the user properties file
    Given I want to test form authentication
    When I test form authentication
    Then I can successfully login

  Scenario: Uses a cucumber DataTable to pass the user credentials to the enter methods
    Given I want to test form authentication
    When I enter the credentials
      | tomsmith | SuperSecretPassword! |
    Then I can successfully login

  Scenario: Uses a hash map to run multiple tests, the DataTable contains headers to make it more readable
    Given I want to test form authentication
    When I enter the following credentials
      | Username | Password            |
      | tomsmith | SuperSecretPassword |
      | tomsmith | SuperSecretPasswor  |
      | tomsmith | SuperSecretPasswo   |