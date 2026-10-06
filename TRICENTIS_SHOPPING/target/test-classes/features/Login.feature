Feature: Tricentis Login Functionality

Scenario: Successful Login with valid credentials
  Given the user is on the Login page
  When the user enters valid email "kanikagupta4245@gmail.com" and password "Kan@12345"
  And clicks the login button
  Then the user should be logged in successfully

Scenario Outline: Unsuccessful Login with invalid credentials
  Given the user is on the Login page
  When the user enters invalid email "<email>" and password "<password>"
  And clicks the login button
  Then an error message should be displayed

Examples:
  | email                     | password    |
  | wronguser@tricentis.com   | password123 |
  | testuser123@tricentis.com | wrongpass   |