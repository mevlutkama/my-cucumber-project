@failed_tests
Feature: hooks_test

  Scenario: TC_01_test
    Given user is on "https://www.bluerentalcars.com/login" page
    When user enters customer_email and customer_password
      | username       | password |
      | jack@gmail.com | 12345    |
    Then verify the login page url contains login keyword