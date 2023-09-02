Feature: Team Statistics

  Scenario: Find Team With The Highest Wins
    Given I’m on the NBA statistics site
    When On the stat page - I select Teams
    When On the stat page - I sort the teams by wins
    Then The first team is "Milwaukee Bucks"

  Scenario: Find Team With The Highest Points
    Given I’m on the NBA statistics site
    When On the stat page - I select Teams
    When On the stat page - I sort the teams by points
    Then The first team is "Sacramento Kings"

  Scenario Outline: Find Team With The Highest Wins By Season
    Given I’m on the NBA statistics site
    When On the stat page - I select Teams
    When I set the filters on teams to season <season>
    And On the stat page - I sort the teams by wins
    Then The first team is <expectedTeam>

    Examples:
      | season    | expectedTeam          |
      | "2020-21" | "Utah Jazz"           |
      | "2019-20" | "Milwaukee Bucks"     |
      | "2009-10" | "Cleveland Cavaliers" |


  Scenario: Find Teams With Highest Wins For Multiple Seasons
    Given I’m on the NBA statistics site
    When On the stat page - I select Teams
    And I set the filters to the following season:
      | season  |
      | 2018-19 |
      | 2019-20 |
      | 2022-23 |
    And On the stat page - I sort the teams by wins
    Then The first team is "Milwaukee Bucks"