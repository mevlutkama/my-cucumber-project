package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;

public class DatabaseStepDefinitions {

    @Given("user connects to the application database")
    public void user_connects_to_the_application_database() {
        // Creating database connection by using database utility class(DBUtils)
        DBUtils.createConnection();
    }

    @When("user gets the column {string} from table {string}")
    public void user_gets_the_column_from_table(String columnName, String tableName) {

        // String query = "SELECT * FROM jhi_user";
        String query = "SELECT " + columnName + " FROM " + tableName;
        // Running the query using util class
        DBUtils.executeQuery(query);
    }

    @Then("user reads all column {string} data")
    public void user_reads_all_column_data(String columnName) throws Exception {

        // Using resultSet to get the object from database
        DBUtils.getResultset().next();
        Object object1 = DBUtils.getResultset().getObject(columnName);// getObject() method is used to get the database object
        System.out.println("object1 = " + object1);

        //========================================

        DBUtils.getResultset().next();
        Object object2 = DBUtils.getResultset().getObject(columnName);// getObject() method is used to get the database object
        System.out.println("object2 = " + object2);

        //=======================================

        DBUtils.getResultset().next();
        Object object3 = DBUtils.getResultset().getObject(columnName);// getObject() method is used to get the database object
        System.out.println("object3 = " + object3);

        //=======================================

        DBUtils.getResultset().next();
        Object object4 = DBUtils.getResultset().getObject(columnName);// getObject() method is used to get the database object
        System.out.println("object4 = " + object4);

        int counter = 4;
        while (DBUtils.getResultset().next()){
            Object currentObject = DBUtils.getResultset().getObject(columnName);
            System.out.println("Row " + counter + " data: " + currentObject);
            counter++;
        }

        System.out.println("Row count: " + counter);
        System.out.println("Row count: " + DBUtils.getRowCount());
    }

    @Then("verify table {string} and column {string} contains data {string}")
    public void verify_table_and_column_contains_data(String table, String column, String data) {
        // getting to the table
        String query = "SELECT " + column + " FROM " + table;

        // getting all of the column data and storing in a list
        List<Object> columnData = DBUtils.getColumnData(query, column);
        System.out.println(columnData);
        Assert.assertTrue(columnData.contains(data));
    }
}
