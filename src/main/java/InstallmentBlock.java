import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstallmentBlock {
    private final WebDriver driver;

    public InstallmentBlock(WebDriver driver) {
        this.driver = driver;
    }

    private final By scoreInput = By.id("score-instalment");
    private final By sumInput = By.id("instalment-sum");
    private final By emailInput = By.id("instalment-email");
    private final By continueButton = By.className("button button__default ");

    public String getPlaceholderScoreText() {
        return driver.findElement(scoreInput).getAttribute("placeholder");
    }

    public String getPlaceholderSumText() {
        return driver.findElement(sumInput).getAttribute("placeholder");
    }

    public String getPlaceholderEmailText() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }
}
