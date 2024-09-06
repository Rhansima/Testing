package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebtableExample {
    WebDriver driver;

    @BeforeMethod
    public void mouseOperationsTestBrowserOpen() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");


    }
    @Test
    public void webTableTest() throws InterruptedException {
        //1) how many rows in the table
        int rowCount=  driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("row count is "+ rowCount);

        //2) how many columns in the table
        int columnCount=  driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("row count is "+ columnCount);


        //3) retrieve the specific row / column data
        String retrieveData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("retrieve data is : " + retrieveData);


        //4) retrieve all the data from table
        for (int i=1; i<rowCount ; i++){ //rows
           for (int j=1; j<columnCount ; j++){ //columns
               String tbData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
               System.out.println(tbData + " ");


           }
            System.out.println();
        }

        //5) print ID and name only
        //5.1) find the product price whichname related to product 3
        for (int i=0; i<=rowCount; i++){
            String tblId = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String tblName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println("Tbl id : " + tblId + "Name: " + tblName);

            if (tblName.equals("Product 3")){
                String productPrice =driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(tblName + "relevent product price is : "+ productPrice);
                break;

            }

        }







        //6) select all the checkboxes
        int pageCount = driver.findElements(By.xpath("//*[@id='pagination']/li")).size();
        List<WebElement> pages = driver.findElements(By.xpath("//*[@id='pagination']/li"));

        for (int k=0; k<pageCount; k++){
            pages.get(k).click();
            Thread.sleep(1000);
            for (int i=1; i<=rowCount; i++){
               boolean atb =  driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[+i+]/td[4]/input")).isSelected();
               if (!atb){
                   driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[+i+]/td[4]/input")).click();
                   Thread.sleep(3000);
               }
            }
        }





        //7) select one checkbox
        int tblRow =1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[+i+]/td[4]/input")).click();
    }
    }
