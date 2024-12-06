import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBlockNameTest {
    private WebDriver driver;
    private CheckBlockName checkBlockName;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://mts.by");

        checkBlockName = new CheckBlockName(driver);
    }

    @Test
    public void testBlockName() {
        Assert.assertEquals("Онлайн пополнение без комиссии", checkBlockName.getCheckBlockName());
    }

    @Test
    public void testPaymentSystemsVisibility() {
        Assert.assertTrue(Boolean.parseBoolean(checkBlockName.getCheckPaymentVisa("visa")));
        Assert.assertTrue(Boolean.parseBoolean(checkBlockName.getCheckPaymentVisaV("visa-verified")));
        Assert.assertTrue(Boolean.parseBoolean(checkBlockName.getCheckPaymentMasterCardS("mastercard-secure")));
        Assert.assertTrue(Boolean.parseBoolean(checkBlockName.getCheckPaymentMasterCard("mastercard")));
        Assert.assertTrue(Boolean.parseBoolean(checkBlockName.getCheckPaymentBelKart("belkart")));
    }

    @Test
    public void testFillInputField() {

        WebElement inputField = driver.findElement(By.id("connection-phone"));
        inputField.click();
        inputField.sendKeys("297777777");

        WebElement inputField2 = driver.findElement(By.id("connection-sum"));
        inputField2.click();
        inputField2.sendKeys("200");

        WebElement inputButton = driver.findElement(By.className("button button_default"));
        inputButton.click();

        String enteredValue = inputField2.getAttribute("value");
        Assert.assertEquals("200", enteredValue);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}