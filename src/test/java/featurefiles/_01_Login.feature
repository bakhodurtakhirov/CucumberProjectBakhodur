Feature: Login Function
  As a user I want to be able to login
  with my valid username and password

  @SmokeTest @FireTest
  Scenario: Login with valid username and password
    Given Navigate to Campus Web Site
    And Enter username and password
    When Click on Login Button
    Then User should login successfully