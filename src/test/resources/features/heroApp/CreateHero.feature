@ui
Feature: UI - Create warrior

  @smoke @heroapp @warrior
  Scenario Outline: TC01 - Add new warrior
    Given I am on the Hero App Home Page
    When I create new warrior <name>
    Then I can see the starting with <name>
    Examples:
      | name     |
      | SuperMan |


  @smoke @heroapp @battle
  Scenario Outline: TC02 - Warrior can see battle fields
    Given I am on the Hero App Home Page
    When I create new warrior <name>
    Then I go to battle page
    And I can see moving text with "Avoid going to crowded places."
    Examples:
      | name     |
      | SuperMan |
