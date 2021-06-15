Feature: feature to test Oyo search functionality

  Scenario Outline: Validate the search button is working with valid input
    Given user is on the oyorooms home page
    When user enters a city name as "<city_name>"
    And user enters a date from next month
    And user clicks on search button
    Then search results should be displayed
    When user clicks on Book Now button
    Then it should be navigated to Enter Details page

    Examples:
      | city_name                   |
      | Kolkata, West Bengal, India |