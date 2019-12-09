@UserAccount-feature
Feature: Verify User Account Feature

  Background: Open Search Page
    Given I open Login Page
    Then I verify Login Page loaded successfully
    When I enter User Email = "$validUserEmail"
    And I click on Email Validation button
    And I enter User Password = "$validPassword"
    And I click on Login button

  @UserAccountPage-Loggedin-ValidInfo-Scenarios
  Scenario: Customer can login successfully with valid User Email and Password
    When I navigate to User Default Page from Home Page
    Then I verify User Default Page loaded successfully
    When I navigate to User Account Page from User Default Page
    Then I verify User Account Page loaded successfully
    And I verify User Logged In information with Expected User Name = "$validUserName" and User Email = "$validUserEmail"