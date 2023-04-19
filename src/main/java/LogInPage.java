import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private final WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By emailLoginField = By.xpath(".//fieldset[1]/div/div/input");
    private final By passwordLoginField = By.xpath(".//fieldset[2]/div/div/input");
    private final By logInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By logOutButton = By.xpath("*//button[text() = 'Выход']");
    private final By checkLogInText = By.xpath("*//h2[text() = 'Вход']");
    public void openForgotPassPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
    }
    public void openLogInPage() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
    }
    public  void setEmailLoginField(String emailField) {
        driver.findElement(emailLoginField).sendKeys(emailField);
    }
    public void setPasswordLoginField(String passwordField) {
        driver.findElement(passwordLoginField).sendKeys(passwordField);
    }
    public void clickLogInButton() {
        driver.findElement(logInButton).click();
    }
    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }
    public boolean checkLogInButtonText() {
        return driver.findElement(checkLogInText).getText().equals("Вход");

    }
}
