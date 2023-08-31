Feature: Search By Bar
  Scenario: Go to Downloads Page From The Bar
Given I’m on the Selenium site
When On the bar - I click "Downloads"
Then I’m on the "Downloads" page

  Scenario: Go to Projects Page From The Bar
    Given I’m on the Selenium site
    When On the bar - I click "Projects"
    Then I’m on the "Projects" page