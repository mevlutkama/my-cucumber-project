package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefinitions {

    HomePage homePage;
    LoginPage loginPage;
    ExcelUtils excelUtils;

    // Will store excel data
    List<Map<String,String>> allTestData;

    // 1.Create a login method
    public void login(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(1);

        try {
            homePage.homePageLoginLink.click();
        }catch (Exception e){
        }

        try {
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        ReusableMethods.waitFor(1);
    }
    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String sheet) throws IOException {

        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
        String sheetName = sheet;
        excelUtils = new ExcelUtils(path, sheetName);

        // getDataList() method returns all excel data
        // We stored that data in allTestData variable
        allTestData = excelUtils.getDataList();
        // System.out.println(allTestData);
        // System.out.println(excelUtils.getColumnsNames());
        // System.out.println(excelUtils.getCellData(2,1));

        // Using loop get the values from the map and send in the UI
        for (Map<String, String> eachData : allTestData) {
            // Takes us to the login page
            login();
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(eachData.get("password"));
            ReusableMethods.waitFor(1);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);

            // Verify if login is successfull
            // If user id is displayed then login is successful
            Assert.assertTrue(homePage.userID.isDisplayed());
            ReusableMethods.getScreenshot(eachData.get("username"));
        }
    }

    @Then("capture the screenshot")
    public void capture_the_screenshot() throws IOException {
        ReusableMethods.getScreenshot("screenshot");

    }
}

/*
User Story: Test login functionality of the blue rental car app with 3 credentials
We stored all of the test data in excel
1.Then created feature file:
@excel_customer_login
Feature: excel_login_feature
  Scenario: TC_customer_credentials_test
    Given user tries to login as "customer"
    Then verify the application login is successful
    Then capture the screenshot
    Then close the application
2. Generated the step definitions and wrote the java code
 package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;
import java.io.IOException;
import java.util.List;
import java.util.Map;
public class ExcelStepDefinitions {
    HomePage homePage;
    LoginPage loginPage;
    ExcelUtil excelUtil;
    //    will store excel data
    List<Map<String,String>> allTestData;
    //    1. Create a login method
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage =new LoginPage();
        ReusableMethods.waitFor(1);
        try {
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        try{
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        ReusableMethods.waitFor(1);
    }
    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String string) throws IOException {
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        excelUtil = new ExcelUtil(path, sheetName);
//        getDataList() method returns all excel data
//        we stored that data in allTestData variable
        allTestData = excelUtil.getDataList();
//        System.out.println(allTestData);
//        System.out.println(excelUtils.getColumnsNames());
//        System.out.println(excelUtils.getCellData(2,1));
//        USING LOOP GET THE VALUES FROM THE MAP AND SEND IN THE UI
        for (Map<String, String> eachData : allTestData) {
//            Takes us to the login page
            login();
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(eachData.get("password"));
            ReusableMethods.waitFor(1);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//            Verify if login is successful
//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
            Assert.assertTrue(homePage.userID.isDisplayed());
            ReusableMethods.getScreenshot(eachData.get("username"));
        }
    }
    @Then("capture the screenshot")
    public void capture_the_screenshot() throws IOException {
        ReusableMethods.getScreenshot("screenshot");
    }
}
3. NOTE: we copied the existing JAVA code from test ng
   Because the JAVA sectials are the same
   We also copied the some of the page objects from TestNG
   Because we are using page object model and same website
 */