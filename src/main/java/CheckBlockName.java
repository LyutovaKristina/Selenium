import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBlockName {
    private final WebDriver driver;

    public CheckBlockName(WebDriver driver) {
        this.driver = driver;
    }

    private final By blockName = By.cssSelector("#pay-section h2");

    private final By paymentPartners = By.cssSelector(".pay__partners");
    private final By moreInfoLink = By.linkText("Подробнее о сервисе");

    private final By selectTypeButton = By.cssSelector("#pay-section .select__header");
    private final By selectList = By.cssSelector("#pay-section .select__list");

    public boolean checkPaymentPartnerIsVisible(String alt) {
        String locator = "img[alt='" + alt + "']";
        return driver.findElement(paymentPartners).findElement(By.cssSelector(locator)).isDisplayed();
    }


    public String getCheckBlockName() {
        return driver.findElement(blockName).getText();
    }

    private boolean isElementVisible(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(d -> ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return true;
    }


    public void clickMoreInfo() {
        driver.findElement(moreInfoLink).click();
    }

    public void selectServiceType(String optionsSelect) {
        String xPath = "//p[@class='select__option'][text()='" + optionsSelect + "']";
        driver.findElement(selectTypeButton).click();
        driver.findElement(selectList).findElement(By.xpath(xPath)).click();
    }
}