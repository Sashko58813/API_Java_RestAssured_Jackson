package tests;

import boredapi.BoredResponseHandler;
import io.restassured.response.Response;
import listener.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class BoredTests extends BaseClass {

    BoredResponseHandler boredResponseHandler;

    @BeforeMethod
    public void setUpBoredTests() {
        boredResponseHandler = new BoredResponseHandler();
    }

    @Test
    public void boredRandomActivity() {
        Response getRandomActivity = boredResponseHandler.getRandomActivity();
        String activity = getRandomActivity.jsonPath().getString("activity");
        Assert.assertNotNull(activity);
        Log.info("Random activity is " + activity);
    }
}
