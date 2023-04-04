import model.Post3;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.when;

public class VerifyResponse {

    @Test
    public void checkTitleField() {

        when()
                .get("http://localhost:3000/posts/{postid}", 1)
                .then()
                .log()
                .all()
                .body("title", Matchers.equalTo("titleAfterUpdate1"))
                .and()
                .body("body", Matchers.equalTo("bodyAfterUpdate1"));
    }

    @Test
    public void getPostAsObject() {
        Post3 post = when()
                .get("http://localhost:3000/posts/{postid}", 10)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .as(Post3.class);

        Assert.assertEquals(post.getId(), "10");
        Assert.assertEquals(post.getAuthor(), "Oskar");
        Assert.assertEquals(post.title, "testTitle1");

    }
}
