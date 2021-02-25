package bugred.ru;

import io.restassured.response.Response;
import org.junit.Test;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserWithTasks {
    @Test
    public void createUserWithTask () {
        given().
                contentType("{\n" +
                        " \"email\": \"dangobango@tetris.ru\",\n" +
                        " \"name\": \"Leonard Shepard\",\n" +
                        " \"tasks\": [{\n" +
                        "   \"title\": \"Первая задача\",\n" +
                        "   \"description\": \"Первая задача 11\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "   \"title\": \"Вторая задача\",\n" +
                        "   \"description\": \"Вторая задача 11\"\n" +
                        "  }\n" +
                        " ]\n" +
                        "}").
                when().
                post("http://users.bugred.ru/tasks/rest/createuser").
                then().
                statusCode(200).
                assertThat().body("type",equalTo("success"));
        Response response = post("http://users.bugred.ru/tasks/rest/createuser");
        LOGGER.info("New post has been added" + "\n" + response.getBody().asString());

    }
}
