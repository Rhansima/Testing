import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadfileExample {

    WebDriver driver;

    @BeforeMethod
    public void windowTestPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(3000);

        //check the file is there
        File file = new File("C:\\Users\\ASUS\\Downloads");
        File[] totalFiles = file.listFiles();
        for (File findFile :totalFiles
             ) {
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is Downloaded");
                break;
            }

        }

    }

    @Test
    public void fileUploadTest() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");

        //1 st way - using robot class
        WebElement uploadButton = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadButton.click();

        //windows control begin here
        String data = "C:\\Users\\ASUS\\Downloads\\TestLeaf Logo.png";
//        StringSelection selection = new StringSelection(data);
//        //COPYING PATH TO CLIPBOARD
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
//
//        Thread.sleep(4000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        Thread.sleep(4000);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement uploadusingsendkeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadusingsendkeys.sendKeys(data);


    }
}

