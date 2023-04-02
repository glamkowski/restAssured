import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddPost {

    @Test
    public void addPostUsingModel() {

        Post newModelPost = new Post("testTitle1", "testComment1");

        given()
                .contentType(ContentType.JSON)
                .body(newModelPost)
                .log()
                .all()
        .when()
                .post("https://jsonplaceholder.typicode.com/posts")
        .then()
                .statusCode(201)
                .log()
                .body();
    }

    @Test
    public void addPostUsingFile () {

        File newFilePost = new File("src/test/resources/newPost.json");

        given()
                .contentType(ContentType.JSON)
                .body(newFilePost)
        .when()
                .post("https://jsonplaceholder.typicode.com/posts")
        .then()
                .statusCode(201)
                .log()
                .all();
    }

    @Test
    public void addPostUsingMap () {

        Map<String, Object> newMapPost = new HashMap<>();
        newMapPost.put("title", "titleMap1");
        newMapPost.put("body", "commentMap1");

        given()
                .body(newMapPost)
                .log()
                .all()
        .when()
                .post("https://jsonplaceholder.typicode.com/posts/1")
         .then()
                .log()
                .ifValidationFails()
                .statusCode(201);

    }

}
