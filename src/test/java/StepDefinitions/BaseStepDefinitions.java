package StepDefinitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojo.AutoCompleteAPIResponse;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseStepDefinitions {

    public static RequestSpecification request;
    public static Response response;
    public final Utils utils = new Utils();
    public final TestDataBuild testDataBuild = new TestDataBuild();

    //  sets Base URI and prints scenario name
    @Before
    public void initializeRequest(Scenario scenario) throws IOException {
        System.out.println("******************************************");
        System.out.println(scenario.getName());
        System.out.println("******************************************");
        request = given().log().all().spec(utils.requestSpecification());
    }

    //   generates requestBody for Async API using POJO
    @Given("Async API payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void setAsyncApiRequestBody(String checkInDate, String checkOutDate, int numberOfAdults, int numberOfKids, String placeId) throws IOException, ParseException {
        request.body(testDataBuild.asyncApiPayload(checkInDate, checkOutDate, numberOfAdults, numberOfKids, placeId));
    }

    //   generates request token
    @And("set request token {string}")
    public void setRequestToken(String token) throws IOException {
        request.header("token", utils.getRequestToken(token));

    }

    //   fetches the API resource based on the API name sent from the feature file
    @When("^call the \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void fetchApiResource(String apiResource, String httpMethod) {
        APIResources resourceAPI = APIResources.valueOf(apiResource);
        if (httpMethod.equalsIgnoreCase("POST")) {
            response = request.when().post(resourceAPI.getResource());
        } else if (httpMethod.equalsIgnoreCase("GET")) {
            response = request.when().get(resourceAPI.getResource());
        }
    }

    //   validates http status code
    @Then("verify response status is {int}")
    public void validateResponseCode(int statusCode) {
        response.then().log().all().extract().response();
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    //   validates given json path is not null
    @And("{string} in response body is not null")
    public void validateNotNullResponseParameter(String responseId) {
        String actual = utils.getJsonPath(response, responseId);
        Assert.assertFalse(actual.isEmpty());
    }

    @And("verify response content type is Json")
    public void validateContentTypeIsJson() {
        response.then().assertThat().contentType(ContentType.JSON);
    }

    //   validates the errorCodes in the error response
    @And("validate the error response {string}")
    public void validateErrorCodes(String errorCode) {
        if (!errorCode.equalsIgnoreCase("")) {
            List<String> actualErrorCodes = utils.getJsonList(response, "errorCodes");
            for (int i = 0; i < actualErrorCodes.size(); i++) {
                if (actualErrorCodes.get(i).equals(errorCode)) {
                    Assert.assertTrue(true);
                }
            }
        }
    }

    @Given("set query parameters in request")
    public void passQueryParameters(Map<String, String> queryParameter) throws IOException {
        Iterator<Map.Entry<String, String>> entryIterator = queryParameter.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> pair = entryIterator.next();
            request = request.queryParam(pair.getKey(), pair.getValue());
        }
    }


}


