import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBlockName {
    private WebDriver driver;

    public CheckBlockName(WebDriver driver) {
        this.driver = driver;
    }

    private By blockName = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");
    private By paymentVisa = By.cssSelector("img[src*= 'visa']");
    private By paymentVisaV = By.cssSelector("img[src*= 'visa-verified']");
    private By paymentMasterCardS = By.cssSelector("img[src*= 'mastercard-secure']");
    private By paymentMasterCard = By.cssSelector("img[src*= 'mastercard']");
    private By paymentBelKart = By.cssSelector("img[src*= 'belkart']");
    private By moreInfoLink = By.linkText("Подробнее о сервисе");

    private By serviceTypeSelect = By.id("serviceType");
    private By phoneNumberInput = By.id("connection-phone");
    private By continueButton = By.cssSelector("button.button__default");


    public String getCheckBlockName() {
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


    public void enterPhone(String phone) {

        WebElement phoneNumberInputElement = driver.findElement(phoneNumberInput);
        phoneNumberInputElement.clear();
        phoneNumberInputElement.sendKeys(phone);
    }
    public void enterSum(String summ) {

        WebElement serviseTypeSelectElement = driver.findElement(serviceTypeSelect);
        serviseTypeSelectElement.click();
        serviseTypeSelectElement.sendKeys(summ);

        driver.findElement(continueButton).click();
    }
}