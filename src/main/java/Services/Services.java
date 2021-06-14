package Services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Services {

    RequestSpecification request;
    Response response;

    public void configureEndPoint(String BASE_URL){
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given();
    }

    public Response getRequest(String resource){
        response = request.get(resource);
        return response;
    }

    public Response postRequest(String resource, JSONObject parameters){
        response = request.body(parameters.toString()).post(resource).then().extract().response();
        return response;
    }
}
