import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ShowSpecyficPost {

    @Test
    public void showPost () {

        given()
                .pathParam("postId", 4)
        .when()
                .get("http://localhost:3000/posts/{postId}")
        .then()
                .log()
                .all();
    }

}
