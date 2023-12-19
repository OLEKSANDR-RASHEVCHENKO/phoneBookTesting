package e2e.pages;

import e2e.Wait.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public Wait getWait() {
        return new Wait(driver);
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Select getSelect(WebElement element) {
        return new Select(element);
    }

    protected void setInput(WebElement input, String value) {
        input.click();
        input.clear();
        input.sendKeys(value);
    }

    private File takeScreenshot(WebElement element) {
        File tmp;
        if (element == null) {
            tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("Take screenshot page");
        } else {                                                                   //Делает скрин полной страницы или отдельного элемента
            tmp = element.getScreenshotAs(OutputType.FILE);
            System.out.println("Take screenshot element");
        }

        return tmp;
    }
    private double calculateMaxDifferentPercentRation(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;//размер скрина
        //-----------------------------------------------------------------------------------------------------------------------

        return 0.01 * width * height;// погрешность допустимая
        //-----------------------------------------------------------------------------------------------------------------------
    }
    private Process setCompareCommandToTerminal(String refImgFilePath,String tmpFilePath) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\ImageMagick-7.1.1-Q16\\magick.exe", "compare", "-metric", "AE", refImgFilePath, tmpFilePath, "null:");
        System.out.println("set compare command to terminal");
        return pb.start();//команда которая вводится в терминал для поиска скрина и нажимаем ентер
    }
    private  double getDifferenceFromLogs(BufferedReader reader) throws IOException {
        String line;
        double difference = 0;
        while ((line = reader.readLine()) != null) {
            difference = Integer.parseInt(line.trim());
        }
        return difference;//читаем по сути эти логи и приобразовуем в число
    }


    protected void takeAndCompareScreenshot(String actualScreenshotName, WebElement element)  {
        String referenceImageFilePath = "reference/" + actualScreenshotName + ".png";
        String tmpFilePath = "reference/tmp_" + actualScreenshotName + ".png";
        File tmp = takeScreenshot(element);
        try {
            Files.copy(tmp.toPath(), new File(tmpFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);// копируем скриншот из временной деректории в  референс
            File referenceImageFile = new File(referenceImageFilePath);
            if (!referenceImageFile.exists()) {
                throw new RuntimeException("Reference image file does not exist ,but there is tmp file, need remove tmp_ from name file" + tmpFilePath);
            }
            double maxDiffPercent = calculateMaxDifferentPercentRation();
            Process process = setCompareCommandToTerminal(referenceImageFilePath, tmpFilePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));// запускаем ридер + пытаемся получить ошибки+читаем логи
            double difference = getDifferenceFromLogs(reader);
            reader.close();
            process.destroy();

            if (difference > maxDiffPercent) {
                throw new RuntimeException(referenceImageFilePath + " not equal " + tmpFilePath + " difference: " + difference);
            }// проверяем что погрешность не выходит за рамки
            //------------------------------------------------------------------------------------------------------------------------
            Files.deleteIfExists(new File(tmpFilePath).toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
