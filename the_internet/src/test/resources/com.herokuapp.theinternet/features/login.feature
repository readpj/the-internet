@Login
Feature: Login

  Scenario: Test the drop down page
    Given I want to test the drop down page
    When I test the drop down page
    Then the drop down page is displayed

  @form_authentication
  Scenario: Test the login form authentication
    Given I want to test form authentication
    When I test form authentication
    Then I can successfully login

#    TODO
#  clear fields when enter username
#  add extra asserts to secure area page and click the logout button
#    check fields are blank
