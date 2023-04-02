import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RemovePost {

    @Test
    public void removePost () {
        given()
                .pathParam("postId", 4)
        .when()
                .delete("http://localhost:3000/posts/{postId}")
        .then()
                .log()
                .body();
    }


}
