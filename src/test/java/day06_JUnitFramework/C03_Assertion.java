package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {
    WebDriver driver;

    @Test
    public void googleTest() throws InterruptedException {
        mahserinDortAtlisi();
        driver.get("https://www.google.com");

        String expectedIcerik = "google1";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void wiseTest() throws InterruptedException {
        mahserinDortAtlisi();
        driver.get("https://www.wisequarter.com");

        String expectedIcerik = "wisequarter1";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Thread.sleep(3000);
        driver.close();
    }


    @Test
    public void amazonTest() throws InterruptedException {
        mahserinDortAtlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));


        Thread.sleep(3000);
        driver.close();
    }

    public void mahserinDortAtlisi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}


