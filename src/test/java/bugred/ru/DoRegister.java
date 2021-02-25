package bugred.ru;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class DoRegister {
    String name = "Joseph Stafflin";
    @Test
    public void doRegister () {
        Response response =
                given().
                        contentType("application/json").body
                        ("{\n" +
                                "    \"email\": \"participant21@secta.ru\",\n" +
                                "    \"name\":" +name+",\n" +
                                "    \"password\": \"24\"\n" +
                                "}").
                        when().
                        post("http://users.bugred.ru/tasks/rest/doregister").
                        then().
                        statusCode(200).
                        assertThat().body("name",equalTo(name)).
                        extract().response();
        response.getBody().print();
    }
}
