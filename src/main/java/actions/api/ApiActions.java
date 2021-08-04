package actions.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiActions {

    public Response GetUsers(String uri) {

        Response res = given()
                .header("accept", "application/json")
                .get(uri)
                .then().statusCode(200)
                .log()
                .all()
                .extract()
                .response();
        return res;
    }


    public Response PostUser(String uri, JSONObject requestParams) {

        Response res =
                given()
                        .header("accept", "*/*")
                        .contentType(ContentType.JSON)
                        .body(requestParams.toJSONString())
                         .post(uri).then().statusCode(201)
                        //.post(uri).then().statusCode(400)
                        .log()
                        .all()
                        .extract()
                        .response();
        return res;

    }
}
