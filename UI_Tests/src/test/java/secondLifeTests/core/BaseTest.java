package secondLifeTests.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import secondLifePages.pages.HomePage;
import secondLifePages.pages.LogInAndRegistrPage;
import secondLifePages.pages.RegistrationPage;

import java.time.Duration;

public class BaseTest {
    public static final String URL_SECOND_LIFE = "https://second-life.space/";
    public static WebDriver driver;
    public WebDriverWait wait;
    public static HomePage homePage;
    public static LogInAndRegistrPage logInAndRegistrPage;
    public static RegistrationPage registrationPage;


    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver, wait);
        logInAndRegistrPage = new LogInAndRegistrPage(driver, wait);
        registrationPage = new RegistrationPage(driver,wait);
        driver.get(URL_SECOND_LIFE);
    }

    @AfterEach
    void afterVoid() {
        driver.quit();
    }
}
