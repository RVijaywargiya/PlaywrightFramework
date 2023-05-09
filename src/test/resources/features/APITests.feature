Feature: Request response API

  Background: Setup API

  Scenario: Get list of users
    Given I am an authorized user
    When I get list of users
    Then Verify users are displayed

  Scenario: Add user
    Given I am an authorized user
    When I create a new user
    And Verify user is added
    When I remove a user
    Then Verify user is removed