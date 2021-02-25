package bugred.ru;

import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddAvatar {
    @Test
    public void addAvatar () {
        Response response =
                given().
                        multiPart("avatar",new File("src/test/resources/3f18c5146b3a6a19f0e84d4efabcecae.png")).
                        when().
                        post("http://users.bugred.ru/tasks/rest/addavatar/?email=heramant1@magic.ru").
                        then().
                        statusCode(200).
                        assertThat().body("status",equalTo("ok")).
                        extract().response();
        response.getBody().print();
    }
}
