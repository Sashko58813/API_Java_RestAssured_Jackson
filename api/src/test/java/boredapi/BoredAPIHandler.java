package boredapi;

import io.restassured.response.Response;

public interface BoredAPIHandler {
    String activityResource = "/activity";

    Response getRandomActivity();
    Response getActivityByType(String type);
    Response getActivityByParticipants(Integer participants);
}
