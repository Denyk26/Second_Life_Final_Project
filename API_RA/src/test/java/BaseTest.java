import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static final String TOKEN = "eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTg4ODg1MDIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.B5o2KbR2nE2AJyZZAKbGrBzFqoOfrHpYNED5fdZBChY";
    public static final String ADMINTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTg5OTgyMzgsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.jIoCWKTx3S_DMSR6pmYWtLejB6mIf_0RCEAljzEDE2U";
    public static final String AUTH = "Authorization";

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "https://second-life-app-y2el9.ondigitalocean.app/api";
        RestAssured.basePath = "v1";
    }
}
