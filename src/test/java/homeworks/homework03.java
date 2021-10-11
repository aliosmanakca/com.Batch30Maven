package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class homework03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        // 1-Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"
        driver.navigate().to("https://react-shopping-cart-67954.firebaseapp.com/");
        // 2-List all the elements on the website
        //???
        // 3-Create a String Arraylist and put Product Names into the ArrayList
        List<WebElement> products = driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        // 4-Choose 5 items randomly, add to cart and print the names of items
        // (Each product cannot be added more then 1 time!)
        Random random = new Random();  
        List<WebElement> chosenItems = new ArrayList<>();
        for (int i =0; i<5; i++){
            int randomIndex = random.nextInt(products.size());
            Thread.sleep(2000);
            chosenItems.add(products.get(randomIndex));
            Thread.sleep(15000);
            products.remove(randomIndex);
            Thread.sleep(5000);
        }
        for (WebElement each: chosenItems
             ) {
            each.click();
            Thread.sleep(500);
        }
        for (WebElement each: chosenItems
        ) {
            System.out.println(each.getText());
        }
        // CHECK THE PRICES!
        // 5-(Bu maddeyi buraya tasidim daha mantikli oldu) Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
        Thread.sleep(2000);
        List<Double> prices = new ArrayList<>();
        for (int i =17; i<=21; i++){
            String str = "(//div[@class='shelf-item__price'])"+"["+i+"]";
            WebElement price = driver.findElement(By.xpath(str));
            String str2 = price.getText().replaceAll("[^ 0-9 .]","");
            Double fiyat = Double.parseDouble(str2);
            prices.add(fiyat);
        }
        for (Double each: prices
             ) {
            System.out.println(each);
        }
        // 6-Sum each item's price and compare your result with the website
        double toplam = 0;
        for (Double each: prices
        ) {
            toplam+=each;
        }
        WebElement webToplam = driver.findElement(By.xpath("//p[@class='sub-price__val']"));
        String webToplam1 = webToplam.getText();
        webToplam1 = webToplam1.replaceAll("[^ 0-9 .]","");
        Double webToplam2 = Double.parseDouble(webToplam1);
        // 7-If results are matching print success message
        if (toplam==webToplam2){
            System.out.println("sonuclar ayni");
        }else {
            System.out.println("sonuclar farkli");
        }
        // Click Checkout
        driver.findElement(By.xpath("//div[@class='buy-btn']")).click();

    }

}
