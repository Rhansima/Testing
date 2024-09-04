import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboardExample {
    WebDriver driver;

    @BeforeMethod
    public void keyboardOperationsTestsBrowserOpen() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void KeyBoardActionsTest1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement googlebar = driver.findElement(By.xpath("//*[@id=\'APjFqb\']"));
        googlebar.sendKeys("Welcome");
        Thread.sleep(3000);
        Actions actions = new Actions(driver); //create action newly
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); //select all text
        Thread.sleep(5000);

        actions.keyDown(Keys.SHIFT)
                .sendKeys("writing capital sentences").perform();
        Thread.sleep(3000);

        actions.keyUp(Keys.SHIFT)
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .perform();



    }

    @Test
    public void KeyBoardActionsTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(3000);

        List<WebElement> selectable = driver.findElements(By.xpath("//*[@id=\'pickList\']/div[2]/ul/li"));
        int size = selectable.size();
        System.out.println("li count is : "+ size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();
    }
}
