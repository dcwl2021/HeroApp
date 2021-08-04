@ui
Feature: UI - Verify leader board page

  @smoke @heroapp @leaderboard
  Scenario Outline: <test> - Verify user score on leaderboard
    Given I am on the Hero App Home Page
    When I start the journey with my warrior <name>
    And I start battle with <battle>
    And I select answer "<answer>"
    Then select "Check your final score" from battle ground
    And verify score for <name> as <score>

    Examples:
      | test | name      | battle     | score | answer                                                                                                       |
      | TC03 | SuperMan  | bus        | 100   | Use your superheroes Mask and sanitizer while traveling on public transport and clean your hands regularly.  |
      | TC04 | SuperStar | restaurant | 100   | Use your super hero sanitizer, keep a safe distance and advise they should keep 1.5 metres away from others. |
      | TC05 | Ben       | office     | 100   | Use your superhero Social Distance and notify your Manager.                                                  |