import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;
import java.io.File;

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
                .log()
                .body();
    }

}
