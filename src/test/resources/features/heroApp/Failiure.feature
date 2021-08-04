@ui
Feature: UI - Create warrior failing test


  @smoke1
  Scenario Outline: TC05 - report defect on failure
    Given I am on the Hero App Home Page
    When I create new warrior <name>
    Then I can see the starting with Smith
    Examples:
      | name     |
      | SuperMan |
