package techproed.test.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {
     /*
        Junitte test methodlarini istedigimiz sekilde siralamak icin method isimlerini alfabetik ve numerik sirali
    olarak yazmamiz gerekiyordu. TestNG frameworkunde bu siralama icin @Test notasyonundan sonra parametre olarak
    (priority = 1) gibi oncelik sirasi belirterek test methodlarimizi siralayabiliriz.
    Priority kullanmadigimiz methodda priority degerini 0(sifir) olarak kabul eder

     */
     WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority=1)
    public void amazonTest() {
        driver.get("https://www.amazon.com");//ikinci olarak amazon calissin
    }
    @Test
    public void youtubeTest() {
        driver.get("https://www.youtube.com");//youtube once calissin
    }
    @Test(priority=2)
    public void facebookTest() {
        driver.get("https://www.facebook.com");//son olarak facebook calissin
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
