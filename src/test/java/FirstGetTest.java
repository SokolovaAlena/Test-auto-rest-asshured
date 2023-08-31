import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class FirstGetTest {
    private static final String URL ="https://postman-echo.com/get?foo1=bar1&foo2=bar2";
    @Test
    public void postmanFirstGetTest(){

        RestAssured.
                when().get(URL).
                then().assertThat().statusCode(201).
                and().body("args.foo2", is("bar2"));
    }
}
