import jdk.jfr.Description;
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

public class CheckFormNameTest {
    private WebDriver driver;
    private CheckFormName checkFormName;

    @Before
    public void setup() {
        System.setProperty("web.driver.chrome.driver", "src/test/java/resource/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://mts.by");

        WebElement clickCookie = driver.findElement(By.id("cookie-agree"));
        clickCookie.click();

        checkFormName = new CheckFormName(driver);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    @Description("Проверка плейсхолдеров для каждого варианта оплаты")
    public void checkConnection () {
        Assert.assertTrue(checkFormName.getButtonSelectConnectionText());
        Assert.assertTrue(checkFormName.getFormNumber());
        Assert.assertTrue(checkFormName.getFormSumm());
        Assert.assertTrue(checkFormName.getButtonSelecHome());
        Assert.assertTrue(checkFormName.getFormSubscriber());
        Assert.assertTrue(checkFormName.getFormSummInternet());
        Assert.assertTrue(checkFormName.getButtonSelectInstallment());
        Assert.assertTrue(checkFormName.getFormNumberInstallment());
        Assert.assertTrue(checkFormName.getFormSummInstallment());
        Assert.assertTrue(checkFormName.getButtonSelectDebt());
        Assert.assertTrue(checkFormName.getFormArrears());
        Assert.assertTrue(checkFormName.getFormSummArrears());
    }

    @Test
    @Description("Проверка заполнения и отправки формы")
    public void testSubmissionCheck () {

        WebElement inputNumber = driver.findElement(By.id("connection-phone"));
        inputNumber.click();
        inputNumber.sendKeys("297777777");

        WebElement inputSumm = driver.findElement(By.id("connection-sum"));
        inputSumm.click();
        inputSumm.sendKeys("300");

        WebElement inputBut = driver.findElement(By.cssSelector("button.button_default"));
        inputBut.click();
    }

    @Test
    @Description("Проверка отображения текста")
    public void testWindow () {

        Assert.assertEquals("300.00 BYN",checkFormName.getFormPaymentAmount());
        Assert.assertEquals("Оплатить 300.00 BYN",checkFormName.getButtonPaymentAmount());
        Assert.assertEquals("Оплата: Услуги связи Номер:375297777777",checkFormName.getCheckNumber());
    }

    @Test
    @Description("Проверка отображения плейсхолдеров оплаты картой")
    public void  testPleysholder () {

        Assert.assertTrue(checkFormName.getNumberCard());
        Assert.assertTrue(checkFormName.getValidityPeriod());
        Assert.assertTrue(checkFormName.getUserName());
        Assert.assertTrue(checkFormName.getUserCode());
    }

    @Test
    @Description("Проверка отображения иконок платежных систем")
    public void testIcon () {

        Assert.assertTrue(checkFormName.getIconVisa());
        Assert.assertTrue(checkFormName.getIconMastercard());
        Assert.assertTrue(checkFormName.getIconBelkart());
        Assert.assertTrue(checkFormName.getIconMir());
    }

}