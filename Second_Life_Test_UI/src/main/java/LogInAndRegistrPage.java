import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInAndRegistrPage extends BasePage {

    public LogInAndRegistrPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "[class = 'css-b4sj44']")
    WebElement registrButton;

    public RegistrationPage clickOnRegistration(){
        clickOnElement(registrButton);
        return new RegistrationPage(driver,wait);
    }
}
