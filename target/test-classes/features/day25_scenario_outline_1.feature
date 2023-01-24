@scenario_outline
Feature: search_feature
  Background: user_goes_to_google_page
    Given user is on the google home page

  Scenario Outline: search_scenario
    When user search for "<search_item>" on google
    Then verify page title contains "<search_item>"
    Then close the application

    Examples: test_data
    | search_item |
    | tesla       |
    | nio         |
    | mercedes    |
    | bmw         |
    | lexus       |

