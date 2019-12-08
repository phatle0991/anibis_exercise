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
