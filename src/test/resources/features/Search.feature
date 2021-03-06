@Search-feature
Feature: Verify Search Features

  Background: Open Search Page
    Given I open Search Page
    Then I verify Search Page loaded successfully


  @SearchPage-Search-Scenarios
  Scenario: Customer Can Search With Filter
    When I select Search Category = "Immobilier"
    And I fill out Location = "Zurich"
    And I select Distance = "10 km"
    And I click on Apply Location button
    And I fill out Price From = "1000"
    And I fill out Price To = "5000"
    And I click on Apply Price button
    Then I verify default page = 1
    Then I verify Search Result default items

  @SearchPage-Sort-Scenarios
  Scenario: Verify Sort feature in Search Result
    When I select sort = "Plus récentes d'abord"
    Then I verify sort = "Plus récentes d'abord" result
    When I select sort = "Prix croissant"
    Then I verify sort = "Prix croissant" result
    When I select sort = "Prix décroissant"
    Then I verify sort = "Prix décroissant" result


