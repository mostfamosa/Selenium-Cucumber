Feature: Search By SideMenu
  Scenario: Go to WebDriver Page
Given I’m on the Selenium documentation site
When On the sidebar - I click "WebDriver"
Then I’m on the "WebDriver" documentation page

  Scenario: Go to Overview Page
    Given I’m on the Selenium documentation site
    When On the sidebar - I click "Overview"
    Then I’m on the "Overview" documentation page

  Scenario: Go to Grid Page
    Given I’m on the Selenium documentation site
    When On the sidebar - I click "Grid"
    Then I’m on the "Grid" documentation page