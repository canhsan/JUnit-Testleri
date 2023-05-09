package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assert {
    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        String expextedResult="AMAZON";
        String actualTitle= driver.getTitle();

       /* if (actualTitle.contains(expextedResult)){
            System.out.println("Title Testi PASSED");
        }else{
            System.out.println("Title Testi FAİLED");
        }

        */
        Assert.assertTrue(actualTitle.contains(expextedResult));
        Thread.sleep(3000);
        driver.close();
    }
}
