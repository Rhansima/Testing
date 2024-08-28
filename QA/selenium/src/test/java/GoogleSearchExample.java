import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearchExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googlesearchlist = driver.findElements(By.xpath("//ul[@role =\"listbox\"]/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchlist.size());
        for (WebElement element:googlesearchlist
             ) {
            System.out.println(element.getText());


        }



    }



}
