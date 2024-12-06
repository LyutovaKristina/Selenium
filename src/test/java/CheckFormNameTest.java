import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CheckFormNameTest {
    private WebDriver driver;
    private CheckFormName checkFormName;

    @Before
    public void setup() {
        System.setProperty("web.driver.chrome.driver", "src/test/java/resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://mts.by");

        checkFormName = new CheckFormName(driver);
    }

    @Test
    public void checkConnection () {
        Assert.assertEquals(checkFormName.getButtonSelectConnectionText("Услуги связи")););
        Assert.assertEquals(checkFormName.getFormNumber("Номер телефона")););
        Assert.assertEquals(checkFormName.getFormSumm("Сумма")));
        Assert.assertEquals(checkFormName.getButtonSelecHome("домашний интернет")));
        Assert.assertEquals(checkFormName.getFormSubscriber("Номер абонента")));
        Assert.assertEquals(checkFormName.getFormSummInternet("Сумма")););
        Assert.assertEquals(checkFormName.getButtonSelectInstallment("Рассрочка")));
        Assert.assertEquals(checkFormName.getFormNumberInstallment("Номер счета на 44")));
        Assert.assertEquals(checkFormName.getFormSummInstallment("Сумма")));
        Assert.assertEquals(checkFormName.getButtonSelectDebt("Задолженность")));
        Assert.assertEquals(checkFormName.getFormArrears("Номер счета на 2073")));
        Assert.assertEquals(checkFormName.getFormSummArrears("Сумма")));
    }

    @Test
    public void testSubmissionCheck () {

        WebElement inputNumber = driver.findElement(By.id("connection-phone"));
        inputNumber.click();
        inputNumber.sendKeys("297777777");

        WebElement inputSumm = driver.findElement(By.id("connection-sum"));
        inputSumm.click();
        inputSumm.sendKeys("300");

        WebElement inputBut = driver.findElement(By.className("button button_default"));
        inputBut.click();
    }

    @Test
    public void testWindow () {

       Assert.assertEquals(checkFormName.getFormPaymentAmount("300.00 BYN"));
       Assert.assertEquals(checkFormName.getButtonPaymentAmount("Оплатить 300.00 BYN"));
       Assert.assertEquals(checkFormName.getCheckNumber("Оплата: Услуги связи Номер:375297777777"));
    }

    @Test
    public void  testPleysholder () {

        Assert.assertEquals(checkFormName.getNumberCard("Номер карты"));
        Assert.assertEquals(checkFormName.getValidityPeriod("Срок действия"));
        Assert.assertEquals(checkFormName.getUserName("Имя держателя (как на карте)"));
        Assert.assertEquals(checkFormName.getUserCode("CVC"));
    }

    @Test

    public void testIcon () {

        Assert.assertTrue(Boolean.parseBoolean(checkFormName.getIconVisa("visa-system")));
        Assert.assertTrue(Boolean.parseBoolean(checkFormName.getIconMastercard("mastercard-system")));
        Assert.assertTrue(Boolean.parseBoolean(checkFormName.getIconBelkart("belcart-system")));
        Assert.assertTrue(Boolean.parseBoolean(checkFormName.getIconMir("mir-system")));
    }


}