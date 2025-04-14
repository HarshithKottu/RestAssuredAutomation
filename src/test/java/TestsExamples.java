import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Here I'm using reqres.in website
            for dummy req and res
              to practice testing*/
public class TestsExamples {
    @Test
    public void test_1() {

        //Response res = RestAssured.get("https://reqres.in/api/users?page=2");
        Response res = get("https://reqres.in/api/users?page=2");
        System.out.println(res.getStatusCode());
        System.out.println(res.getTime());

        //Assertions
        Assert.assertEquals(res.getStatusCode(),200);

    }

    @Test
    public void test_2() {
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data[1].id",equalTo(8));
    }
}
