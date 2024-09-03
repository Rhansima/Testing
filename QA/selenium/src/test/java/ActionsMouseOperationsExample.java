import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsMouseOperationsExample {
    WebDriver driver;

    @BeforeMethod
    public void mouseOperationsTestBrowserOpen() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();



    }
    @Test
    public void mouseOperationsTest1() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("1) <<<<<<<<<<Move to an element operation>>>>>>>>>>>");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();



        System.out.println("2) <<<<<<<<<<<Drag & Drop operation>>>>>>>>>> ");
        WebElement from = driver.findElement(By.id("form:drag_content"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //1 st way

//        actions.clickAndHold(from).moveToElement(to).release(to).perform();

        //2nd way
        actions.dragAndDrop(from, to).perform();





        System.out.println("3) <<<<<<<<<<<<Slider operation >>>>>>>>>>>>>>");
        WebElement sliderpoint1 =  driver.findElement(By.xpath("//*[@id=\'form:j_idt125\']/span[1]"));
        System.out.println("Location of before moving : " + sliderpoint1.getLocation());
        actions.dragAndDropBy(sliderpoint1 ,50,0).perform();
        System.out.println("Location of before moving : " + sliderpoint1.getLocation());


    }

    @Test
    public void mouseOperationsTest2() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        System.out.println("04) <<<<<<<<<<< Right click>>>>>>>>>>>");

        WebElement rightClickButtonElement = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));

        Actions actions1 = new Actions(driver);
        actions1.contextClick(rightClickButtonElement).perform();
        driver.findElement(By.xpath("/html/body/ul/li[1]")).click();
        Alert pop = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println("Alert the text as : " + pop);
        pop.accept();

    }
}
