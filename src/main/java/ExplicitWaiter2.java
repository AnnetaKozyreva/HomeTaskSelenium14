import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaiter2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rozetka.com.ua/");
            new WebDriverWait(driver, Duration.ofSeconds(4))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("fat-menu")));
            WebElement katalog = driver.findElement(By.id("fat-menu"));
            System.out.println(katalog.getText());
            driver.findElement(By.id("fat-menu")).click();
        try {
            List<WebElement> compMenu = driver.findElements(By.xpath("//li[1]//div[1]/div[2]/ul[2]/li/ul/li[@class = 'ng-star-inserted']"));
            for (WebElement c : compMenu) {
                System.out.println("Filter elements :" + c.getText());
            }
            compMenu.get(0).click();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error! List compMenu is empty");
        }
        try{
            WebElement filterRozetka = driver.findElement(By.xpath("//a[@data-id='Rozetka']"));
            filterRozetka.click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Mонитор 27\" Samsung Odyssey G5 LC27G54T Black (LC27G54TQWIXCI)']")));
            WebElement firstMonitor = driver.findElement(By.xpath("//a[@title='Mонитор 27\" Samsung Odyssey G5 LC27G54T Black (LC27G54TQWIXCI)']"));
            firstMonitor.click();

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//app-product-credit[@class='product__credit']")));
            WebElement button = driver.findElement(By.xpath("//app-product-credit[@class='product__credit']"));

            System.out.println("Current URL is :" + driver.getCurrentUrl());
            System.out.println("Current Title is :" + driver.getTitle());

        } finally {
            driver.quit();

        }
    }
}