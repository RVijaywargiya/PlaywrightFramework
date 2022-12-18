Feature: Login to sauce labs demo site

  Scenario Outline: Verify successful login to site

    Given User is at login page
    And Enter "<username>" and "<password>"
    When Click on login button
    Then User should be able to login successfully with "<error_message>"
    Examples:
      | username                | password     | error_message                                       |
      | standard_user           | secret_sauce |                                                     |
      | locked_out_user         | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
      | problem_user            | secret_sauce |                                                     |
      | performance_glitch_user | secret_sauce |                                                     |

