import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class TestConstructor extends BaseTest {
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
    @DisplayName("тест перехода к разделу Булки")
    @Test
    public void testOpenBunsConstructor() {
        MainPage mainPage = new MainPage(driver);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        mainPage.openMainPage();
        constructorPage.clickFillingSectionButton();
        constructorPage.clickBunsSectionButton();
        assertTrue(constructorPage.checkBunsTitle());
    }
    @DisplayName("тест перехода к разделу Соусы")
    @Test
    public void testOpenSauceConstructor() {
        MainPage mainPage = new MainPage(driver);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        mainPage.openMainPage();
        constructorPage.clickSauceSectionButton();
        assertTrue(constructorPage.checkSauceTitle());
    }
    @DisplayName("тест перехода к разделу Начинки")
    @Test
    public void testOpenFillingConstructor() {
        MainPage mainPage = new MainPage(driver);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        mainPage.openMainPage();
        constructorPage.clickFillingSectionButton();
        assertTrue(constructorPage.checkFillingTitle());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
