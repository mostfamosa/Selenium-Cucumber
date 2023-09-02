Feature: Search For Player

  Scenario: Find Player With The Highest Wins
    Given I’m on the NBA site
    When On the stat page - I select Players
    When On the stat page - I sort them by wins
    Then The first player is "Brook Lopez"

  Scenario: Find Player With The Highest Points
    Given I’m on the NBA site
    When On the stat page - I select Players
    When On the stat page - I sort them by points
    Then The first player is "Joel Embiid"

  Scenario Outline: Find Player With The Highest Wins By Season
    Given I’m on the NBA site
    When On the stat page - I select Players
    When I set the filters to season <season>
    And On the stat page - I sort them by wins
    Then The first player is <expectedPlayer>

    Examples:
      | season    | expectedPlayer     |
      | "2020-21" | "Bojan Bogdanovic" |
      | "2019-20" | "Brook Lopez"      |
      | "2009-10" | "Anthony Parker"   |