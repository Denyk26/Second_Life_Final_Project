package secondLifePages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import secondLifePages.core.BasePage;

import static secondLifePages.pages.HomePage.HOME_PAGE_URL;

public class AboutUsPage extends BasePage {

    public AboutUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static final String ABOUT_US_PAGE_URL = HOME_PAGE_URL + "#/aboutUs";
}

