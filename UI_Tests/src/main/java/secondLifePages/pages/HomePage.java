package secondLifePages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static final String HOME_PAGE_URL = "https://second-life.space/";
    @FindBy(css = "[src = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAvCAYAAACR+4jVAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAGYSURBVHgB7Zk/S8NAGMYfS8FBhIIOIoh1cNEPUVcdHARnxcFBHHRyES041cXFxa+gg6A46yQODiLoJBQcXXRy1edIAv1zSc7kvVzU+8FvaLkkD817lzc9wPPHGYj5fpCOoVhe6ZfJwDp9CQcXaZtOwICWg3CRrd4wFU3AIbij79pVpPNEP2GHGp1OGmAScJPewA6NtHNXUHJ8wLz4gHn5FwFrsIhEwCs6D0voFupbdD9yPpDMOIKQ+/QAJUR1IdHD/oSO/ODYBrqbhePeAdKTZJ3e00kIYWMW1+kdXYAA1fBEDWRHN4tVN67qcg8CdXkIu03oKR2OuXbhNahjme4iI0UEbNIdZETV4Bl9RnaOoK9DtX6u0XM4pnMdjHykUwbHOqnBy/DCbQggGVD9Ak26SN8hhO5ZvIFg5kVs0wcko+pthV5AGF3AGTrX8TmtnVK3cgtB3Ylj8tqZxhLSO57MSNSgtXAK/06SFx8wLz5gXkzWwWs45Ffe4je4o6/J0G1DjCJ4j5hF/DaFNKoTUn81ryLYjvB4SsM3pISTvzRA5UoAAAAASUVORK5CYII=']")
    WebElement doorButton;
    @FindBy(xpath = "//a[@href = '#/auth/user/login']")
    WebElement loginButton;
    public static @FindBy(xpath = "//p[text()='Let your unwanted items find a new home and bring joy to others.']")
    WebElement homePageWords;

    public LogInAndRegistrPage goToLoginPage() {
        clickOnElement(loginButton);
        return new LogInAndRegistrPage(driver, wait);
    }

    public void checkWordsOnHomePage(String message, WebElement element) {
        Assertions.assertEquals(message, element.getText(), "Мы не на главной странице");
    }

    public LogInAndRegistrPage clickOnDoorButton() {
        clickOnElement(doorButton);
        return new LogInAndRegistrPage(driver, wait);
    }
}

