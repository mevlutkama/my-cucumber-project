@blue_rental
Feature: blue_rental_manager_login
  Scenario Outline: US167854_manager_login_test

    Given user is on "https://www.bluerentalcars.com/" page
    When user navigates to the login page
    And enter "<username>" for username
    And enter "<password>" for password
    And click on login button
    Then verify the login is successful
    Then close the application

    Examples: test_datas
    | username                        | password  |
    | sam.walker@bluerentalcars.com   | c!fas_art |
    | kate.brown@bluerentalcars.com   | tad1$Fas  |
    | raj.khan@bluerentalcars.com     | v7Hg_va^  |
    | pam.raymond@bluerentalcars.com  | Nga^g6!   |