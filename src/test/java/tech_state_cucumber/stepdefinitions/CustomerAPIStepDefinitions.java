package tech_state_cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import tech_state_cucumber.apis.ResponseBody;
import tech_state_cucumber.context.TestContext;
import tech_state_cucumber.domainobjects.CustomerPojo;
import tech_state_cucumber.factory.PageFactoryManager;
import tech_state_cucumber.pages.StorePage;
import org.testng.asserts.SoftAssert;

import java.util.*;

import static io.restassured.RestAssured.given;

public class CustomerAPIStepDefinitions {
    private final TestContext context;


    public CustomerAPIStepDefinitions(TestContext context){
        this.context = context;
    }
    CustomerPojo customer = new CustomerPojo();
    private RequestSpecification request;
    private Response response;
    Map<String, Object> customerDataMap = new HashMap<>();
    @Given("I have the data to create customer with {string},{string},{string},{string},{string}")
    public void i_have_the_data_to_create_customer_with(String firstName, String lastName, String phone, String address1, String address2) {

        customerDataMap.put("firstName", firstName);
        customerDataMap.put("lastName", lastName);
        customerDataMap.put("phone", phone);
        List<String> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        customerDataMap.put("addresses", addresses);

    }

    @Given("I use customer header")
    public void i_use_customer_header() {
        request = given()
                .header("Content-Type","application/json")
                .header("Accept-Charset","UTF-8")
                .log()
                .headers();
    }

    @When("I create post request to create customer")
    public void i_create_post_request_to_create_customer() {
        response = request.when()
                .body(customer)
                .post("https://jsonplaceholder.typicode.com/users");
    }

    @Then("I get status code {int} from database")
    public void i_get_status_code_from_database(Integer statusCode) {
        response.then().statusCode(statusCode).log().all();
    }

    @Then("response body should contain")
    public void response_body_should_contain(io.cucumber.datatable.DataTable dataTable) {
       // List<List<String>> tableRows = dataTable.asLists(String.class);
        Map<String, String> responseBodyMap = response.body().as(Map.class, ObjectMapperType.GSON);

        // Iterate over each entry in the customerDataMap
        for (Map.Entry<String, Object> entry : customerDataMap.entrySet()) {
            String key = entry.getKey();
            Object expectedValue = entry.getValue();

            // Check if the response body contains the key
            if (responseBodyMap.containsKey(key)) {
                // Get the value from the response body
                String actualValue = responseBodyMap.get(key);

                // Assert that the actual value matches the expected value
                Assert.assertEquals(actualValue, expectedValue.toString(), "Value for key '" + key + "' does not match");
            } else {
                // Fail the test if the key is not found in the response body
                Assert.fail("Key '" + key + "' is not present in the response body");
            }
        }  }
}

