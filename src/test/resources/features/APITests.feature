Feature: Request response API

  Scenario: Get list of users
    Given Setup API
    When Get list of users
    And Display response body
    Then Verify status as '200'