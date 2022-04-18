Feature: Appointment feature

  Scenario Outline: Make appointment
    Given User is logged with <username> and <password>
    When User is navigated to Make Appointment page
    And User selects the <Facility>
    And sets the readmission checkbox to <readmission-yes>
    And selects the Healthcare program <program>
    And enters the visit date <date>
    And enters the comment <comment>
    And click on the Book Appointment button
    Then user is navigated to Appointment Confirmation page

    Examples: 
      | username | password           | Facility                     | readmission-yes | program  | date       | comment   |
      | John Doe | ThisIsNotAPassword | Tokyo CURA Healthcare Center | No              | Medicaid | 02/05/2022 | scenario2 |
      | John Doe | ThisIsNotAPassword | Seoul CURA Healthcare Center | Yes             | None     | 02/05/2022 | scenario3 |
