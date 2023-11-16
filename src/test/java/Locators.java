import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

    public WebDriver driver;

    //name
    WebElement elementVariantNameOne = driver.findElement(By.xpath("//*[@name='email']"));
    WebElement elementVariantNameTwo = driver.findElement(By.cssSelector("[@name='email']"));
    WebElement elementVariantNameThree = driver.findElement(By.name("mail"));

    //id
    WebElement elementVariantIdOne = driver.findElement(By.xpath("//*[@id='login-form']//*[id='defaultRegisterFormEmail']"));
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

    WebElement elementVariantPasswordOne = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
    WebElement elementVariantPasswordTwo = driver.findElement(By.xpath("//*[@placeholder='Password']"));
    WebElement elementVariantPasswordThree = driver.findElement(By.className("form-control rounded-pill ng-pristine ng-invalid ng-touched"));
    WebElement elementVariantPasswordFour = driver.findElement(By.cssSelector("[class='form-control rounded-pill ng-pristine ng-invalid ng-touched']"));

    WebElement elementVariantLoginOne = driver.findElement(By.className("btn btn-info my-1 btn-block"));
    WebElement elementVariantLoginTwo = driver.findElement(By.cssSelector("[@type='submit']"));
    WebElement elementVariantLoginThree = driver.findElement(By.xpath("//*[@type='submit']"));



}
