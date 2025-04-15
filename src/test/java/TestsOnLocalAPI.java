import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class TestsOnLocalAPI {
    //@Test
    public void get() {
        baseURI = "http://localhost:3000";
        when().get("/users").then().statusCode(200).log().all().
        body("[1].id",equalTo(1));
    }

    //@Test
    public void post() {
        JSONObject request = new JSONObject();
        request.put("name","Alice");
        request.put("email","alice@gmail.com");

        baseURI = "http://localhost:3000";
        //sending JSON, accepting JSON
        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().statusCode(201);
    }

    //@Test
    public void put() {
        JSONObject request = new JSONObject();
        request.put("name","Harsha");
        request.put("email","harsha@gmail.com");

        baseURI = "http://localhost:3000";
        //sending JSON, accepting JSON
        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/0fd6").
                then().statusCode(200);
    }

    //@Test
    public void patch() {
        JSONObject request = new JSONObject();
        request.put("email","harshith12345@gmail.com");

        baseURI = "http://localhost:3000";
        //sending JSON, accepting JSON
        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/0fd6").
                then().statusCode(200);
    }

    @Test
    public void delete() {
        baseURI = "http://localhost:3000";
        //sending JSON, accepting JSON
        when().delete("/users/ofd6").then().statusCode(404);
    }

}
