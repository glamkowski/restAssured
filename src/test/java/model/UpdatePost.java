package model;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
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
                .put("http://localhost:3000/posts/1")
        .then()
                .log()
                .all();

    }

    @Test
    public void updatePostUsingFile () {

        File updatePost = new File("src/test/resources/updatePost.json");

        given()
                .contentType(ContentType.JSON)
                .body(updatePost)
                .log()
                .body()
        .when()
                .put("http://localhost:3000/posts/1")
        .then()
                .log()
                .ifValidationFails(LogDetail.BODY);

    }

}
