package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class homework02 {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }
    @Test
    public  void test01(){
        driver.navigate().refresh();
        String baslik = driver.getTitle();
        String istenen = "Amazon";
        if (baslik.contains(istenen)){
            System.out.println("test pass");
        }else {
            System.out.println("test failed");
        }
    }
    @Test
    public void test02(){
        String baslik = driver.getTitle();
        String istenen = "Amazon.com.Spend less.Smile more.";
        if (baslik.equals(istenen)){
            System.out.println("test pass");
        }else {
            System.out.println("test failed");
        }
    }
    @Test
    public void test03(){
        String url = driver.getCurrentUrl();
        String istenen = "amazon.com";
        if (url.contains(istenen)){
            System.out.println("test pass");
        }else {
            System.out.println("test failed");
        }
    }
    @Test
    public void test04(){
          WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
          searchBox.sendKeys("nutella"+ Keys.ENTER);
          WebElement sonuclar = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuclar.getText());
    }
    @AfterClass
    public static void kapanis(){
        driver.close();
    }
}
