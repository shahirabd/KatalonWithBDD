Feature: Login feature

  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters <username> and <password>
    And Click on login button
    Then User is navigated to homepage

    Examples: 
      | username | password           |
      | John Doe | ThisIsNotAPassword |

  Scenario Outline: Login with wrong crendentials
    Given User navigates to login page
    When User enters <username> and <password>
    And Click on login button
    Then Warning message is displayed

    Examples: 
      | username | password   |
      | Jane Doe | testing123 |

  Scenario: Login without entering credentials
    Given User navigates to login page
    And Click on login button
    Then Warning message is displayed
