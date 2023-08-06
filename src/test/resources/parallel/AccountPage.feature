@acc
Feature: Accounts page


  Background: User is Logged In
    Given User has already logged in to application
      | UserName                    | Password |
      | automationharsha7@gmail.com | Test@123 |


  Scenario: Account Page Launch
    Given Users on accounts page
    Then user get accounts section
      | Add my first address      |
      | Order history and details |
      | My credit slips           |
      | My addresses              |
      | My personal information   |
    And account selection count is 4


