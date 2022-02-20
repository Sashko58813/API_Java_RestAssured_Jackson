package boredapi;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@SuppressWarnings("all")
public class BaseBoredApiClass {

    @BeforeSuite
    @Parameters("env")
    public void setup(@Optional("bored") String env) {
        if(env.equalsIgnoreCase("bored")){
            RestAssured.baseURI = "https://www.boredapi.com/api/";
            //System.setProperties("test.env", "bored");
        }
        System.out.println(RestAssured.baseURI);
    }


}
