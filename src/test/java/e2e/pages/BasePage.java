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


// общие методы, кот используем в  Page
public class BasePage {
    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Wait getWait() {
        return new Wait(driver);
    }

    public Select getSelect(WebElement element) {
        return new Select(element);
    }

    // метод кот находит элемент
    protected boolean isElementDisplayed(WebElement element) { // указываем типизацию элемента в аргументах
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) { // из селениеума
            return false;
        }
    }

    // заполняет импут там где это нужно, будем к нему обращаться, то что заменили в AddContactDialog
    protected void setInput(WebElement input, String value) { // input - сам элемент, локатор из FindBy(firstNameInput)
        // value -это уже само значение, кот мы будем вводить(firstName...)

        input.click();
        input.clear();
        input.sendKeys(value);

    }

    private File takeScreenshot(WebElement element) {
        File tmp;
        if (element == null) { // делает скриншот всей страницы
            tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("Take screenshot page");
        } else { // делает скриншот элемента
            tmp = element.getScreenshotAs(OutputType.FILE);
            System.out.println("Take screenshot element");
        }
        return tmp;


    }

    private double calculateMaxDifferentPercentRation() {
        // Размеры картинки
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        // макс допустимая погрешность
        return 0.01 * width * height;

    }


    private Process setCompareCommadToTerminal(String referenceImageFilePath, String tmpFilePath) throws IOException {
        // вводит комманды compare,metric..... в терминал
        ProcessBuilder pb = new ProcessBuilder("compare", "-metric", "AE", referenceImageFilePath, tmpFilePath, "null:");
        System.out.println("Set compare command to terminal");
        return pb.start();
    }

    private double getDifferenceFromLogs(BufferedReader reader) throws IOException {
        // читает каждую строку в терминале
        String line;
        double difference = 0;
        while ((line = reader.readLine()) != null) {//читает строки пока они есть
            difference = Integer.parseInt(line.trim()); // преобразовываем стрнгу в число и подставляет в дифференц..
        }
        return difference;

    }


    protected void takeAndCompareScreenshot(String actualScreenshotName, WebElement element){
        String referenceImageFilePath = "reference/" + actualScreenshotName + ".png"; //
        String tmpFilePath = "reference/tmp_" + actualScreenshotName + ".png";
        File tmp = takeScreenshot(element);
        try {


            // копируем из временной дир. тмп
            Files.copy(tmp.toPath(), new File(tmpFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);

            // если данные референс
            File referenceImageFile = new File(referenceImageFilePath);
            if (!referenceImageFile.exists()) { // если нет эталонного файла, то выдать ошибку
                throw new RuntimeException("Reference image file does not exist, but there is tmp file, need remove tmp_ from name file" + tmpFilePath);
            }

            double maxDiffPercent = calculateMaxDifferentPercentRation();
            Process process = setCompareCommadToTerminal(referenceImageFilePath, tmpFilePath);
            // процесс кот. запускает ридер и читаем из буфера логи, строки
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            double difference = getDifferenceFromLogs(reader);
            reader.close(); // закрываем процесс
            process.destroy(); //

            if (difference > maxDiffPercent) {
                // одно эталонное изобр не соответствует актуальному
                throw new RuntimeException(referenceImageFilePath + " not equal " + tmpFilePath + " difference: " + difference);
            }
            //удаляет актуальные, чтоб незасорять комп
            Files.deleteIfExists(new File(tmpFilePath).toPath());
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}