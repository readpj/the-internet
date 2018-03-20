@key_presses
Feature: Key presses

  Scenario Outline: Test key presses
    Given I want to test key presses
    When I press the "<Key>" key
    Then the "<Key>" key is displayed

    Examples:
      | Key    |
      | END    |
      | SHIFT  |
      | DELETE |
      | TAB    |
