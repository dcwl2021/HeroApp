@ui
Feature: Create warrior failing test


  @smoke @heroapp1 @warrior
  Scenario Outline: TC04 - report defect
    Given I am on the Hero App Home Page
    When I create new warrior <name>
    Then I can see the starting with Smith
    Examples:
      | name     |
      | SuperMan |
