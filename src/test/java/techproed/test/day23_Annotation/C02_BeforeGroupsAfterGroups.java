package techproed.test.day23_Annotation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
public class C02_BeforeGroupsAfterGroups {
    WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("En başta beforeSuite çalışır");
    }
    @BeforeGroups({"erol","evren"})
    public void beforeGroups() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(groups = "erol")
    public void test01() {
        String amazonUrl = "https://amazon.com";
        driver.get(amazonUrl);
    }

    @Test(groups = "erol")
    public void test02() {
        String youtubeUrl = "https://youtube.com";
        driver.get(youtubeUrl);
        driver.close();
    }

    @Test(groups = "evren")
    public void test03() {
        String facebookUrl = "http://facebook.com";
        driver.get(facebookUrl);
    }
}
