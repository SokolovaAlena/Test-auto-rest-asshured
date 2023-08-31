import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class FirstPostTest {

    private static final String URL = "https://webhook.site/f7b8919e-248c-402c-a532-4d79b4cc4f14";
    @Test
    public void postRequestExampleTest(){

        String randomData = String.format("%1$TH%1$TM%1$TS", new Date()); //форматирует дату

        JSONObject requestBody = new JSONObject();
        requestBody.put("FirstName", randomData);
        requestBody.put("LastName", randomData);
        requestBody.put("UserName", randomData);
        requestBody.put("Password", randomData);
        requestBody.put("Email", randomData+"@gmail.com");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.body(requestBody.toString());

        Response response=request.post(URL);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);

        System.out.println("The status code recieved: " + statusCode);


    }
}
