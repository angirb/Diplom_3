import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ConstructorPage {
    private final WebDriver driver;

    // локатор перехода на раздел булки
    private final By bunsSectionButton = By.xpath(".//div[@style = 'display: flex;']/div[1]/span");
    // локатор для заголовка булки
    private final By bunsTitleSelected = By.xpath(".//span[text()='Булки']/parent::div[contains(@class,'tab_tab_type_current__2BEPc')]");
    // локатор перехода на раздел соусы
    private final By sauceSectionButton = By.xpath(".//div[@style = 'display: flex;']/div[2]/span");
    // локатор для заголовка соусы
    private final By sauceTitleSelected = By.xpath(".//span[text()='Соусы']/parent::div[contains(@class,'tab_tab_type_current__2BEPc')]");
    // локатор перехода на раздел начинки
    private final By fillingSectionButton = By.xpath(".//div[@style = 'display: flex;']/div[3]/span");
    // локатор для заголовка начинки
    private final By fillingTitleSelected = By.xpath(".//span[text()='Начинки']/parent::div[contains(@class,'tab_tab_type_current__2BEPc')]");

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
        return driver.findElement(bunsTitleSelected).isDisplayed();
    }

    public boolean checkSauceTitle() {
        return driver.findElement(sauceTitleSelected).isDisplayed();
    }
    public boolean checkFillingTitle() {
        return driver.findElement(fillingTitleSelected).isDisplayed();
    }
}
