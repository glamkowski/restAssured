import org.hamcrest.Matchers;
import org.testng.annotations.Test;

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

}
