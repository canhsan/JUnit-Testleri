package day07_JUnit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropdownMenu {
           // ● Bir class oluşturun: C3_DropDownAmazon
           // ● https://www.amazon.com/ adresine gidin.
           //        - Test 1
           // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
           // oldugunu test edin
           //         -Test 2
           // 1. Kategori menusunden Books secenegini secin
           // 2. Arama kutusuna Java yazin ve aratin
           // 3. Bulunan sonuc sayisini yazdirin
           // 4. Sonucun Java kelimesini icerdigini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();

    }
    @Test
    public void test01(){
        WebElement dropdownMenuElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownMenuElementi);
        int expectedOptionSayisi=28;
        int actualOptionSayisi=select.getOptions().size();

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }
    @Test
    public void test02(){
        WebElement dropdownMenuElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownMenuElementi);
        select.selectByVisibleText("Books");
        WebElement aramaKutusuElementi= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("java"+ Keys.ENTER);
        WebElement sonucSayiElementi= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div"));
        System.out.println(sonucSayiElementi.getText());

        String expectedResultIcerik="java";
        String actualResulIcerik=sonucSayiElementi.getText();
        Assert.assertTrue(actualResulIcerik.contains(expectedResultIcerik));


    }



}
