@user_db
Feature: User Validation

  Scenario: Validate user by login/username
    Given user connects to database
    When get all "login" as a list from "jhi_user"
    Then verify username list contains "john_doe"
    And close the connection