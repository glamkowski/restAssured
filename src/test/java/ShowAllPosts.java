import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class ShowAllPosts {

    @Test
    public void getAllPosts() {
        when()
                .get("https://jsonplaceholder.typicode.com/posts")
        .then()
                .log()
                .all();
    }

}
