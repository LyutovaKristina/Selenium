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


    public Boolean getButtonSelectConnectionText() {
        return isElementVisible(buttonSelectConnection);
    }

    public Boolean getFormNumber() {

        return isElementVisible(formNumber);
    }

    public Boolean getFormSumm() {
        return isElementVisible(formSumm);
    }

    public Boolean getButtonSelecHome() {
        return isElementVisible(buttonSelectHome);
    }

    public Boolean getFormSubscriber() {
        return isElementVisible(formSubscriber);
    }

    public Boolean getFormSummInternet() {
        return isElementVisible(formSummInternet);
    }

    public Boolean getButtonSelectInstallment() {
        return isElementVisible(buttonSelectInstallment);
    }

    public Boolean getFormNumberInstallment() {
        return isElementVisible(formNumberInstallment);
    }

    public Boolean getFormSummInstallment() {
        return isElementVisible(formSummInstallment);
    }

    public Boolean getButtonSelectDebt() {
        return isElementVisible(buttonSelectDebt);
    }

    public Boolean getFormArrears() {
        return isElementVisible(formArrears);
    }

    public Boolean getFormSummArrears() {
        return isElementVisible(formSummArrears);
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
    public Boolean getNumberCard () {
        return isElementVisible(numberCard);
    }


    public Boolean getValidityPeriod () {
        return isElementVisible(validityPeriod);
    }
    public Boolean getUserName () {
        return isElementVisible(userName);
    }
    public Boolean getUserCode () {
        return isElementVisible(userCode);
    }

    // проверка иконок
    public Boolean getIconVisa () {
        return isElementVisible(iconVisa);
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

    private boolean isElementVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}