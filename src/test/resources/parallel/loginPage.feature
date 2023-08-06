Feature: Login

  Scenario:Login Page
    Given user is on login page
    And I verify title should be "Login - My Shop"

  Scenario:Login Page Title Validation
    Given user is on login page
    And I verify title should be "Login - My Show"

  Scenario:Launch Login
    Given user is on login page
    And I enter the emailid "automationharsha7@gmail.com"
    Then I enter Password "Test@123"
    And I click on submit


