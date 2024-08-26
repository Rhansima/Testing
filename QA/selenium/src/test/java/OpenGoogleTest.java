import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class OpenGoogleTest {

    @Test
    public void googleTest(){
        //        System.setProperty("webdriver.chrome.driver","E:\\QA\\Driver\\chromedriver-win64\\chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("122");
        chromeOptions.addArguments("--start.maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com/");


        driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);
//        driver.quit();
    }
}
