@db_read
Feature: db_customer_testing

  Scenario:
    Given user connects to the application database
    #                   SELECT * FROM jhi_user
    When user gets the column "*" from table "jhi_user"
    # Read all of the column names of the customer
    Then user reads all column "login" data
