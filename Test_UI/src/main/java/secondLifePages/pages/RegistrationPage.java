package secondLifePages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import secondLifePages.core.BasePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @FindBy(xpath = "//div[text()='Registration successful. Please sign in.']")
    public static WebElement successRegistration;
    @FindBy(xpath = "//p[text()='Field email required']")
    public static WebElement emailFieldErrorMessage;
    @FindBy(xpath = "//p[text()='Please enter a valid email address']")
    public static WebElement invalidEmailErrorMessage;
    @FindBy(xpath = "//p[text()='Field password required']")
    public static WebElement passwordFieldErrorMessage;
    @FindBy(xpath = "//p[text()='Password must contain at least one letter']")
    public static WebElement invalidWithNumbersPasswordErrorMessage;
    @FindBy(xpath = "//p[text()='Password must contain at least one digit']")
    public static WebElement invalidWithWordPasswordErrorMessage;
    @FindBy(xpath = "//p[text()='Passwords must match']")
    public static WebElement passwordsWithNotMatchErrorMessage;


    private void fillInRegistrationForm() {
        fillInputField(email, "deniss@gam.com");
        fillInputField(password, "Aghjb23!");
        fillInputField(repeatPassword, "Aghjb2");
        fillInputField(firstName, "Katja");
        fillInputField(lastName, "Tasfghg");
    }

    public RegistrationPage registrationComplete() {
        fillInRegistrationForm();
        pressRegistrationButton();
        return new RegistrationPage(driver, wait);
    }

    private void pressRegistrationButton() {
        clickOnElement(submitButton);
    }

    public void pressRegistrationSuccessButton() {
        checkElementIsDisplayed(successButton);
        clickOnElement(successButton);
    }

    public RegistrationPage checkLocator(WebElement element, String text) {
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), text);
        return new RegistrationPage(driver, wait);
    }

    public void checkErrorMessage(String message, WebElement element) {
        Assertions.assertEquals(message, element.getText(), "Ошибка не вывелась на экран");
    }
}
