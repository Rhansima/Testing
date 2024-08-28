import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");

    }

    @Test
    public void leafgroundpageDropDownTest() throws InterruptedException {
        //1.1) ways of select values in basic dropdown

        WebElement dropDown = driver.findElement(By.xpath("//select[@class=\"ui-selectonemenu\"]"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);


        //1.2) get the number of dropDown options
        //list of web elements (generics)
        List<WebElement> ListofOptions =select.getOptions();
        int size = ListofOptions.size();
        System.out.println("No of elemets in deopDown : " + size);

        for (WebElement element:ListofOptions
             ) {
            System.out.println(element.getText());

        }


        //1.3) using sendKeys select dropdown value
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);


        //1.4) selecting value in a bootstrap dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listofdropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']"));
        for (WebElement element :listofdropdown2values
             ) {
            String dropDownvalue = element.getText();
            if (dropDownvalue.equals("USA")){
                element.click();
                break;
            }

        }



    }




        //2) google search - pick a value from suggestions






        //3) Handle hidden auto suggestions drop down and search using DOM debugger trick


}
