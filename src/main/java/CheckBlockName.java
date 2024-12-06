import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBlockName {
    private WebDriver driver;

    public CheckBlockName(WebDriver driver) {
        this.driver = driver;
    }

    private By blockName = By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]");
    private By paymentVisa = By.cssSelector("img[src*= 'visa']");
    private By paymentVisaV = By.cssSelector("img[src*= 'visa-verified']");
    private By paymentMasterCardS = By.cssSelector("img[src*= 'mastercard-secure']");
    private By paymentMasterCard = By.cssSelector("img[src*= 'mastercard']");
    private By paymentBelKart = By.cssSelector("img[src*= 'belkart']");
    private By moreInfoLink = By.linkText("Подробнее о сервисе");
    private By serviceTypeSelect = By.id("serviceType");
    private By phoneNumberInput = By.id("connection-phone");
    private By continueButton = By.className("button button_default");


    public Object getCheckBlockName() {
        return driver.findElement(blockName).getText();
    }


    public boolean getCheckPaymentVisa() {
        return isElementVisible(paymentVisa);
    }

    public boolean getCheckPaymentVisaV() {
        return isElementVisible(paymentVisaV);
    }

    public boolean getCheckPaymentMasterCardS() {
        return isElementVisible(paymentMasterCardS);
    }

    public boolean getCheckPaymentMasterCard() {
        return isElementVisible(paymentMasterCard);
    }

    public boolean getCheckPaymentBelKart() {
        return isElementVisible(paymentBelKart);
    }

    private boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickMoreInfo() {
        driver.findElement(moreInfoLink).click();
    }

    public void fillRechargeForm(String serviceType, String phoneNumber) {
        WebElement serviceTypeSelectElement = driver.findElement(serviceTypeSelect);
        serviceTypeSelectElement.sendKeys(serviceType);

        WebElement phoneNumberInputElement = driver.findElement(phoneNumberInput);
        phoneNumberInputElement.sendKeys(phoneNumber);

        driver.findElement(continueButton).click();
    }
}