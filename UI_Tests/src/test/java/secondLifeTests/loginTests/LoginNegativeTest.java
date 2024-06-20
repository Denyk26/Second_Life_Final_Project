package secondLifeTests.loginTests;

import org.junit.jupiter.api.Test;
import secondLifeTests.core.BaseTest;

import static secondLifePages.pages.LogInAndRegistrPage.*;

public class LoginNegativeTest extends BaseTest {
    private static final String NO_EMAIL_MESSAGE = "Field email required";
    private static final String FIELD_TYPE_EMAIL = "Field type email";
    private static final String NO_PASSWORD_MESSAGE = "Field password required";
    private static final String WRONG_PASSWORD_MESSAGE = "Password is incorrect";
    private static final String USER_NOT_FOUND_MESSAGE = "User not found";


    @Test
    void negativeNoEmailTest() {
        homePage.goToLoginPage();
        logInAndRegistrPage.fillInLoginFormAndPressOkButton();
        logInAndRegistrPage.checkErrorMessageByLoginPage(NO_EMAIL_MESSAGE, fieldEmailRequired);
    }

    @Test
    void negativeTestWrongTypeEmailTest() {
        homePage.goToLoginPage();
        logInAndRegistrPage.fillInLoginFormAndPressOkButton();
        logInAndRegistrPage.checkErrorMessageByLoginPage(FIELD_TYPE_EMAIL, wrongTypeOfEmail);
    }

    @Test
    void negativeTestNoPassword() {
        homePage.goToLoginPage();
        logInAndRegistrPage.fillInLoginFormAndPressOkButton();
        logInAndRegistrPage.checkErrorMessageByLoginPage(NO_PASSWORD_MESSAGE, fieldPasswordRequired);
    }

    @Test
    void negativeTestWrongPassword() {
        homePage.goToLoginPage();
        logInAndRegistrPage.fillInLoginFormAndPressOkButton();
        logInAndRegistrPage.checkErrorMessageByLoginPage(WRONG_PASSWORD_MESSAGE, wrongPassword);
    }

    @Test
    void negativeTestUserNotFound() {
        homePage.goToLoginPage();
        logInAndRegistrPage.fillInLoginFormAndPressOkButton();
        logInAndRegistrPage.checkErrorMessageByLoginPage(USER_NOT_FOUND_MESSAGE, userNotFound);
    }
}
