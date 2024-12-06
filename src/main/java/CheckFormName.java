import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckFormName {
    private WebDriver driver;

    public CheckFormName(WebDriver driver) {
        this.driver = driver;
    }

    private By buttonSelectConnection = By.xpath("//*[contains(text(), 'Услуги связи')]");
    private By formNumber = By.id("connection-phone");
    private By formSumm = By.id("connection-summ");
    private By buttonSelectHome = By.xpath("//*[contains(text(), 'Домашний интернет')]");
    private By formSubscriber = By.id("internet-phone");
    private By formSummInternet = By.id("internet-sum");
    private By buttonSelectInstallment = By.xpath("//*[contains(text(), 'Рассрочка')]");
    private By formNumberInstallment = By.id("score-instalment");
    private By formSummInstallment = By.id("instalment-sum");
    private By buttonSelectDebt = By.xpath("//*[contains(text(), 'Задолженность')]");
    private By formArrears = By.id("score-arrears");
    private By formSummArrears = By.id("arrears-sum");

    private By formPaymentAmount = By.xpath("//*[contains(text(),'300.00 BYN')]");
    private By buttonPaymentAmount = By.className("card-page_card");
    private By checkNumber = By.xpath("//*[contains(text(), 'Оплата: Услуги связи Номер:375297777777')]");

    private By numberCard = By.xpath("//*contains(text(), 'Номер карты')");
    private By validityPeriod = By.xpath("//*[contains(text(), 'Срок действия')]");
    private By userName = By.xpath("//*[contains(text(), 'Имя держателя (как на карте)')]");
    private By userCode = By.xpath("//*contains(text(), 'CVC')");

    private By iconVisa = By.cssSelector("img[src*= 'visa-system']");
    private By iconMastercard = By.cssSelector("img[src*= 'mastercard-system']");
    private By iconBelkart = By.cssSelector("img[src*= 'belcart-system']");
    private By iconMir = By.cssSelector("img[src*= 'mir-system']");


    public String getButtonSelectConnectionText() {
        return driver.findElement(buttonSelectConnection).getAttribute();
    }

    public String getFormNumber() {
        return driver.findElement(formNumber).getAttribute();
    }

    public String getFormSumm() {
        return driver.findElement(formSumm).getAttribute();
    }

    public String getButtonSelecHome() {
        return driver.findElement(buttonSelectHome).getAttribute();
    }

    public String getFormSubscriber() {
        return driver.findElement(formSubscriber).getAttribute();
    }

    public String getFormSummInternet() {
        return driver.findElement(formSummInternet).getAttribute();
    }

    public String getButtonSelectInstallment() {
        return driver.findElement(buttonSelectInstallment).getAttribute();
    }

    public String getFormNumberInstallment() {
        return driver.findElement(formNumberInstallment).getAttribute();
    }

    public String getFormSummInstallment() {
        return driver.findElement(formSummInstallment).getAttribute();
    }

    public String getButtonSelectDebt() {
        return driver.findElement(buttonSelectDebt).getAttribute();
    }

    public String getFormArrears() {
        return driver.findElement(formArrears).getAttribute();
    }

    public String getFormSummArrears() {
        return driver.findElement(formSummArrears).getAttribute();
    }

// проверка окна оплаты ( сумма сверху и на кнопке и номер телефона )
    public String getFormPaymentAmount () {
        return driver.findElement(formPaymentAmount).getText();
    }
    public String getButtonPaymentAmount () {
        return driver.findElement(buttonPaymentAmount).getText();
    }
    public String getCheckNumber () {
        return driver.findElement(checkNumber).getText();
    }

    // проверка плейсхолдеров
    public String getNumberCard () {
        return driver.findElement(numberCard).getAttribute();
    }
    public String getValidityPeriod () {
        return driver.findElement(validityPeriod).getAttribute();
    }
    public String getUserName () {
        return driver.findElement(userName).getAttribute();
    }
    public String getUserCode () {
        return driver.findElement(userCode).getAttribute();
    }

    // проверка иконок
    public Boolean getIconVisa () {
        return isElementVisible(iconVisa);
    }
    private Boolean isElementVisible(By iconVisa) {
    }
    public Boolean getIconMastercard () {
        return isElementVisible(iconMastercard);
    }
    public Boolean getIconBelkart () {
        return isElementVisible(iconBelkart);
    }
    public Boolean getIconMir () {
        return isElementVisible(iconMir);
    }

}