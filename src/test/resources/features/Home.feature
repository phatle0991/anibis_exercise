@HomePage-feature
  Feature: Verify HomePage

    Background: Open Home Page
      Given I open Home Page
      Then I verify Home Page loaded successfully

    @Homepage-Navigate-LoginPage-Scenarios
    Scenario: Customer can navigate to Login Page successfully
      When I click on Login Link
      Then I verify Login Page loaded successfully

    @Homepage-Navigate-SearchPage-Scenarios
    Scenario: Customer can navigate to Search Page successfully
      When I click on Search Button from Home Page
      Then I verify Search Page loaded successfully

    @Homepage-Navigate-UserPage-Scenarios
    Scenario: Customer can navigate to User Page successfully
      When I click on Login Link
      When I enter User Email = "$validUserEmail"
      And I click on Email Validation button
      And I enter User Password = "$validPassword"
      And I click on Login button
      When I navigate to User Default Page from Home Page
      Then I verify User Default Page loaded successfully
      When I navigate to User Account Page from User Default Page
      Then I verify User Account Page loaded successfully
