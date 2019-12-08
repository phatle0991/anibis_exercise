@Login-feature
Feature: Verify Login Features

  Background: Open Login Page
    Given I open Login Page
    Then I verify Login Page loaded successfully

  @LoginPage-Navigation-Scenarios
  Scenario: Cursor is focused on User Email field by default
    Then I verify cursor is focused on User Email field

  @LoginPage-LoginSuccessfully-Scenarios
  Scenario: Customer can login successfully with valid User Email and Password
    When I enter User Email = "$validUserEmail"
    And I click on Login button
    And I enter User Password = "$validPassword"
    Then I verify User Name displayed correctly at Home Page
    
  @LoginPage-UserEmail-Validation-Scenarios
  Scenario Outline: Customer can't login with incorrect User Email or non-Existed User Email
    When I enter User Email = "<userEmail>"
    And I click on Email Validation button
    And I verify User Email error message = "<expectedErrMsg>"
    And I verify User Email error message = "<expectedErrMsg>" color
    Examples:
      |userEmail|expectedErrMsg|
      |buyer.nvg01@gmail.com|                                                                                     |
      |a@gmail.com          |Votre compte d’utilisateur anibis a été supprimé. Veuillez vous adresser à notre service client|
      |aaaaaaaa@gmail.com   |                                                                                               |
      |                     |N’oubliez pas cette information                                                      |
      |aaaaa                |Indiquez votre adresse e-mail                                                        |
      |@                    |Indiquez votre adresse e-mail                                                        |
      |.com                 |Indiquez votre adresse e-mail                                                        |
      |@.com                |Indiquez votre adresse e-mail                                                        |
      |a@.com               |Indiquez votre adresse e-mail                                                        |



