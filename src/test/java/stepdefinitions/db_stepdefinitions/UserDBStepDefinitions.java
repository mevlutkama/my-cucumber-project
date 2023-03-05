package stepdefinitions.db_stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class UserDBStepDefinitions {

    List<Object> columnList;
    @Given("user connects to database")
    public void user_connects_to_database() {
        DBUtils.createConnection();
    }

    @When("get all {string} as a list from {string}")
    public void getAllAsAListFrom(String columnName, String tableName) {
        String query = "SELECT * FROM " + tableName;
        columnList = DBUtils.getColumnData(query, columnName);
        System.out.println("columnList = " + columnList);
    }

    @Then("verify username list contains {string}")
    public void verify_username_list_contains(String username) {
        assertTrue(columnList.contains(username));
    }

    @And("close the connection")
    public void closeTheConnection() {
        DBUtils.closeConnection();
    }

    @Then("verify list contains {string}")
    public void verifyListContains(String data) {
        assertTrue(columnList.contains(Integer.valueOf(data)));
    }
}
