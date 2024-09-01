import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowExample {
    WebDriver driver;

    @BeforeMethod
    public void windowTestPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);



    }
    @Test
    public void windowTests() throws InterruptedException {
        //click and confirm new windows opens

       String oldWindow = driver.getWindowHandle();
       System.out.println("parent window : " + oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//*[@id=\'j_idt88:new\']"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("handle size : "+ handles.size()); //parent and child window sizes come out for  this sout




            //first method - using for each loop
//        for (String newWindow :handles
//             ) {
//            System.out.println(newWindow);
//            driver.switchTo().window(newWindow); //switch to child window
//            System.out.println("page title is : " + driver.getTitle());
//
//        }
//        driver.close();
//
//        driver.switchTo().window(oldWindow);




            // second method-using list

        List<String> list = new ArrayList<String>(handles); //converting set to the list
        if(list.size() > 1){
            driver.switchTo().window(list.get(1));
            System.out.println("child tab is : " + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }
        //check the open button element

        WebElement openButton1 = driver.findElement(By.xpath("//*[@id=\'j_idt88:new\']"));
        Boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("open button visibility" + openbuttonVisibility);

        //find the number of opened tans
        WebElement multiWindow = driver.findElement(By.xpath("//*[@id=\'j_idt88:j_idt91\']"));
        multiWindow.click();
        Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int howmanyWindows = multiWindows.size();
        System.out.println("No of windows opened : " + howmanyWindows);


        //close all windows except primary

        WebElement dontclosemeButton = driver.findElement(By.id("j_idt88:j_idt93"));
        dontclosemeButton.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandles = driver.getWindowHandles();
        for (String allwindows:newWindowsHandles
             ) {

            //close the every child windows seperatly and remain the parent window only
            if(!allwindows.equals(oldWindow)){
                driver.switchTo().window(allwindows);
                driver.close();

            }

        }
//        driver.switchTo().window(oldWindow);
//        driver.close(); //close single browser window driver which on focus

        driver.quit();   //close all browser windows
        
    }


}
