Feature: Scenario Outline with Data Table

  Scenario Outline: Scenario 1
    Given Step one
      | Step 1          |
      | <Round Value 1> |
    When Step two
      | Step 2          |
      | <Round Value 2> |
    Then Step three
      | Step 3          |
      | <Round Value 3> |

    Examples:
      | Round Value 1   | Round Value 2   | Round Value 3   |
      | Round 1 Value 1 | Round 1 Value 2 | Round 1 Value 3 |
      | Round 2 Value 1 | Round 2 Value 2 | Round 2 Value 3 |
      | Round 3 Value 1 | Round 3 Value 2 | Round 3 Value 3 |
      | Round 4 Value 1 | Round 4 Value 2 | Round 4 Value 3 |


