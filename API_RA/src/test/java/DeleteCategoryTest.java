import com.second_life.ErrorDto;
import com.second_life.ResponseForCategoryDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteCategoryTest extends BaseTest {


    @Test
    public void deleteCategorySuccessTest() {
        String message = given()
                .header(AUTH, "Bearer " + ADMINTOKEN)
                .when()
                .delete("/categories/2")
                .then()
                .assertThat().statusCode(400)
                .extract().path("message");
        System.out.println(message);
        // .extract().response().as(ResponseForCategoryDto.class);
       // System.out.println(dto.getName());
    }

    @Test
    public void deleteCategoryFailedTest() {
        ErrorDto errorDto = given()
                .header(AUTH, "Bearer " + ADMINTOKEN)
                .when()
                .delete("/categories/101")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
