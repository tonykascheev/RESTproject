package bugred.ru;

import io.restassured.response.Response;
import org.junit.Test;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser {
    @Test
    public void createUser () {
        Response response =
        given().
                contentType("application/json").body
                        ("{\n" +
                                "  \"email\": \"AngryDisgustingWizard@magic.ru\",\n" +
                                "  \"name\": \"Genzel Argue\",\n" +
                                "  \"tasks\": [56],\n" +
                                "  \"companies\": [7, 8]\n" +
                                "}\n").
                when().
                    post("http://users.bugred.ru/tasks/rest/createuser").
                then().
                    statusCode(200).
                assertThat().body("type",equalTo("success")).
                extract().response();
                response.getBody().print();


    }
}
