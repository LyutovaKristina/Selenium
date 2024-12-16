import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeInternetBlock {
    private final WebDriver driver;

    public HomeInternetBlock(WebDriver driver) {
        this.driver = driver;
    }

    private final By phoneInput = By.id("internet-phone");
    private final By sumInput = By.id("internet-sum");
    private final By emailInput = By.id("internet-email");
    private final By continueButton = By.className("button button__default ");

    public String getPlaceholderPhoneText() {
        return driver.findElement(phoneInput).getAttribute("placeholder");
    }

    public String getPlaceholderSumText() {
        return driver.findElement(sumInput).getAttribute("placeholder");
    }

    public String getPlaceholderEmailText() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }
}
