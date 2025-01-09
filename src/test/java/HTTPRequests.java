import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequests {
    int id;
    @Test
    void getUser(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();

    }
    @Test(priority = 1)
    void createUser(){
        HashMap data = new HashMap();
        data.put("name","Swadhin");
        data.put("job","QA Engineer");


        id=given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

//                .then()
//                .statusCode(201)
//                .log().all();

    }
    @Test(priority = 2,dependsOnMethods = "createUser")
    void updateUser(){
        HashMap data = new HashMap();
        data.put("name","Bhubhan");
        data.put("job","Trainer");

        given().contentType("application/json").body(data)

                .when()
                .put("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(200)
                .log().all();

    }
}
