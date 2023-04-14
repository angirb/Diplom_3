import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)

public class TestLoginIntoAccount extends BaseTest {

    private final String email;
    private final String password;
    @BeforeClass
    public static void globalSetup() {
        RestAssured.filters(
                new RequestLoggingFilter(), new ResponseLoggingFilter(),
                new AllureRestAssured()
        );
    }

    public TestLoginIntoAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Before
    public void before() {
        super.before();
    }
    @Parameterized.Parameters
    public static String[][] getLogInData(){
        return new String[][]{
                {"test1@mail.ru", "123456"}
        };
    }
    private void loginUserTests() {
        LogInPage loginPage = new LogInPage(driver);

        loginPage.openLogInPage();
        loginPage.setEmailLoginField(email);
        loginPage.setPasswordLoginField(password);
        loginPage.clickLogInButton();
    }

    @DisplayName("Тест на вход в аккаунт")
    @Test
    public void testLogInWithRegisteredAccount() {
        loginUserTests();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.checkMakeAnOrder());
    }
    @DisplayName("Тест на вход в аккаунт через главную страницу Войти в аккаунт")
    @Test
    public void testLoginThroughMainPageEnterIntoAccountButton() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickEnterIntoAccountButton();

        loginUserTests();
        assertTrue(mainPage.checkMakeAnOrder());
    }
    @DisplayName("Тест на вход в аккаунт через личный кабинет")
    @Test
    public void testLoginThroughPersonalAccountPage() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickPersonalAccountButton();

        loginUserTests();
        assertTrue(mainPage.checkMakeAnOrder());
    }
    @DisplayName("Тест на вход в аккаунт через страницу регистрации")
    @Test
    public void testLoginThroughRegisterPage() {
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.openRegisterPage();
        registerPage.clickRegisterLogInButton();

        loginUserTests();
        assertTrue(mainPage.checkMakeAnOrder());
    }
    @DisplayName("Тест на вход в аккаунт через страницу забыл пароль")
    @Test
    public void testLoginThroughForgotPassPage() {
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.openForgotPassPage();
        registerPage.clickRegisterLogInButton();

        loginUserTests();
        assertTrue(mainPage.checkMakeAnOrder());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
