package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    WebDriver driver;

    @Test
    public void googleTest() {
        mahserinDortAtlisi();
        driver.get("https://www.google.com");

        String expectedIcerik = "google";
        String actualUrl = driver.getCurrentUrl();

        if (expectedIcerik.contains(expectedIcerik)) {
            System.out.println("Google Testi PASSED");
        } else {
            System.out.println("Google Testi FAİLED");
        }
        driver.close();
    }

    @Test
    public void wiseTest() {
        mahserinDortAtlisi();
        driver.get("https://www.wisequarter.com");

        String expectedIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (expectedIcerik.contains(expectedIcerik)) {
            System.out.println("wisequarter Testi PASSED");
        } else {
            System.out.println("wisequarter Testi FAİLED");
        }
        driver.close();
    }


    @Test
    public void amazonTest() {
        mahserinDortAtlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));

        if (amazonLogoElementi.isDisplayed()) {
            System.out.println("Amazon Testi PASSED");
        } else {
            System.out.println("Amzon testi FAİLED");
        }
        driver.close();
    }

    public void mahserinDortAtlisi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}


