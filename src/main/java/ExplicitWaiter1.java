import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ExplicitWaiter1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://www.google.com");
            WebElement searchBox = driver.findElement(By.name("q"));
            System.out.println("Search field is displayed :" + searchBox.isDisplayed());
            searchBox.sendKeys("rozetka ua");
            searchBox.submit();
    try {
            WebElement searchResults = driver.findElement(By.id("taw"));
            String firstResultTitle = searchResults.findElement(By.xpath("//*[@id=\"tads\"]//a//span")).getText();
            System.out.println("First result title is :" + firstResultTitle);
            List<WebElement> allResultTitle = driver.findElements(By.xpath("//*[@id=\"tads\"]//a//span"));
            allResultTitle.get(0).click();
    }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error! List  allResultTitle is empty");
        }
            System.out.println("Current URL is :" + driver.getCurrentUrl());
            System.out.println("Current Title is :" + driver.getTitle());
            WebElement rozetkaSearch = driver.findElement(By.xpath("*//form//input"));
            System.out.println("Search field is displayed :" + rozetkaSearch.isDisplayed());
            rozetkaSearch.sendKeys("стул");
            rozetkaSearch.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='goods-tile__title']")));
            WebElement prodId = driver.findElement(By.xpath("//span[@class='goods-tile__title']"));
            System.out.println("Product is displayed :" + prodId.isDisplayed());
    try{
            List<WebElement> ProdId = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
            List<WebElement> searchProdId = driver.findElements(By.className("goods-tile__title"));
            for (WebElement b : searchProdId){
                System.out.println("Search prod :");
                System.out.println(b.getText());
            }
            ProdId.get(0).click();
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Error! List searchProdId is empty");
    }
    try{
            System.out.println("Current URL is :" + driver.getCurrentUrl());
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//li[1][@class='product-buttons__item ng-star-inserted']")));
            WebElement productButton = driver.findElement(By.xpath("//li[1][@class='product-buttons__item ng-star-inserted']"));
            productButton.click();
        System.out.println("Buy Button is displayed :" + productButton.isDisplayed());

    }finally {
            driver.quit();
        }
    }
}