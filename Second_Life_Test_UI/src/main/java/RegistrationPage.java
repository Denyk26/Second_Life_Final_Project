import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "[name = 'email']")
    WebElement email;
    @FindBy(css = "[name = 'password']")
    WebElement password;
    @FindBy(css = "[name = 'repeatpassword']")
    WebElement repeatPassword;
    @FindBy(css = "[name = 'firstname']")
    WebElement firstName;
    @FindBy(css = "[name = 'lastname']")
    WebElement lastName;
    @FindBy(css = "[class = 'css-1mk6z5f']")
    WebElement submitButton;
    @FindBy(css = "[class = 'css-d1e3gg']")
    WebElement successButton;

    public void fillInRegistrationForm() {
        fillInputField(email, "loh@gmail.com");
        fillInputField(password, "Vbnm123!");
        fillInputField(repeatPassword, "Vbnm123!");
        fillInputField(firstName, "Dan");
        fillInputField(lastName, "Turuk");
    }

    public void pressRegistrationButton() {
        clickOnElement(submitButton);
    }

    public void pressRegistrationSuccessButton() {
        checkElementIsDisplayed(successButton);
        waitForVisibilityElement(successButton);
        waitForClickableElement(successButton);
        clickOnElement(successButton);
    }

    public void registrationComplete() {
        fillInRegistrationForm();
        pressRegistrationButton();
        pressRegistrationSuccessButton();
    }
}
