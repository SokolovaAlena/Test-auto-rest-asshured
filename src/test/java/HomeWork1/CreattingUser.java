package HomeWork1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static HomeWork1.Configs.URI;
import static HomeWork1.Configs.USER_NAME;

public class CreattingUser {
    private static final String PATH="/v2/user/";
    private static final String URL=URI+PATH;

    @Test
    public void createUser(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id",965457);
        requestBody.put("username",USER_NAME);
        requestBody.put("firstName","Alena");
        requestBody.put("lastName","Sokolova");
        requestBody.put("email","test@test.ru");
        requestBody.put("password","365456");
        requestBody.put("phone","+77788833");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.body(requestBody.toString());
        Response response=request.post(URL);

        int statusCode =response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);

        String expectedMessage=requestBody.get("id").toString();
        String actualMessage=response.jsonPath().getString("message");

        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
