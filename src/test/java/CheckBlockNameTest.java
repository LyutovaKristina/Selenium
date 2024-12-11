import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CheckBlockNameTest {
    private WebDriver driver;
    private CheckBlockName checkBlockName;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Перенесите сюда
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://mts.by");

        WebElement clickCookie = driver.findElement(By.id("cookie-agree"));
        clickCookie.click();

        checkBlockName = new CheckBlockName(driver);
    }

    @Test
    public void testBlockName() {
        Assert.assertEquals("Онлайн пополнение\n" + "без комиссии", checkBlockName.getCheckBlockName());
    }


    @Test
    public void testPaymentSystemsVisibility() {
        Assert.assertTrue(checkBlockName.getCheckPaymentVisa());
        Assert.assertTrue(checkBlockName.getCheckPaymentVisaV());
        Assert.assertTrue(checkBlockName.getCheckPaymentMasterCardS());
        Assert.assertTrue(checkBlockName.getCheckPaymentMasterCard());
        Assert.assertTrue(checkBlockName.getCheckPaymentBelKart());
    }

    @Test
    public void testFillInputField() {

        WebElement inputField = driver.findElement(By.id("connection-phone"));
        inputField.click();
        inputField.sendKeys("297777777");

        WebElement inputField2 = driver.findElement(By.id("connection-sum"));
        inputField2.click();
        inputField2.sendKeys("200");

        WebElement inputButton = driver.findElement(By.linkText("Продолжить"));
        inputButton.click();

        String enteredValue = inputField2.getAttribute("value");
        Assert.assertEquals("200", enteredValue);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}

