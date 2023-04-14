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

public class TestPersonalAccount extends BaseTest {

    private final String email;
    private final String password;

    @BeforeClass
    public static void globalSetup() {
        RestAssured.filters(
                new RequestLoggingFilter(), new ResponseLoggingFilter(),
                new AllureRestAssured()
        );
    }

    public TestPersonalAccount(String email, String password) {
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
    @DisplayName("Тест входа в личный аккаунт")
    @Test
    public void testEnterLogInPage() {
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.openMainPage();
        mainPage.clickPersonalAccountButton();
        logInPage.setEmailLoginField(email);
        logInPage.setPasswordLoginField(password);
        registerPage.clickRegisterPageButtonRegister();
        assertTrue(mainPage.checkMakeAnOrder());

    }
    @DisplayName("Тест перехода по клику на «Конструктор» из личного кабинета")
    @Test
    public void testOpenConstructorFromPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);

        mainPage.openMainPage();
        mainPage.clickPersonalAccountButton();
        logInPage.setEmailLoginField(email);
        logInPage.setPasswordLoginField(password);
        logInPage.clickLogInButton();
        mainPage.clickPersonalAccountButton();
        mainPage.clickConstructorButton();
        assertTrue(mainPage.checkLoggedIntoAccount());
    }
    @DisplayName("Тест перехода по клику «Стелла бургерс» из личного кабинета")
    @Test
    public void testOpenMainPageFromPersonalAccountThroughStellaBurgerButton() {
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        mainPage.openMainPage();
        mainPage.clickPersonalAccountButton();
        logInPage.setEmailLoginField(email);
        logInPage.setPasswordLoginField(password);
        logInPage.clickLogInButton();
        mainPage.clickPersonalAccountButton();
        mainPage.clickStellaBurgerButton();
        assertTrue(mainPage.checkLoggedIntoAccount());
    }
    @DisplayName("Тест выхода по кнопке «Выйти» в личном кабинете")
    @Test
    public void testLogOutFromPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        mainPage.openMainPage();
        mainPage.clickPersonalAccountButton();
        logInPage.setEmailLoginField(email);
        logInPage.setPasswordLoginField(password);
        logInPage.clickLogInButton();
        assertTrue(mainPage.checkLoggedIntoAccount());
        mainPage.clickPersonalAccountButton();
        logInPage.clickLogOutButton();
        assertTrue(logInPage.checkLogInButtonText());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
