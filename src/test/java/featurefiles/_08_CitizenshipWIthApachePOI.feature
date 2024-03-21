Feature: Citizenship Function
  #Scenario Outline runs the same with different data sets multiple times

  Background:
    Given Navigate to Campus Web Site
    And Enter username and password
    And Click on Login Button
    And Navigate to Citizenship page

  Scenario: Create a citizenship by getting data from Excel
    Then Create a Citizenship by using ApachePOI
