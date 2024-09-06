import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class BrokenImageExample {
    WebDriver driver;

    @BeforeMethod
    public void openImagePage() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();

        File file = new File("C:\\Users\\ASUS\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
        chromeOptions.addExtensions(file);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }
    @Test
    public void findBrokenImageTest(){
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));

        // if naturalWidth = 0 equal
        // then the images are broken
        for (WebElement image:images
             ) {
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image is broken");
            }
            else {
                System.out.println("Image is not broken");
            }

        }
    }


    }

