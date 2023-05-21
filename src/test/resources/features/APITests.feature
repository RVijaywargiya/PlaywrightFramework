Feature: Request response API

  Background: Setup API

#  Scenario: Get list of users
#    Given I am an authorized user
#    When I get list of users
#    Then Verify users are displayed

  Scenario: Add airline
    Given I am an authorized user
    When I create a new airline
    And Verify airline is added
#    When I remove an airline
#    Then Verify airline is removed