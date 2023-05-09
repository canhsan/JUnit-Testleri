package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_AssertionMethodlari {
    /*
        1) Bir class oluşturun: BestBuyAssertions
        2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
        asagidaki testleri yapin
        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        ○ logoTest => BestBuy logosunun görüntülendigini test edin
        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    WebDriver driver;

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");

    }
    @Test
    public void test01() throws InterruptedException {
    // Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        mahserin4Atlisi();
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test02(){
    // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    String unExpectedUrl="Rest" ;
    String actualTitle=driver.getTitle();

    Assert.assertFalse(actualTitle.contains(unExpectedUrl));


    }



}
