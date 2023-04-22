Feature: Request response API

  Scenario: Get list of users
    When Get list of users
    And Display response body
    Then Verify status as 200