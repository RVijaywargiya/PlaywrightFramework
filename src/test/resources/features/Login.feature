Feature: Login to sauce labs demo site

  Scenario: Verify successful login to site

    Given User is at login page
    And Enter username and password
    And Click on login button
    Then User should be able to login successfully