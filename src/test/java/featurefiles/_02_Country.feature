Feature: Country Function
  As a user I want to be able to create, update and delete
  different countries,
  so I can register students from different countries

  Background:
    Given Navigate to Campus Web Site
    And Enter username and password
    And Click on Login Button
    And Navigate to Countries page

  @SmokeTest
  Scenario: Create a new Country
    And Click on add button
    And Enter country name and country code
    When Click on save button
    Then Success message should be displayed

  Scenario: Update a Country
    And Search for the country
    And Click on edit button
    And Change the country code
    When Click on save button
    Then Success message should be displayed

  Scenario: Delete a Country
    And Search for the country
    And Click on delete button
    And Click on delete confirm
    Then Success message should be displayed

  Scenario: Create a new Country with parameters
    And Click on add button
    And Enter country "BakhodurLand" and country "BL"
    When Click on save button
    Then Success message should be displayed

    #   ToDo: Create delete country scenario with parameters

  @SmokeTest
  Scenario: Delete a Country with parameters
    And Search for the "BakhodurLand"
    And Click on delete button
    And Click on delete confirm
    Then Success message should be displayed