package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitDemo {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));   // load the page within 10 seconds
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void implicitWaitTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        String newBtnText = driver.findElement(By.xpath("//span[contains(text(),'I am here')]")).getText();
        System.out.println("new button text is: " + newBtnText);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
