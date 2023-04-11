import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    // локатор Кнопки личного кабинета на главной странице
    private final By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    // локатор Кнопки Войти в аккант на главной странице
    private final By enterIntoAccount = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    // локатор Соберите бургер
    private final By loggedIntoAccount = By.xpath("//*[text()='Соберите бургер']");
    private final By makeAnOrder = By.xpath(".//button[text()='Оформить заказ']");
    // локатор констукртора бургеров
    private final By constructorButton = By.xpath("*//p[text() = 'Конструктор']");
    private final By stellaBurgersButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    public void clickPersonalAccountButton() {
        if(driver.findElement(personalAccountButton).isDisplayed());
        driver.findElement(personalAccountButton).click();
    }
    public void clickEnterIntoAccountButton() {
        if(driver.findElement(enterIntoAccount).isDisplayed());
        driver.findElement(enterIntoAccount).click();
    }
    public boolean checkLoggedIntoAccount() {
        if(driver.findElement(loggedIntoAccount).isDisplayed());
        return driver.findElement(loggedIntoAccount).getText().equals("Соберите бургер");
    }
    public boolean checkMakeAnOrder() {
        return driver.findElement(makeAnOrder).isDisplayed();
    }
    public void clickConstructorButton() {
        if(driver.findElement(constructorButton).isDisplayed());
        driver.findElement(constructorButton).click();
    }
    public void clickStellaBurgerButton() {
        driver.findElement(stellaBurgersButton).click();
    }
}
