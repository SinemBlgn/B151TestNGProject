package techproed.test.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_DependsOnMethods {
    /*
Test methodları biribirinden bağımsız çalışır. Methodları birbirie bağımlı çalıştırmak istersek
DEPENDSONMETHODS parametresini @Test notasyonundan sonra bağlamak istediğimiz test methodunun
adını belirtiriz.
 */
    WebDriver driver;

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }   @Test(dependsOnMethods = "test01")
    public void test02() {
  //amazon sayfasine gidelim
        driver.get("https://www.amazon.com");

    }   @Test(dependsOnMethods = "test02")
    public void test03() {
   //amazon arama kutusunda iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
}
