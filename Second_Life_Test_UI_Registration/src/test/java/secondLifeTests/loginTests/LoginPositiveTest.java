package secondLifeTests.loginTests;

import org.junit.jupiter.api.Test;
import secondLifeTests.core.BaseTest;

import static secondLifePages.pages.HomePage.homePageWords;

public class LoginPositiveTest extends BaseTest {
    private static final String WORDS_ON_HOME_PAGE = "Let your unwanted items find a new home and bring joy to others.";


    @Test
    void positiveLoginTest() {
     homePage.goToLoginPage();
     logInAndRegistrPage.fillInLoginFormAndPressOkButton();
     homePage.checkWordsOnHomePage(WORDS_ON_HOME_PAGE,homePageWords);
    }
}
