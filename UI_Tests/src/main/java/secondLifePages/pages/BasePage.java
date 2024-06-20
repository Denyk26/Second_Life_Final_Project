package secondLifePages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasePage {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    JavascriptExecutor js;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInputField(WebElement e, String value) {
        WebElement element = waitForClickableElement(e);
        element.click();
        element.clear();
        element.sendKeys(value);
        assertEquals(value, element.getAttribute("value"));
    }

    public WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElement(WebElement element) {
        waitForClickableElement(element).click();
    }

    public WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void checkElementIsDisplayed(WebElement element) {
        Assertions.assertTrue(element.isDisplayed(), String.format("Ожидаемы елемент по %s локатору не найден", element.getLocation()));
    }

    public void clickJsElement(WebElement element) {
        js.executeScript("arguments[0].click()", element);
    }

    public static void openUrl(String urlToOpen) {
        driver.get(urlToOpen); // открывает эту ссылку
        assertEquals(driver.getCurrentUrl(), urlToOpen, String.format("Ожидаемый url %s не найден", urlToOpen));// сравниваем текущую ссылку с ожидаемой
    }
    public void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
