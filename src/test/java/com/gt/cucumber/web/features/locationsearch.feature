Feature: locationsearch

  Scenario: Search with the location
    Given User click on the homepage
    And Select the random province and district
    And User click the select location
    When User write the search box 'ayakkabı'
    And User click search button
    Then Verify location