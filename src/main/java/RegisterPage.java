import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private final WebDriver driver;
    private final By registerTextButton = By.xpath("*//a[text() = 'Зарегистрироваться']");
    // Поле заполнения имени
    private final By registerInputNameField = By.xpath(".//fieldset[1]/div/div/input");
    // Поле заполнения электронной почты
    private final By registerInputEmailField = By.xpath(".//fieldset[2]/div/div/input");
    // Поле заполнения пароля
    private final By registerInputPasswordField = By.xpath(".//fieldset[3]/div/div/input");
    private final By registerPageButtonEnter = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By registerIncorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    private final By registerPageLogInButton = By.xpath("*//a[text() = 'Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openRegisterPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }
    public void waitForLoadPage(By element) {
        WebDriverWait waitForLoadPage = new WebDriverWait(driver, (10));
        waitForLoadPage.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void setRegisterInputNameField(String nameField) {
        driver.findElement(registerInputNameField).sendKeys(nameField);
    }
    public void setRegisterInputEmailField(String emailField) {
        driver.findElement(registerInputEmailField).sendKeys(emailField);
    }
    public void setRegisterInputPasswordField(String passwordField) {
        driver.findElement(registerInputPasswordField).sendKeys(passwordField);
    }
    public void clickRegisterTextButton() {
        driver.findElement(registerTextButton).click();
    }
    public void clickRegisterPageButtonRegister() {
        driver.findElement(registerPageButtonEnter).click();
    }
    public String checkRegisterIncorrectPassword() {
        return driver.findElement(registerIncorrectPassword).getText();
    }
    public void clickRegisterLogInButton() {
        driver.findElement(registerPageLogInButton).click();
    }

}
