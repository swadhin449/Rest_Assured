package Files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DynamicJson {
    @Test(dataProvider = "BooksData")
    public  void addBook(String isbn,String asile){
        RestAssured.baseURI = "http://216.10.245.166";

        String response = given().header("Content-Type","application/json")
                .body(Payload.addBookJson(isbn,asile))
                .when().post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = ReusableMethods.rawToJson(response);
        String id = js.getString("ID");
        System.out.println(id);
    }
    @DataProvider(name="BooksData")
    public Object[][] getData(){
        return  new Object[][] {{"abcde","788"},{"vbnb","789"}};
    }
}
