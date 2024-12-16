import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConnectionBlock {
    private final  WebDriver driver;

    public ConnectionBlock(WebDriver driver) {
        this.driver = driver;
    }

    private final By formNumber = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By emailInput = By.id("connection-email");
    private final By continueButton = By.className("button button__default ");

    public String getPlaceholderPhoneText() {
        return driver.findElement(formNumber).getAttribute("placeholder");
    }

    public String getPlaceholderSumText() {
        return driver.findElement(sumInput).getAttribute("placeholder");
    }

    public String getPlaceholderEmailText() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }

    public void enterPhone(String phone) {
        WebElement phoneNumberInputElement = driver.findElement(formNumber);
        phoneNumberInputElement.clear();
        phoneNumberInputElement.sendKeys(phone);
    }

    public void enterSum(String summ) {
        WebElement serviseTypeSelectElement = driver.findElement(sumInput);
        serviseTypeSelectElement.click();
        serviseTypeSelectElement.sendKeys(summ);
    }

    public void fillForm(String phone, String sum) {
        enterPhone(phone);
        enterSum(sum);
        driver.findElement(continueButton).click();
    }
}
