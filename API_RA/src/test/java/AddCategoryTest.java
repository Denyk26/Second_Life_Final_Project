import com.second_life.ErrorDto;
import com.second_life.RequestDto;
import com.second_life.ResponseForCategoryDto;
import io.restassured.http.ContentType;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class AddCategoryTest extends BaseTest {
    RequestDto addCategory = RequestDto.builder()
            .name("Flowers")
            .description("Red,Blue")
            .build();

    @Test
    public void addCategorySuccess() {
        ResponseForCategoryDto dto = given()
                .header(AUTH, "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTg3OTQ5NTksInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.50gpboNHaZBqMvtk_e4j6M2DE9rrN1TR7olmt03awks")
                .contentType(ContentType.JSON)
                .body(addCategory)
                .when()
                .post("categories")
                .then()
                .assertThat().statusCode(201)
                .extract().response().as(ResponseForCategoryDto.class);
        System.out.println(dto.getName() + " " + dto.getId());
    }

    @Test
    public void addCategoryInvalidInput() {
        ErrorDto errorDto = given().body(ResponseForCategoryDto.builder()
                        .name("Afdsgffhrth")
                        .description("Afhgrgett rthtgwrg gehte!!."))
                .post("/categories")
                .then()
                .assertThat().statusCode(400)
                .body(containsString("Invalid input"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }

    @Test
    public void addCategoryConflict() {
        ErrorDto errorDto = given().body(ResponseForCategoryDto.builder()
                        .name("Electronics and gadgets")
                        .description("Smartphones,Laptops,Televisions,Peripherals"))
                .post("/categories")
                .then()
                .assertThat().statusCode(409)
                .body(containsString("Conflict, category with this name already exists"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
