@api
Feature: API - Create warrior

  @smoke
  Scenario Outline: API_TC01 - Get warrior details
    Given I would like to access Hero App API
    When I retrieve warrior details from api
    Then I verify api response for <name>

    Examples:
      | name     |
      | SuperMan |


  @smoke
  Scenario Outline: API_TC02 - Add new warrior
    Given I would like to access Hero App API
    When I create warrior with <name> and <score>
    Then I verify api response for <message>

    Examples:
      | name | score | message |
      | Cleo | 10    | success |