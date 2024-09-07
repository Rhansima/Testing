package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshotExample {
    WebDriver driver;

    @BeforeMethod
    public void openWebPage(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void takeScreenshotTests() throws IOException, AWTException {

        // capture screenshots of web page
        //this is the interface
//    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        File sourceFile=   takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_full_web_page.png" );
//        FileHandler.copy(sourceFile,destinationFile);





        // capture screenshot of section of a web page
//        WebElement section1pageElement = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]"));
//        File source= section1pageElement.getScreenshotAs(OutputType.FILE);
//        File target = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_section_of_the_Page.png");
//        FileUtils.copyFile(source,target);

        //capture screenshot of an element on a web page

//        WebElement elementPageElement = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]/div[1]"));
//        File source1= section1pageElement.getScreenshotAs(OutputType.FILE);
//        File target1 = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "element_of_the_Page.png");
//        FileUtils.copyFile(source1,target1);


        // capture screenshots of web page
        //this is the interface
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        File sourceFile=   takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_full_web_page.png" );
//        FileHandler.copy(sourceFile,destinationFile);


        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();




        //capture screenshot of full entire screenshot
        Robot robot = new Robot();
       Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
       Rectangle rectangle = new Rectangle(screenSize);
       BufferedImage source2 = robot.createScreenCapture(rectangle);
        File destinationFile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_page_entire_web_page.png" );
        ImageIO.write(source2,"png",destinationFile);







    }
}
