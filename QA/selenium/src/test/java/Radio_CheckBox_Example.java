import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_CheckBox_Example {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void radioTests(){
        //find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeradiooption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxradiooption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradiooption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradiooption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if(chromeradiooption){
           String chrometext = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:0\"]")).getText();
            System.out.println("default select radio button is : " + chrometext);
        } else if (firefoxradiooption) {
            String firefoxtext = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:1\"]")).getText();
            System.out.println("default select radio button is : " + firefoxtext);
            
        } else if (safariradiooption) {
            String safaritext = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:2\"]")).getText();
            System.out.println("default select radio button is : " + safaritext);

        } else if (edgeradiooption) {
            String edgetext = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:3\"]")).getText();
            System.out.println("default select radio button is : " + edgetext);

        }


        //select the age group (only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if(!isChecked){
           // myAgeGroup.click();
            driver.findElement(By.xpath("//label[@for=\"j_idt87:age:0\"]")).click();

        }






    }

    @Test
    public void checkBoxTest(){
        //select wanted checkboxes and verifying those checkboxes selected status

        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id=\"j_idt87:basic\"]//label"));
        for ( WebElement element:checkBoxList
             ) {
            if(!(element.getText().equals("Others"))){
                element.click();
            }

        }
       for (int i=0; i<=checkBoxList.size(); i++){
          boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id=\"j_idt87:basic\"]//input)[" + i+"]")).isSelected();
           System.out.println("Checkbox " + i+ "selected status is : "+checkBoxStatus);
       }








    }
}
