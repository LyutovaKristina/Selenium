import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DebitBlock {
    private final WebDriver driver;
    public DebitBlock(WebDriver driver) {
        this.driver = driver;
    }

    private final By scoreInput = By.id("score-arrears");
    private final By sumInput = By.id("arrears-sum");
    private final By emailInput = By.id("arrears-email");
    private final By continueButton = By.className("button button__default ");

    public String getPlaceholderPhoneText() {
        return driver.findElement(scoreInput).getAttribute("placeholder");
    }

    public String getPlaceholderSumText() {
        return driver.findElement(sumInput).getAttribute("placeholder");
    }

    public String getPlaceholderEmailText() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }
}
