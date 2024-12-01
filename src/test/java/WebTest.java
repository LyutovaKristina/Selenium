import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/lyuto/OneDrive/Рабочий стол/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            driver.get("https://www.mts.by");


            WebElement blockTitleElement = By.xpath("//h2[contains(text(),'Онлайн пополнение без комиссии')]").findElement(driver);
            String blockTitle = blockTitleElement.getText();
            System.out.println("Название блока: " + blockTitle);

            if (blockTitle.equals("Онлайн пополнение без комиссии")) {
                System.out.println("Название блока соответствует ожидаемому!");
            } else {
                System.out.println("Название блока НЕ соответствует ожидаемому.");
            }


            String[] logoSelectors = {
                    "/html/body/div[6]/main/div/div[3]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[1]/img",
                    "/html/body/div[6]/main/div/div[3]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[2]/img",
                    "/html/body/div[6]/main/div/div[3]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[3]/img",
                    "/html/body/div[6]/main/div/div[3]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[4]/img",
                    "/html/body/div[6]/main/div/div[3]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[5]/img"
            };

            for (String selector : logoSelectors) {
                try {

                    WebElement logo = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners"));

                    if (logo.isDisplayed()) {
                        System.out.println("Логотип " + selector + " отображается на странице.");
                    } else {
                        System.out.println("Логотип " + selector + " НЕ отображается на странице.");
                    }
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.out.println("Логотип " + selector + " не найден.");
                }
            }

            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
            button.click();

            wait.until(ExpectedConditions.urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Текущий URL: " + currentUrl);

            if (currentUrl.equals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/")) {
                System.out.println("Переход по ссылке выполнен успешно!");
            } else {
                System.out.println("Ошибка: переход по ссылке не выполнен.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

/* ни в какую у меня не получается.Подскажите, пожалуйста, где искать ошибки...Создала новый репо, так как со старым не смогла подружить и потратила много времени.*\