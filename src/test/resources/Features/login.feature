#Selenium Behavior Driven-Development Example
#Author: Lucas Magnani Vikar Theodoro

Feature: Login Functionality
  In order to test the login functionality of "osagilista.com", the following aspects will be considered:
  -Validate common flow (login/logout).
  -Proper validations of "Full Name/E-Mail" and "Password" fields.
  -"Remember me" button functionality.
  -"Forgot your password?" button functionality.

  Background:
    Given user is at the Login Page
    And user can observe login fields and login button

  @ExpectedSuccessfulLoginFlow
  Scenario Outline: User Successfully logs in with valid credentials
    When the user inserts a "<username>" into the username textbox
    And the user inserts a "<password>" into the password textbox
    And the user clicks on LOGIN button
    Then the user should navigate to Users Page

    Examples:
      | username  | password  |
      | Qa Tester Analyst One | QATESTER1  |

  @ExpectedSuccessfulLogoutFlow
  Scenario Outline: User successfully logs out
    Given user has valid credentials: "<username>" and "<password>" and is logged in
    And the user clicks on LOGIN button
    And the user hover on PROFILE icon
    And the user clicks on LOGOUT button
    Then the user should navigate to Confirmation Page
    And click on LOGOUT CONFIRMATION button
    And the user should navigate to Home Page

    Examples:
      | username  | password  |
      | Qa Tester Analyst Two | QATESTER2  |

  @ExpectedUnsuccessfulLoginFlow
  Scenario Outline: User unsuccessfully logs in with invalid credentials
    When the user inserts a "<username>" into the username textbox
    And the user inserts a "<password>" into the password textbox
    And the user clicks on LOGIN button
    Then system displays an error message indicating incorrect credentials

    Examples:
      | username        | password |
      | invalid@login.com | Invalidpass     |

  @ExpectedMessageFromMandatoryFieldName
  Scenario: User unsuccessfully logs in with no name field filled
    When the user inserts a "QATESTER2" into the password textbox
    And the user clicks on LOGIN button
    Then the system reminds the user to fill in the required Name field

  @ExpectedMessageFromMandatoryFieldPassword
  Scenario: User unsuccessfully logs in with no password field filled
    When the user inserts a "Qa Tester Analyst One" into the username textbox
    And the user clicks on LOGIN button
    Then the system reminds the user to fill in the required Password field

  @ExpectedSuccessfulLoginWithRememberMeOptionChecked
  Scenario: User successfully logs in with "Remember me" option checked
    Given user has valid credentials: "Qa Tester Analyst Two" and "QATESTER2" and is logged in
    When user clicks on REMEMBER ME button
    And the user clicks on LOGIN button
    Then the user should navigate to Users Page

  @ExpectedSuccessfulRememberMeFunction
  Scenario: System successfully remember users credentials
    Given user is at the Login Page
    Then the system remembers that user is still logged in

  @ExpectedSuccessfullRequestLostPasswordFunction
  Scenario: User successfully requests "forgot the password" functionality
    Given user is at the Login Page
    And user clicks on FORGOT YOUR PASSWORD button
    Then user navigate to lost password page
    And user insert valid credential: "Qa Tester Analyst Two"
    And user clicks on GET NEW PASSWORD
    Then the system displays a recover password message