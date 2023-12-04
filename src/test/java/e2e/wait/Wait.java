package e2e.wait;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Wait {

    public WebDriver driver;

    Duration TIMEOUT = Duration.ofSeconds(10);

    public Wait(WebDriver driver){
        this.driver = driver;
    }

    public WebDriverWait setWait(){
        return new WebDriverWait(driver, TIMEOUT);
    }

    public void forVisibility(WebElement element){
        try {
            setWait().until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e){
            e.printStackTrace();
        }
    }
    public void forAllVisibility(List<WebElement> elements){
        try {
            setWait().until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException e){
            e.printStackTrace();
        }
    }
    public void forInvisibility(WebElement element){
        try {
            setWait().until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e){
            e.printStackTrace();
        }
    }
    public void forClickable(WebElement element){
        try {
            setWait().until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e){
            e.printStackTrace();
        }
    }

}
