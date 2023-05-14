package day10_actionsClass_Faker_FileTestlei;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExist {
    @Test
    public void test01(){

        // com.Team113JUnit projesi icerisinde
        // deneme.txt dosyasinin varoldugunu test edin

        String dosyaYolu = "src/test/java/day10_actionsClass_Faker_FileTestlei/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

}
