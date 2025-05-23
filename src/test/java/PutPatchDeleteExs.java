import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class PutPatchDeleteExs {
    @Test
    public void testPut() {

        //Using JSONObject
        JSONObject request = new JSONObject();
        request.put("name","Raghav");
        request.put("job","Teacher");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testPatch() {

        //Using JSONObject
        JSONObject request = new JSONObject();
        request.put("name","Raghav");
        request.put("job","Teacher");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testDelete() {
        baseURI = "https://reqres.in/api";
        when().
                delete("/users/2").
        then().
                statusCode(204).
                log().all();
    }
}
