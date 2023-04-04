import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FilterPosts {

    @Test
    public void filterPostByAuthor() {
        given()
                .queryParam("author", "Oskar")
        .when()
                .get("http://localhost:3000/posts")
        .then()
                .log()
                .body();
    }

    @Test
    public void filterPostById() {
        given()
                .queryParam("id", 1,3)
        .when()
                .get("http://localhost:3000/posts")
        .then()
                .log()
                .body();
    }

    @Test
    public void filterPostsByMap () {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("author", "Oscar");
        queryParams.put("id", "3");

        given()
                .queryParams(queryParams)
        .when()
                .get("http://localhost:3000/posts")
        .then()
                .log()
                .all()
                .statusLine(Matchers.containsString("OK"));
    }

}
