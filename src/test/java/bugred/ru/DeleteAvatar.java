package bugred.ru;

import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAvatar {
    @Test
    public void deleteAvatar() {
        Response response =
                given().
                        when().
                        delete("http://users.bugred.ru/tasks/rest/deleteavatar/?email=heramant1@magic.ru").
                        then().
                        statusCode(200).
                        assertThat().body("status", equalTo("ok")).
                        extract().response();
        response.getBody().print();
    }
}
