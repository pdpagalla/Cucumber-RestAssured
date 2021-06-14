package StepDefinitions;

import Services.Services;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;


public class Steps extends Services {

    String resource;
    Response response;

    @Given("I configure base url for the users request")
    public void i_configure_base_url_for_the_users_request() {
        configureEndPoint("https://jsonplaceholder.typicode.com/");
        resource = "users";
    }

    @When("I send POST request for make post")
    public void i_send_POST_request_for_make_post() {
        JSONObject parameters = new JSONObject();
        parameters.put("userId", "1");
        parameters.put("title", "test title");
        parameters.put("body", "test body");
        response = postRequest(resource, parameters);
        System.out.println(response.asString());
    }

    @When("I send POST request for make comment")
    public void i_send_POST_request_for_make_comment() {
        JSONObject parameters = new JSONObject();
        parameters.put("postId", "1");
        parameters.put("name", "test name");
        parameters.put("email", "tEliseo@gardner.biz");
        parameters.put("body", "test body");
        response = postRequest(resource, parameters);
        System.out.println(response.asString());
    }

    @Then("I verify id is returned in response")
    public void i_verify_id_is_returned_in_response(){
        Assert.assertNotNull(response.getBody().jsonPath().get("id"));
    }

    @Then("I verify response parameters for get users")
    public void i_verify_response_parameters_for_get_users(){
        Assert.assertNotNull(response.getBody().jsonPath().get("id").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("name").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("username").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("email").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("address").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("phone").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("website").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("company").toString());
    }

    @Then("I verify response parameters for get posts")
    public void i_verify_response_parameters_for_get_posts(){
        Assert.assertNotNull(response.getBody().jsonPath().get("userId").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("id").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("title").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("body").toString());
    }

    @Then("I verify response parameters for get comments")
    public void i_verify_response_parameters_for_get_comments(){
        Assert.assertNotNull(response.getBody().jsonPath().get("postId").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("id").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("name").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("email").toString());
        Assert.assertNotNull(response.getBody().jsonPath().get("body").toString());
    }

    @When("I send GET request")
    public void i_send_GET_request() {
       response = getRequest(resource);
       System.out.println(response.asString());
    }

    @Then("I verify status code to be {int}")
    public void i_verify_status_code_to_be(int status_code) {
        Assert.assertEquals(response.statusCode(),status_code);
    }

    @Given("I configure base url for the posts request")
    public void i_configure_base_url_for_the_posts_request() {
        configureEndPoint("https://jsonplaceholder.typicode.com/");
        resource = "posts";
    }

    @Given("I configure base url for the comments request")
    public void i_configure_base_url_for_the_comments_request() {
        configureEndPoint("https://jsonplaceholder.typicode.com/");
        resource = "comments";
    }

    @Given("I configure base url for the users request with invalid resource")
    public void i_configure_base_url_for_the_users_request_invalid() {
        configureEndPoint("https://jsonplaceholder.typicode.com/");
        resource = "use";
    }

}
