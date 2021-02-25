package bugred.ru;

import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class MagicSearch {
    @Test
    public void magicSearch() {
        Response response =
                given().body("{\n" +
                        "\"query\":\"George Fliguell\"\n" +
                        "}").
                        when().
                        post("http://users.bugred.ru/tasks/rest/magicsearch").
                        then().
                        statusCode(232).
                        assertThat().body("foundCount", equalTo(3)).extract().response();
        response.getBody().print();
    }
}
