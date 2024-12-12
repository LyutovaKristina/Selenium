import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CheckFormNameTest {
    private WebDriver driver;
    private CheckFormName checkFormName;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://mts.by");

        try {
            WebElement clickCookie = driver.findElement(By.id("cookie-agree"));
            clickCookie.click();
        } catch (NoSuchElementException ignored) {
        }
        checkFormName = new CheckFormName(driver);
    }

    @Test
    public void checkConnection() {
        Assert.assertTrue(checkFormName.getButtonSelectConnectionText());
        Assert.assertTrue(checkFormName.getFormNumber());
        Assert.assertTrue(checkFormName.getFormSumm());
        WebElement clickHeader = driver.findElement(By.className("select__arrow"));
        clickHeader.click();
        Assert.assertTrue(checkFormName.getButtonSelectHome());
        Assert.assertTrue(checkFormName.getFormSubscriber());
        Assert.assertTrue(checkFormName.getFormSummInternet());
        WebElement clickHeader2 = driver.findElement(By.className("select__arrow"));
        clickHeader2.click();
        Assert.assertTrue(checkFormName.getButtonSelectInstallment());
        Assert.assertTrue(checkFormName.getFormNumberInstallment());
        Assert.assertTrue(checkFormName.getFormSummInstallment());
        WebElement clickHeader3 = driver.findElement(By.className("select__arrow"));
        clickHeader3.click();
        Assert.assertTrue(checkFormName.getButtonSelectDebt());
        Assert.assertTrue(checkFormName.getFormArrears());
        Assert.assertTrue(checkFormName.getFormSummArrears());
    }

    @Test
    public void testSubmissionCheck() {

        try {
            WebElement clickCookie = driver.findElement(By.id("cookie-agree"));
            clickCookie.click();
        } catch (NoSuchElementException ignored) {
        }


        WebElement inputNumber = driver.findElement(By.id("connection-phone"));
        inputNumber.click();
        inputNumber.sendKeys("297777777");

        WebElement inputSumm = driver.findElement(By.id("connection-sum"));
        inputSumm.click();
        inputSumm.sendKeys("300");

        WebElement inputBut = driver.findElement(By.cssSelector("button.button__default"));
        inputBut.click();
    }

    @Test
    public void testWindow() {
        Assert.assertEquals("300.00 BYN", checkFormName.getFormPaymentAmount());
        Assert.assertEquals("Оплатить 300.00 BYN", checkFormName.getButtonPaymentAmount());
        Assert.assertEquals("Оплата: Услуги связи Номер:375297777777", checkFormName.getCheckNumber());
    }

    @Test
    public void testPlaceholder() {
        Assert.assertTrue(checkFormName.getNumberCard());
        Assert.assertTrue(checkFormName.getValidityPeriod());
        Assert.assertTrue(checkFormName.getUserName());
        Assert.assertTrue(checkFormName.getUserCode());
    }

    @Test
    public void testIcon() {
        Assert.assertTrue(checkFormName.getIconVisa());
        Assert.assertTrue(checkFormName.getIconMastercard());
        Assert.assertTrue(checkFormName.getIconBelkart());
        Assert.assertTrue(checkFormName.getIconMir());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }
}