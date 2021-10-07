@SampleFeature
Feature: Sample Feature file

  @TC01
  Scenario Outline: Validate the login application using excel data driven approach
    Given user has launched "demo_login" page
    When user fills the form from given filename "Sample.xlsx", sheetname "login" and rownumber <RowNumber>
    When user enters "userName" in field "txt_username"
    And user enters "password" in field "txt_password"
    Then validate field "field_passwordHint" contains text "Hint: password is 12345"
    And user clicks "btn_login"
    Then validate page title contains "TestProject Demo"

    Examples: 
      | RowNumber |
      |         0 |
      |         1 |
      |         2 |

  @TC02
  Scenario Outline: Validate the login application for <userName>  using examples data driven approach
    Given user has launched "demo_login" page
    When user enters "<userName>" in field "txt_username" using example
    And user enters "<password>" in field "txt_password" using example
    Then validate field "field_passwordHint" contains text "Hint: password is 12345"
    And user clicks "btn_login"
    Then validate page title contains "TestProject Demo"

    Examples: 
      | userName | password |
      | sam      |    12345 |
      | tom      |    12345 |
      | jerry    |    12345 |
