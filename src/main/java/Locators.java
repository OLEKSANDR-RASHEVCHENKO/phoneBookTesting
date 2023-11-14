import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

    public WebDriver driver;
    //name
    WebElement elementVariantNameOne = driver.findElement(By.xpath("//*[@name=\"email\"]"));
    WebElement elementVariantNameTwo = driver.findElement(By.cssSelector("//*[@name=\"email\"]"));
    WebElement elementVariantNameThree = driver.findElement(By.name("email"));

    // id
    WebElement elementVariantOne = driver.findElement(By.xpath("//*[@id=`id=`login-form`]//*[@id=`defaultRegisterFormEmail`]"));
    WebElement elementVariantTwo = driver.findElement(By.cssSelector("//*[@id=`defaultRegisterFormEmail`]"));
    WebElement elementVariantThree = driver.findElement(By.cssSelector("@defaultRegisterFormEmail"));
    WebElement elementVariantFour = driver.findElement(By.id("defaultRegisterFormEmail"));

    //class -bad practice
    WebElement elementVariantClassOne = driver.findElement(By.xpath("//*[@id='login-form']//*[@class='form-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid']"));
    WebElement elementVariantClassTwo = driver.findElement(By.xpath("//*[contains(@class, 'form-control mb-2')]"));
    WebElement elementVariantClassThree = driver.findElement(By.cssSelector("[class='form-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid']"));
    WebElement elementVariantClassFour = driver.findElement(By.cssSelector(".form-control.mb-2.rounded-pill.ng-untouched.ng-pristine.ng-invalid"));
    WebElement elementVariantClassFive = driver.findElement(By.className("form-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid"));
}
