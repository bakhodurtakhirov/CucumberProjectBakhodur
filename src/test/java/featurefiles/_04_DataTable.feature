Feature: Data Table Example

  Scenario: Data Table with 1 column
    Given Go to the website
    And Fill the form with valid data
      | John               |
      | Snow               |
      | 6214 Winter Ave.   |
      | New York           |
      | New Your City      |
      | 12345              |
      | johnsnow@gmail.com |
      | 6521458962         |
      | Male               |
    Then Save the form

  Scenario: Data Table with 2 columns
    Given Go to the website
    And Enter valid data
      | Name     | John               |
      | Lastname | Snow               |
      | Address  | 6521 Winter Ave.   |
      | City     | New York City      |
      | State    | New York           |
      | Zip Code | 14652              |
      | Email    | johnsnow@gmail.com |
      | Phone    | 6521478542         |
      | Gender   | Male               |
    Then Save the form
