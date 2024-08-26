import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException{

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("122");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        //Thread.sleep(3000);

    }
    public void textBoxTests(){
        //01) type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Hansima Rajapaksha");

        //02) Append Country to this city
        WebElement appendText =driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("Sri Lanka");

        //03) Verify if text is disabled
        boolean enabled =driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box enabled" + enabled);

        //04) clear the type text
        //Xpath=//tagname[@attribute='value']
        //*[@id="j_idt88:j_idt95"]
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //retrieve the typed text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        //06) type email and Tab. confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("hansima@gmail.com" + Keys.TAB + "confirmed control moved to next element" );





    }

}
