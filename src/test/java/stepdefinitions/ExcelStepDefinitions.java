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
    public void user_tries_to_login_as(String string) throws IOException {

        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
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
