import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestRegistrationPage extends BaseTest {



    @BeforeClass
    public static void globalSetup() {
        RestAssured.filters(
                new RequestLoggingFilter(), new ResponseLoggingFilter(),
                new AllureRestAssured()
        );
    }
    @Before
    public void before() {
        super.before();
    }

    private void registerUser(User user) {
        RegisterPage registerPage = new RegisterPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickEnterIntoAccountButton();
        registerPage.clickRegisterTextButton();
        registerPage.setRegisterInputNameField(user.getName());
        registerPage.setRegisterInputEmailField(user.getEmail());
        registerPage.setRegisterInputPasswordField(user.getPassword());
        registerPage.clickRegisterPageButtonRegister();
    }

    @DisplayName("Тест регистрации с случайными данными пользователя")
    @Test
    public void testRegisterWithRandomGenerator() {
        User user = UserGenerator.getRandom();
        registerUser(user);
    }
    @DisplayName("Тест успешной регистрации пользователя")
    @Test
    public void testRegisterWithRandomGenerator2() {
        User user = new User("Naruto3", "narutoemail5@yandex.ru", "1234567");
        LogInPage logInPage = new LogInPage(driver);
        registerUser(user);
        assertTrue(logInPage.checkLogInButtonText());

    }
    @DisplayName("Тест регистрации с случайными данными пользователя и паролем менее пяти символов")
    @Test
    public void testRegisterWithRandomGeneratorLessThanFiveSymbolsPass() {
        User user = UserGenerator.getRandomWithPasswordLessThanFiveSymbols();
        registerUser(user);
        RegisterPage registerPage = new RegisterPage(driver);
        String errorNotification = registerPage.checkRegisterIncorrectPassword();
        assertEquals("Сообщение отсутствует", "Некорректный пароль", errorNotification);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

