Feature: Entrance Exams Function

  Background:
    Given Navigate to Campus Web Site
    And Enter username and password
    And Click on Login Button
    And Navigate to Entrance Exams page

  Scenario Outline: Create an Entrance Exam
    And Click on add button
    And Fill the Create Exam form
      | <Exam Name> |
    And Add a Description
      | <Description> |
    And Add a Note
      | <Note> |
    When Click on save button
    Then Success message should be displayed

    Examples:
      | Exam Name        | Description          | Note                 |
      | Batch 10 Exam 11 | Batch 10 is the best | We are coming strong |
#      | Batch 10 Exam 21 | Batch 10 is fun        | We can do it              |
#      | Batch 10 Exam 31 | Batch 10 don't give up | It is too late to give up |

#    ToDo: Write a scenario to delete the exams you have created
#  Scenario Outline: Create an Entrance Exam
#    And Search for the Exam
#      | <Exam Name> |
#    And Click on delete button
#    When Click on delete confirm
#    Then Success message should be displayed
#
#    Examples:
#      | Exam Name        |
#      | Batch 10 Exam 11 |
#      | Batch 10 Exam 21 |
#      | Batch 10 Exam 31 |

#  @SmokeTest
  Scenario Outline: Delete an Entrance Exam
    And Search for the Exam Two
      | <Exam Name> |
    And Click on delete button
    When Click on delete confirm
    Then Success message should be displayed

    Examples:
      | Exam Name        |
      | Batch 10 Exam 11 |
#      | Batch 10 Exam 21 |
#      | Batch 10 Exam 31 |
