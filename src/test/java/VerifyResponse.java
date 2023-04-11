import model.Comment;
import model.Post3;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class VerifyResponse {

    @Test
    public void checkTitleAndBodyField() {

        when()
                .get("http://localhost:3000/posts/{postid}", 1)
       .then()
                .log()
                .all()
                .body("title", equalTo("titleAfterUpdate1"))
                .and()
                .body("body", equalTo("bodyAfterUpdate1"));
    }

    @Test
    public void getPostAsObject() {

        Post3 post =
          when()
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

    @Test
    public void getCommentAsObject() {

        Comment comment1 =
                when()
                        .get("http://localhost:3000/comments/{postId}", 1)
                .then()
                        .extract()
                        .body()
                        .as(Comment.class);

        Comment comment2 = new Comment();

        comment2.setBody("some comment");
        comment2.setPostId("1");

        Assert.assertEquals(comment1, comment2);

    }
}
