import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {

    @Test
    void positiveTest(){
        new HomePage(driver,wait).clickOnDoorButton();
        new LogInAndRegistrPage(driver,wait).clickOnRegistration();
        new RegistrationPage(driver,wait).registrationComplete();

    }
}
