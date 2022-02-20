package boredapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import listener.Log;
import org.testng.Assert;
import tests.BaseClass;

import static io.restassured.RestAssured.given;

@SuppressWarnings("all")
public class BoredResponseHandler extends BaseClass implements BoredAPIHandler {
    @Override
    public Response getRandomActivity() {
        Log.info("Get random activity");
        Log.info("Endpoint: " + RestAssured.baseURI + BoredAPIHandler.activityResource);
        Response getRandomActivityResponse =
                given()
                        .get(BoredAPIHandler.activityResource)
                        .then()
                        .extract().response();
        try {
            Assert.assertEquals(getRandomActivityResponse.statusCode(), 200);
            Log.info("Random activity retrieved successfully");
            Log.info("Response body: \n" + getRandomActivityResponse.getBody().asString());
            return getRandomActivityResponse;

        } catch (AssertionError e) {
            Log.info("Get random activity failed with status code of: " + getRandomActivityResponse.statusCode());
            Log.info("Response body: \n" + getRandomActivityResponse.getBody().asString());
            Assert.assertEquals(getRandomActivityResponse.statusCode(), 200);
            return getRandomActivityResponse;
        }
    }

    @Override
    public Response getActivityByType(String type) {
        return null;
    }

    @Override
    public Response getActivityByParticipants(Integer participants) {
        return null;
    }
}
