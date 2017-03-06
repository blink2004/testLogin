import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by Constantine on 03.03.2017.
 */
public class ExampleLogin {

    private WebDriver driver = null;
    private LoginPage loginPage;

    private final String userLogin = "";
    private final String userPassword = "";

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver_win32.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.booking.com");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.clickLoginLink();
        loginPage.inputEmail(userLogin);
        loginPage.inputPassword(userPassword);
        loginPage.clickSubmit();

        assertTrue("User is not authorized!", loginPage.isLogined());
    }

    @After
    public void afterTest() {
        if (driver != null)
            driver.quit();
    }
}
