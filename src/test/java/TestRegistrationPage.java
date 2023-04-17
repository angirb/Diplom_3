import groovy.util.logging.Log;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

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

    @DisplayName("Тест успешной регистрации с случайными данными пользователя")
    @Test
    public void testSuccessRegisterUserThroughEnterIntoAccButton() {
        User user = UserGenerator.getRandom();
        LogInPage logInPage = new LogInPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        registerUser(user);
        registerPage.waitForLoadPage(By.xpath("*//h2[text() = 'Вход']"));
        assertTrue(logInPage.checkLogInButtonText());
    }
    @DisplayName("Тест успешной регистрации пользователя через личный кабинет")
    @Test
    public void testRegisterUserThroughPersonalAccButton() {
        User user = UserGenerator.getRandom();
        LogInPage logInPage = new LogInPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickPersonalAccountButton();
        registerPage.clickRegisterTextButton();
        registerPage.setRegisterInputNameField(user.getName());
        registerPage.setRegisterInputEmailField(user.getEmail());
        registerPage.setRegisterInputPasswordField(user.getPassword());
        registerPage.clickRegisterPageButtonRegister();
        registerPage.waitForLoadPage(By.xpath("*//h2[text() = 'Вход']"));
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

