package secondLifeTests.registrationTest;

import org.junit.jupiter.api.Test;
import secondLifeTests.core.BaseTest;

import static secondLifePages.pages.RegistrationPage.*;

public class RegistrationNegativeTest extends BaseTest {
    private static final String EMAIL_FIELD_ERROR_MESSAGE = "Field email required";
    private static final String INVALID_EMAIL_ERROR_MESSAGE = "Please enter a valid email address";
    private static final String PASSWORD_FIELD_ERROR_MESSAGE = "Field password required";
    private static final String INVALID_WITH_NUMBER_PASSWORD_ERROR_MESSAGE = "Password must contain at least one letter";
    private static final String INVALID_WITH_WORD_PASSWORD_ERROR_MESSAGE = "Password must contain at least one digit";
    private static final String PASSWORDS_WITH_NOT_MATCH_ERROR_MESSAGE = "Passwords must match";

    @Test
    void negativeTestEmptyEmail() {
        homePage.clickOnDoorButton()
                .clickOnRegistration()
                .registrationComplete()
                .checkErrorMessage(EMAIL_FIELD_ERROR_MESSAGE, emailFieldErrorMessage);
    }

    @Test
    void negativeTestInvalidEmail() {
        homePage.clickOnDoorButton()
                .clickOnRegistration()
                .registrationComplete()
                .checkErrorMessage(INVALID_EMAIL_ERROR_MESSAGE, invalidEmailErrorMessage);
    }

    @Test
    void negativeTestEmptyPassword() {
        homePage.clickOnDoorButton()
                .clickOnRegistration()
                .registrationComplete()
                .checkErrorMessage(PASSWORD_FIELD_ERROR_MESSAGE, passwordFieldErrorMessage);
    }

    @Test
    void negativeTestInvalidWithNumberPassword() {
        homePage.clickOnDoorButton()
                .clickOnRegistration()
                .registrationComplete()
                .checkErrorMessage(INVALID_WITH_NUMBER_PASSWORD_ERROR_MESSAGE, invalidWithNumbersPasswordErrorMessage);
    }

    @Test
    void negativeTestInvalidWithWordPassword() {
        homePage.clickOnDoorButton()
                .clickOnRegistration()
                .registrationComplete()
                .checkErrorMessage(INVALID_WITH_WORD_PASSWORD_ERROR_MESSAGE, invalidWithWordPasswordErrorMessage);
    }

    @Test
    void negativeTestWithNotMatchingPassword() {
        homePage.clickOnDoorButton()
                .clickOnRegistration()
                .registrationComplete()
                .checkErrorMessage(PASSWORDS_WITH_NOT_MATCH_ERROR_MESSAGE, passwordsWithNotMatchErrorMessage);
    }
}