import Files.Payload;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//given - all input details
//when - submit the api - resources, http methods
//then - validate the response

public class Basics {
    public static void main(String[] args) {
        //Validate if Add place api is working as expected
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(Payload.addPlace())
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();

        System.out.println(response);

        //Add place or update place for new address ->
        // Get place to validate if new address present in response
        JsonPath js = new JsonPath(response); //for parsing JSON
        String placeID=js.getString("place_id");
        System.out.println(placeID);

        //update place
        String newAddress = "South Korea";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "    \"place_id\": \""+placeID+"\",\n" +
                        "    \"address\" : \""+newAddress+"\",\n" +
                        "    \"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200)
                .body("msg",equalTo("Address successfully updated"));

        //Get Place
        String getPlaceResponse = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .queryParam("place_id",placeID)
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse);
//         JsonPath js1 = new JsonPath(getPlaceResponse);
        String actualAddress = js1.getString("address");
        Assert.assertEquals(newAddress,actualAddress);

    }
}
