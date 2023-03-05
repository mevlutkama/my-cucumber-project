@user_db
Feature: User Validation

  Scenario: Validate user by login/username
    Given user connects to database
    When get all "usernames" as a list
    Then verify username list contains "login"