Feature: States Function Database Test

  Check if all state names from UI are in the Database

  Scenario: Check if the data is correct
    Given Navigate to Campus Web Site
    And Enter username and password
    And Click on Login Button
    And Navigate to States Page
    When Send "select name from states" as query
    Then Check if the results from UI are in the database