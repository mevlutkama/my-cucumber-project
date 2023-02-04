@db_read
Feature: db_customer_testing
  Background: user_connects_database
    Given user connects to the application database

  Scenario: TC01_read_customer_login_info
      #                   SELECT * FROM jhi_user
    When user gets the column "*" from table "jhi_user"
    # Read all of the column names of the customer
    Then user reads all column "login" data


  Scenario: TC02_read_customer_firstname_info
      #                   SELECT * FROM jhi_user
      When user gets the column "*" from table "jhi_user"
    # Read all of the first names of the customer
      Then user reads all column "first_name" data

  Scenario: TC03_read_customer_email_info
      #                   SELECT * FROM tp_customer
    When user gets the column "*" from table "tp_customer"
    # Read all of the email of the customer
    Then user reads all column "email" data

#    PRINT THE ACCOUNT TYPES OF THE CUSTOMERS FROM ACCOUNT TABLE
    Scenario: TC04_read_customer_account_types
      And user gets the column "*" from table "tp_account"
      Then user reads all column "account_type" data

#    TEST ACCOUNT TABLE ACCOUNT_TYPE COLUMN CONTAINS 4 ACCOUNT TYPES: CREDIT_CARD,SAVING,CHECKING,INVESTING
  Scenario Outline: TC05_verify_account_types
    And user gets the column "*" from table "tp_account"
    Then verify table "<table>" and column "<column>" contains data "<data>"

    Examples: account_types
    | table      | column       | data        |
    | tp_account | account_type | CREDIT_CARD |
    | tp_account | account_type | SAVING      |
    | tp_account | account_type | CHECKING    |
    | tp_account | account_type | INVESTING   |

    # test if anonymoususer, chantay.grant, tyron.towne logins created in the user table
  Scenario Outline: TC06_verify_user_login
    And user gets the column "*" from table "jhi_user"
    Then verify table "<table>" and column "<column>" contains data "<data>"

    Examples: account_types
      | table      | column       | data          |
      | jhi_user   | login        | anonymoususer |
      | jhi_user   | login        | chantay.grant |
      | jhi_user   | login        | tyron.towne   |

    #    Test if the following user emails are created : breanna.ryan@yahoo.com,cuppptan@gmail.com,jordy.lynch@hotmail.com
  Scenario Outline: TC07_verify_user_emails
    And user gets the column "*" from table "jhi_user"
    Then verify table "<table>" and column "<column>" contains data "<data>"

    Examples: account_types
      | table      | column       | data                    |
      | jhi_user   | email        | breanna.ryan@yahoo.com  |
      | jhi_user   | email        | cuppptan@gmail.com      |
      | jhi_user   | email        | jordy.lynch@hotmail.com |








