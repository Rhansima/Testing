import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {
    WebDriver driver;

    @BeforeMethod
    public void frameTestPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
        Thread.sleep(3000);

    }

    @Test
    public void frameTests(){

        //1) Click Me(Inside frame)
        //frames = html page , inside main html page(need to switch one time)
            //html
                //html


        driver.switchTo().frame(0);
        WebElement button1 = driver.findElement(By.xpath("//*[@id=\'Click\']"));
        button1.click();

        String afterlinkbuttonText = button1.getText();
        System.out.println("After click inside frame button text : " + afterlinkbuttonText);

        //2) Click Me(Inside Nested Frame)
        driver.switchTo().defaultContent(); //present to main html page
        driver.switchTo().frame(2); //inside into third frame
        driver.switchTo().frame("frame2"); //child frame

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedframebuttontext = button3.getText();
        System.out.println("After click inside nested frame button text : " + afterClickNestedframebuttontext);



        //nested frame= need to switch two times
            //html
                 //html
                    //html


        //3) Click Me(How many frames in this page)
        driver.switchTo().defaultContent();
        List<WebElement> getiframeTagcount = driver.findElements(By.tagName("iframe"));
        int size = getiframeTagcount.size();
        System.out.println("Iframe count : " + size);

    }
}
