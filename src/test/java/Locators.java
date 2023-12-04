import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {
    public WebDriver driver;


    //name
    WebElement elementVariantNameEmailOne = driver.findElement(By.xpath("//*[@name='email']"));
    WebElement elementVariantNameEmailTwo = driver.findElement(By.cssSelector("//*[@name='email']"));
    WebElement elementVariantNameEmailThree = driver.findElement(By.name("email"));

    //id
    WebElement elementVariantIdOne = driver.findElement(By.xpath("//*[@id='login-form']//*[@id='defaultRegisterFromEmail']"));
    WebElement elementVariantIdTwo = driver.findElement(By.cssSelector("[@id='defaultRegisterFromEmail']"));
    WebElement elementVariantIdThree = driver.findElement(By.cssSelector("#defaultRegisterFromEmail"));
    WebElement elementVariantIdFour = driver.findElement(By.id("defaultRegisterFromEmail"));

    //class -bad practice

    WebElement elementVariantClassOne = driver.findElement(By.xpath("//*[@id='login-form']//*[@class='form-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid']"));
    WebElement elementVariantClassTwo = driver.findElement(By.xpath("//*[contains(@class, 'from-control mb-2']"));
    WebElement elementVariantClassThree = driver.findElement(By.cssSelector("[@class= 'from-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid']"));
    WebElement elementVariantClassFour = driver.findElement(By.cssSelector(".from-control.mb-2.rounded-pill.ng-untouched.ng-pristine.ng-invalid"));
    WebElement elementVariantClassFive = driver.findElement(By.id("from-control mb-2 rounded-pill ng-untouched ng-pristine ng-invalid"));





    //Password
    //name
    WebElement elementVariantNamePasswordOne = driver.findElement(By.xpath("//*[@name='password']"));
    WebElement elementVariantNamePasswordTwo = driver.findElement(By.cssSelector("//*[@name='password']"));
    WebElement elementVariantNamePasswordThree = driver.findElement(By.name("password"));

    //id
    WebElement elementPlaceHolderOne = driver.findElement(By.xpath("//*[placeholder='Password']"));
    WebElement elementPlaceHolderTwo = driver.findElement(By.cssSelector("['Password']"));
    WebElement elementPlaceHolderThree = driver.findElement(By.cssSelector("#Password"));
    WebElement elementPlaceHolderFour = driver.findElement(By.id("Password"));

    //class -bad practice

    WebElement elementVariantClassPasswordOne = driver.findElement(By.xpath("//*[@id='login-form']//*[@class='form-control rounded-pill ng-untouched ng-pristine ng-invalid']"));
    WebElement elementVariantClassPasswordTwo = driver.findElement(By.xpath("//*[contains(@class, 'form-control']"));
    WebElement elementVariantClassPasswordThree = driver.findElement(By.cssSelector("[@class= 'form-control rounded-pill ng-untouched ng-pristine ng-invalid']"));
    WebElement elementVariantClassPasswordFour = driver.findElement(By.cssSelector(".form-control.rounded-pill.ng-untouched.ng-pristine.ng-invalid"));
    WebElement elementVariantClassPaswordFive = driver.findElement(By.id("form-control rounded-pill ng-untouched ng-pristine ng-invalid"));

}
