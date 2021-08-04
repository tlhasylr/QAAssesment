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

        String ExpectedResult="EC2Instances.info Easy Amazon RDS Instance Comparison";
        WebElement actualResult= (WebElement) driver.findElements(By.xpath("//body/div[1]/h1[1]"));


        List<WebElement> listOfElements = driver.findElements(By.xpath("//body/div[1]/h1[1]"));

        System.out.println(listOfElements);


        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     // Assert.assertEquals("EC2Instances.info Easy Amazon RDS Instance Comparison", actualResult);




driver.close();
driver.quit();





    }




}
