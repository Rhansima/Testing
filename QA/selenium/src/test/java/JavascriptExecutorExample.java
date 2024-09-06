import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptExecutorExample {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void openJSExecutorPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

    }
    @Test
    public void jsExecutorTests() throws InterruptedException {

         jsExecutor =(JavascriptExecutor) driver;

        //1) get a alert box in to web page using js
        jsExecutor.executeScript("alert('my name is hansima');");


        //2) set a input value in a text box using javascript executor

            //1 way -> set the value using the value property(common approach)
 WebElement inputNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));


//        jsExecutor.executeScript("arguments[0].value='hansima rajapaksha';", inputNameTextBox);

            // 2 way -> set the value using set attribute (alternative approach)
        jsExecutor.executeScript("arguments[0].setAttribute('value','Hansima Rajapaksha');", inputNameTextBox);
        Thread.sleep(3000);


        //3) hightlight element
        jsExecutor.executeScript("arguments[0].style.border='3px solid red';", inputNameTextBox);
        jsExecutor.executeScript("arguments[0].style.background='yellow';",inputNameTextBox);



        //4) click elemenet using javascriptexecutor
        WebElement maleCheckBox = driver.findElement(By.xpath("//input[@id='male']"));
        jsExecutor.executeScript("argument[0].click();",maleCheckBox);

        Thread.sleep(3000);

        //5) scrolling the page
        scrollPage();

        //6) get all attributes from a wanted element
        


    }

    public void scrollPage() throws InterruptedException {
        //5.1) scroll to same position
        jsExecutor.executeScript("window.scrollTo(0,1000);");
        System.out.println("current pageYOffset value is: " +jsExecutor.executeScript("return window.pageYOffset;"));
        jsExecutor.executeScript("window.scrollTo(0,-1000);");
        Thread.sleep(3000);





        //5.2) scroll to bottom of the page by pixel number
        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(3000);


        //5.3) scroll to the top of the page
        jsExecutor.executeScript("window.scrollTo(0,0);");
        Thread.sleep(3000);

        //5.4) scroll the page till element is visible
        WebElement scrollintoElement = driver.findElement(By.xpath("//label[text()='Gender:']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", scrollintoElement);
        Thread.sleep(3000);


    }
}
