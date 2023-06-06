Feature: Request response API

  Background: Setup API

Scenario: Get airlines
  Given I am an authorized user
  When I get airline details
  Then I should see airline details

#  Scenario: Add airline
#    Given I am an authorized user
#    When I create a new airline
#    And Verify airline is added