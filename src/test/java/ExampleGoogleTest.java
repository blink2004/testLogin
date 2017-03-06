import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Constantine on 03.03.2017.
 */
public class ExampleGoogleTest {

    @Test
    public void testGoogleSearch(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver_win32.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com");
//        or alternative for this
//        driver.navigate().to("");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("cheese!");
        element.submit();

        System.out.println("Page title is : " + driver.getTitle());

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        System.out.println("Page title is : " + driver.getTitle());

        driver.quit();
    }

}
