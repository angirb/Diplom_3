import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {
    private WebDriver driver;

    // локатор перехода на раздел булки
    private final By bunsSectionButton = By.xpath(".//div[@style = 'display: flex;']/div[1]/span");
    // локатор для заголовка булки
    private final By bunsTitle = By.xpath(".//h2[text() = 'Булки']");
    // локатор перехода на раздел соусы
    private final By sauceSectionButton = By.xpath(".//div[@style = 'display: flex;']/div[2]/span");
    // локатор для заголовка соусы
    private final By sauceTitle = By.xpath(".//h2[text() = 'Соусы']");
    // локатор перехода на раздел начинки
    private final By fillingSectionButton = By.xpath(".//div[@style = 'display: flex;']/div[3]/span");
    // локатор для заголовка начинки
    private final By fillingTitle = By.xpath(".//h2[text() = 'Начинки']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBunsSectionButton() {
        driver.findElement(bunsSectionButton).click();
    }
    public void clickSauceSectionButton() {
        driver.findElement(sauceSectionButton).click();
    }
    public void clickFillingSectionButton() {
        driver.findElement(fillingSectionButton).click();
    }
    public boolean checkBunsTitle() {
        if (driver.findElement(bunsTitle).isDisplayed());
        return driver.findElement(bunsTitle).getText().equals("Булки");
    }
    public boolean checkSauceTitle() {
        if (driver.findElement(sauceTitle).isDisplayed());
        return driver.findElement(sauceTitle).getText().equals("Соусы");
    }
    public boolean checkFillingTitle() {
        if (driver.findElement(fillingTitle).isDisplayed());
        return driver.findElement(fillingTitle).getText().equals("Начинки");
    }
}
