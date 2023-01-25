@data_tables
Feature: data_tables

  Scenario Outline: TC_Create _And verify the test data creation

    # Creating a reusable step that accept url and goes to that url
    Given user is on "https://editor.datatables.net/" page
    When user clicks on the new button
    And user enters the first name "<firstname>"
    And user enters the last name "<lastname>"
    And user enters the position "<position>"
    And user enters office "<office>"
    And user enters extension "<extension>"
    And user enters start date "<start_date>"
    And user enters the salary "<salary>"
    And click on create button
    And search for the first name "<firstname>"
    Then verify the name field contains the first name "<firstname>"
    And close the application

    Examples: test_data
    | firstname | lastname | position  | office | extension | start_date | salary |
    | john      | smith    |tester     |NYC     |2134       |2023-01-23  |80000   |
    | sam       | walton   |businessman|LA      |5262       |2023-01-24  |2000000 |
    | nancy     | brown    |developer  |Dallas  |2346       |2023-01-25  |85000   |
    | george    | bush     |politician |Dallas  |9931       |2023-01-26  |985000  |


