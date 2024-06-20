package secondLifeTests.registrationTest;

import org.junit.jupiter.api.Test;
import secondLifeTests.core.BaseTest;

import static secondLifePages.pages.RegistrationPage.successRegistration;

public class RegistrationPositiveTest extends BaseTest {

    private static final String SUCCESS_MESSAGE = "Registration successful. Please sign in.";

    @Test
    void positiveTest() {
        homePage.clickOnDoorButton()
                .clickOnRegistration()
                .registrationComplete()
                .checkLocator(successRegistration, SUCCESS_MESSAGE)
                .pressRegistrationSuccessButton();
    }
}
