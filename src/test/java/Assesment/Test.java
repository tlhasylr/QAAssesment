package Assesment;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url= "https://ec2instances.info/";
        driver.get(url);

        driver.findElement(By.xpath("//a[contains(text(),'RDS')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //task1

        String ExpectedResult="EC2Instances.info Easy Amazon RDS Instance Comparison";


        String actualResult= driver.findElement(By.xpath("/html/body/div[1]/h1")).getText();

        System.out.println(actualResult);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Assert.assertEquals(ExpectedResult, actualResult);

        Boolean b= actualResult.contains("RDS");
        System.out.println("Header contains RDS :" +b);


        // task2

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String Before = driver.findElement(By.xpath("//*[@id=\'db.m3.medium\']/td[1]"))
                .getCssValue("background-color");

        driver.findElement(By.xpath("//*[@id=\'db.m3.medium\']/td[1]")).click();

        String After = driver.findElement(By.xpath("//*[@id=\'db.m3.medium\']/td[1]"))
                .getCssValue("background-color");

      if (Before!=After){
          System.out.println("Background color has been changed after click");
      }else{
          System.out.println("Background color does not change");
      }






driver.close();
driver.quit();





    }




}
