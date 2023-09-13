package HomeWork1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static HomeWork1.Configs.URI;
import static HomeWork1.Configs.USER_NAME;
import static org.hamcrest.Matchers.is;

public class GettingUserByUserName {

    private static final String PATH="/v2/user/";
    private static final String URL=URI+PATH+USER_NAME;

    @Test
    public void getUserbyUserName(){
        System.out.println("Полученный урл  "+ URL);

       RestAssured.
               when().get(URL).
               then().assertThat().statusCode(200).
               and().body("id", is(965457)).
                and().body("username", is(USER_NAME))
       ;
   }
}
