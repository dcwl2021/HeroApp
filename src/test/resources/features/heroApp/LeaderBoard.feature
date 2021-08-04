@ui
Feature: Verify leader board page

  @smoke @heroapp1 @leaderboard
  Scenario Outline: TC03 - Verify user score on leaderboard
    Given I am on the Hero App Home Page
    When I start the journey with my warrior <name>
    And I start battle with bus
    And I start game on bus
    And I select answer "Use your superheroes Mask and sanitizer while traveling on public transport and clean your hands regularly."
    Then select "Check your final score" from battle ground
    And verify score for <name> as <score>

    Examples:
      | name     | score |
      | SuperMan | 300   |