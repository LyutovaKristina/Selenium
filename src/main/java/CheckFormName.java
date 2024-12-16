import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckFormName {
    private final WebDriver driver;

    public CheckFormName(WebDriver driver) {
        this.driver = driver;
    }

    private final By framePay = By.className("bepaid-iframe");

    private final By formPaymentAmount = By.cssSelector(".pay-description__cost > span");
    private final By buttonPaymentAmount = By.xpath("//button['colored disabled']");
    private final By checkNumber = By.className("pay-description__text");

    private final By numberCard = By.xpath("//*[contains(text(), 'Номер карты')]");
    private final By validityPeriod = By.xpath("//*[contains(text(), 'Срок действия')]");
    private final By userName = By.xpath("//*[contains(text(), 'Имя держателя (как на карте)')]");
    private final By userCode = By.xpath("//*[contains(text(), 'CVC')]");

    private final By iconVisa = By.cssSelector("img[src*= 'visa-system']");
    private final By iconMastercard = By.cssSelector("img[src*= 'mastercard-system']");
    private final By iconBelkart = By.cssSelector("img[src*= 'belkart-system']");
    private final By iconMir = By.cssSelector("img[src*= 'mir-system']");


    public void checkFormPaymentAmountContainsText(String text) {
        checkElementHasText(formPaymentAmount, text);
    }
    public void checkButtonPaymentAmountContainsText(String text) {
        checkElementHasText(buttonPaymentAmount, text);
    }
    public void checkNumberContainsText(String text) {
        checkElementHasText(buttonPaymentAmount, text);
    }

    // проверка плейсхолдеров
    public Boolean getNumberCard () {
        return isElementVisible(numberCard);
    }
    public Boolean getValidityPeriod () {
        return isElementVisible(validityPeriod);
    }
    public Boolean getUserName () {
        return isElementVisible(userName);
    }
    public Boolean getUserCode () {
        return isElementVisible(userCode);
    }

    // проверка иконок
    public Boolean getIconVisa () {
        return isElementVisible(iconVisa);
    }


    public Boolean getIconMastercard () {
        return isElementVisible(iconMastercard);
    }
    public Boolean getIconBelkart () {
        return isElementVisible(iconBelkart);
    }
    public Boolean getIconMir () {
        return isElementVisible(iconMir);
    }

    public void switchToFrame() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(d -> ExpectedConditions.frameToBeAvailableAndSwitchToIt(framePay));
        driver.switchTo().frame(driver.findElement(framePay));
    }

    private boolean isElementVisible(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(d -> ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return true;
    }

    private void checkElementHasText(By locator, String text) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(driver -> ExpectedConditions.textToBePresentInElement(driver.findElement(locator), text));
    }
}