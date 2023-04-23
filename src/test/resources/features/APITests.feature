Feature: Request response API

#  Scenario: Get list of users
#    When Get list of users
#    And Display response body
#    Then Verify status as 200

  Scenario: Add user
    When User makes a post call
    And Display response body
    Then Verify status as 201