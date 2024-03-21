Feature: Citizenship Function
  #Scenario Outline runs the same with different data sets multiple times

  Background:
    Given Navigate to Campus Web Site
    And Enter username and password
    And Click on Login Button
    And Navigate to Citizenship page

  Scenario Outline: Create a citizenship
    And Click on add button
    And Enter "<CitizenshipName>" and "<CitizenshipShortName>"
    When Click on save button
    Then Success message should be displayed

    Examples: Data for creating citizenship
      | CitizenshipName | CitizenshipShortName |
      | BakhodurLand1   | BL1                  |
      | BakhodurLand2   | BL2                  |
      | BakhodurLand3   | BL3                  |
      | BakhodurLand4   | BL4                  |

     # Create delete citizenship scenario with scenario outline and delete the citizenships you have created

  Scenario Outline: Delete a citizenship
    And Search for the "<CitizenshipName>"
    And Click on delete button
    And Click on delete confirm
    Then Success message should be displayed

    Examples: Data for creating citizenship
      | CitizenshipName |
      | BakhodurLand1   |
      | BakhodurLand2   |
      | BakhodurLand3   |
      | BakhodurLand4   |
