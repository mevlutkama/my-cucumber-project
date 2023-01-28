@excel_customer_login
Feature: excel_login_feature
  Scenario: TC_customer_credentials_test
    Given user tries to login as "customer_info"
    Then verify the application login is successful
    Then capture the screenshot
    Then close the application

  @admin_excel
  Scenario: TC_admin_credentials_test
    Given user tries to login as "admin_info"
    Then verify the application login is successful
    Then capture the screenshot
    Then close the application

