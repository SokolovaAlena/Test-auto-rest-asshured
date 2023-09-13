package HomeWork1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static HomeWork1.Configs.URI;
import static HomeWork1.Configs.USER_NAME;

public class DeleteUser {
    private static final String PATH = "/v2/user/";
    private static final String URL = URI + PATH;

    @Test
    public void deleteUser(){
        RequestSpecification request = RestAssured.given();
        Response response = request.delete(URL+USER_NAME);

        int statusCode = 200;
        System.out.println(statusCode);
        Assert.assertEquals(response.statusCode(),statusCode);

        String actualMessage = response.jsonPath().getString("message");
        Assert.assertEquals(USER_NAME, actualMessage);
    }
}
