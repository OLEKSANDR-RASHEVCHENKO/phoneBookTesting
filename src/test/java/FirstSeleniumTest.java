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
        WebElement elementVariantNametOne = driver.findElement(By.xpath("//*[@name='email']"));
        WebElement elementVariantNameTwo = driver.findElement(By.cssSelector("[name='email']"));
        WebElement elementVariantNameThree = driver.findElement(By.name("email"));

        // id

        WebElement elementVariantIdtOne = driver.findElement(By.xpath("//*[@id='login-form']//*[@id='defaultRegisterFormEmail']"));
        WebElement elementVariantIdTwo = driver.findElement(By.cssSelector("[id='defaultRegisterFormEmail']"));
        WebElement elementVariantIdThree = driver.findElement(By.cssSelector("#defaultRegisterFormEmail"));
        WebElement elementVariantIdFour = driver.findElement(By.id("defaultRegisterFormEmail"));


        //class -bad practice
        WebElement elementVariantClassOne = driver.findElement(By.xpath("//*[@id='login-form']//*[@class='form-control mb-2 " +
                "rounded-pill ng-untouched ng-pristine ng-invalid']"));
        WebElement elementVariantClassTwo = driver.findElement(By.xpath("//*[contains(@class, 'form-control mb-2')]"));
        WebElement elementVariantClassThree = driver.findElement(By.cssSelector("[class='form-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid']"));
        WebElement elementVariantClassFour = driver.findElement(By.cssSelector(".form-control.mb-2.rounded-pill.ng-untouched.ng-pristine.ng-invalid"));
        WebElement elementVariantClassFive = driver.findElement(By.className("form-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid"));

        // password

        WebElement elementVariantPasswordOne = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
        WebElement elementVariantPasswordTwo = driver.findElement(By.cssSelector("[name='password']"));
        WebElement elementVariantPasswordThree = driver.findElement(By.name("password"));

        // email
        WebElement elementVariantEmailOne = driver.findElement(By.xpath("//*[@id='defaultRegisterFormEmail']"));
        WebElement elementVariantEmailTwo = driver.findElement(By.cssSelector("[name='email']"));
        WebElement elementVariantEmailThree = driver.findElement(By.name("email"));


        driver.quit();
    }
}
