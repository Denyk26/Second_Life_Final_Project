package secondLifePages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import secondLifePages.core.BasePage;

public class LogInAndRegistrPage extends BasePage {

    public LogInAndRegistrPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "[class = 'css-b4sj44']")
    WebElement registrButton;
    @FindBy(css = "[name = 'email']")
    WebElement email;
    @FindBy(css = "[name = 'password']")
    WebElement password;
    @FindBy(css = "[type = 'submit']")
    WebElement submit;
    @FindBy(xpath = "//p[text()='Field email required']")
    public static WebElement fieldEmailRequired;
    @FindBy(xpath = "//p[text()='Field type email']")
    public static WebElement wrongTypeOfEmail;
    @FindBy(xpath = "//p[text()='Field password required']")
    public static WebElement fieldPasswordRequired;
    @FindBy(xpath = "//div[text()='Password is incorrect']")
    public static WebElement wrongPassword;
    @FindBy(xpath = "//div[text()='User not found']")
    public static WebElement userNotFound;



    public void fillInLoginFormAndPressOkButton() {
        fillInputField(email, "lala@gmail.com");
        fillInputField(password, "][Pl;l;'");
        //Negative
        //lala@gmail.com
        //][Pl;l;'
        //Positive
        //lala@gmail.com
        //Prototype26!
        clickOnElement(submit);
        waitInSeconds(2);
    }

    public RegistrationPage clickOnRegistration() {
        clickOnElement(registrButton);
        return new RegistrationPage(driver, wait);
    }

    public void checkErrorMessageByLoginPage(String message, WebElement element) {
        Assertions.assertEquals(message, element.getText(), "Error message is not shown");
    }
}
