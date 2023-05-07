Feature: Request response API

  Background: Setup playwright

  Scenario: Get list of users
    When Get list of users
    And Display response body
    Then Verify status as 200

  Scenario: Add user
    When Create new user
    And Display response body
    Then Verify status as 201