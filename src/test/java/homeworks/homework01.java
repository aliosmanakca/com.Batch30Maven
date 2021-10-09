package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class homework01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

       /* 1. “https://www.saucedemo.com” Adresine gidin
        2. Username kutusuna “standard_user” yazdirin
        3. Password kutusuna “secret_sauce” yazdirin
        4. Login tusuna basin
        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        6. Add to Cart butonuna basin
        7. Alisveris sepetine tiklayin
        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        9. Sayfayi kapatin*/

        driver.get("https://www.saucedemo.com");
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        WebElement urun = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String urunyazi = urun.getText();
        urun.click();
        WebElement sepeteekle = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        sepeteekle.click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String envanterdekiurun = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText(); // getText yapmazsan olmaz
         if (urunyazi.equals(envanterdekiurun)) {
             System.out.println("urun eklendi");
         }else{
             System.out.println("urun eklenemedi");
         }

        driver.close();


    }
}
