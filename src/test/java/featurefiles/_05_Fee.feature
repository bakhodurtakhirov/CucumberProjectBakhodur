Feature: Fees Function

  Background:
    Given Navigate to Campus Web Site
    And Enter username and password
    And Click on Login Button
    And Navigate to Fees Page

  @FireTest
  Scenario: Add a Fee
    And Click on add button
    And Fill The form out
      | Batch 99 |
      | BTC99    |
      | Bt9      |
      | 999      |
    When Click on Save and Exit Button
    Then Success message should be displayed

  @FireTest
  Scenario: Delete a Fee
    And Search for the Fee
      | Batch 99 |
      | BTC99    |
      | 999      |
    And Click on delete button
    When Click on delete confirm
    Then Success message should be displayed
