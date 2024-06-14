import com.second_life.LogInRequestDto;
import com.second_life.LogInResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogInTest extends BaseTest {

    LogInRequestDto auth = LogInRequestDto.builder()
            .email("barak.obama@email.com")
            .password("Security!234")
            .build();

    @Test
    public void loginSuccessTest() {
        LogInResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("/auth/user/login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(LogInResponseDto.class);
        System.out.println(dto.getAccessToken() + "************************" + dto.getRefreshToken());
    }
}
