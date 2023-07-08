package techproed.test.day24_Priority_DependsOnMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Ignore {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //birden fazla test methodu calistirmak istediginizde o anlik gereksiz gordugumuz test methodunu atlamak (ignore) isteyebiliriz
    //bunun icin @test notasyonu ustune yada yanina @ignore notaasyonu eklememeiz yeterlidir
    @Ignore
    @Test()
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }
    @Test(enabled = false)//bu methodu atlayacak raporda da gostermeyecek
    public void youtubeTest() {
        driver.get("https://www.youtube.com");
    }
    @Test()
    public void facebookTest() {
        driver.get("https://www.facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
