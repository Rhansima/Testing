//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.http.WebSocket;

public class OpenGoogle {

    //open google
    //go to google home page


    public static void main(String[] args){
//        System.setProperty("webdriver.chrome.driver","E:\\QA\\Driver\\chromedriver-win64\\chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }
}
