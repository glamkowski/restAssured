import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import model.Post2;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdatePost {

    @Test
    public void updatePostUsingModel () {

        Map<String, Object> bodyToUpdate = new HashMap<>();
        bodyToUpdate.put("title", "titleAfterUpdate1");
        bodyToUpdate.put("body", "bodyAfterUpdate1");

        given()
                .contentType(ContentType.JSON)
                .body(bodyToUpdate)
        .when()
                .put("http://localhost:3000/posts/{postId}", 1)
        .then()
                .log()
                .all();

    }

    @Test
    public void updatePostUsingFile () {

        File updatePost = new File("src/test/resources/updatePost.json");

        given()
                .pathParam("postId", 1)
                .contentType(ContentType.JSON)
                .body(updatePost)
                .log()
                .body()
        .when()
                .put("http://localhost:3000/posts/{postId}")
        .then()
                .log()
                .ifValidationFails(LogDetail.BODY);

    }

    @Test
    public void updatePostUsingModelSkippingNull () {

        Post2 postWithNull = new Post2();
        postWithNull.setTitle("titleWithoutBody1");

        given()
                .pathParam("postId", 1)
                .contentType(ContentType.JSON)
                .body(postWithNull)
        .when()
                .put("http://localhost:3000/posts/{postId}")
        .then()
                .log()
                .body();

    }

    @Test
    public void updatePostUsingPatch () {

        Post2 postToPatch = new Post2();
        postToPatch.setTitle("titleAfertPatch1");

        given()
                .contentType(ContentType.JSON)
                .body(postToPatch)
        .when()
                .patch("http://localhost:3000/posts/{postId}", 1)
        .then()
                .log()
                .body();
    }

}
