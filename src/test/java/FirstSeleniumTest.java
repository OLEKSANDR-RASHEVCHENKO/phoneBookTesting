import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    public WebDriver driver;

    @Test
    public void firstSeleniumTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://phonebook.telran-edu.de:8080/user/login");
        driver.manage().window().maximize();
        //name
        WebElement elementVariantNameOne = driver.findElement(By.xpath("//*[@name='email']"));
        WebElement elementVariantNameTwo = driver.findElement(By.cssSelector("//*[@name='email']"));
        WebElement elementVariantNameThree = driver.findElement(By.name("email"));

        //id
        WebElement elementVariantIdOne = driver.findElement(By.xpath("//*[@id='login-form']//*[@id='defaultRegisterFromEmail']"));
        WebElement elementVariantIdTwo = driver.findElement(By.cssSelector("[@id='defaultRegisterFromEmail']"));
        WebElement elementVariantIdThree = driver.findElement(By.cssSelector("#defaultRegisterFromEmail"));
        WebElement elementVariantIdFour = driver.findElement(By.id("defaultRegisterFromEmail"));

        //class -bad practice

        WebElement elementVariantClassOne = driver.findElement(By.xpath("//*[@id='login-form']//*[@class='form-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid']"));
        WebElement elementVariantClassTwo = driver.findElement(By.xpath("//*[contains(@class, 'from-control mb-2']"));
        WebElement elementVariantClassThree = driver.findElement(By.cssSelector("[@class= 'from-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid']"));
        WebElement elementVariantClassFour = driver.findElement(By.cssSelector(".from-control.mb-2.rounded-pill.ng-untouched.ng-pristine ng-invalid"));
        WebElement elementVariantClassFive = driver.findElement(By.id("from-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid"));

        driver.quit();
    }
}
