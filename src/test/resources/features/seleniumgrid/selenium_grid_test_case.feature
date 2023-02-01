@grid_feature
Feature: grid_feature

  @grid_chrome
  Scenario: TC01_running_tests_on_Chrome
    Given user is on the application_url using chrome
    Then verify the page title contains "Techpro Education"
    Then close application

  @grid_firefox
  Scenario: TC02_running_tests_on_Firefox
    Given user is on the application_url using firefox
    Then verify the page title contains "Techpro Education"
    Then close application


