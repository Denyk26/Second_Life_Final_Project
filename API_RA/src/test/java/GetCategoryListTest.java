import com.second_life.ResponseForCategoryDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCategoryListTest extends BaseTest {
    ResponseForCategoryDto getCategory = ResponseForCategoryDto.builder()
            .id(1).build();

    @Test
    public void getCategoryListTest(){
        ResponseForCategoryDto dto = given()
                .contentType(ContentType.JSON)
                .body(getCategory)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get("/categories/1")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(ResponseForCategoryDto.class);
        System.out.println(dto);
    }
}
