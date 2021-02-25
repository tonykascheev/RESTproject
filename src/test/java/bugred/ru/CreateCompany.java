package bugred.ru;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateCompany {
    @Test
    public void createCompany() {
        Response response =
                given().
                        contentType("application/json").body
                        ("{\n" +
                                "  \"company_name\": \"Алкоголики и тунеядцы\",\n" +
                                "  \"company_type\": \"ООО\",\n" +
                                "  \"company_users\": [\"trykutnichek@gmail.com\"],\n" +
                                "  \"email_owner\": \"aa+1@mail.com\"\n" +
                                "}").
                        when().
                        post("http://users.bugred.ru/tasks/rest/createcompany").
                        then().
                        statusCode(200).
                        assertThat().body("type", equalTo("success")).
                        extract().response();
        response.getBody().print();
    }
}
