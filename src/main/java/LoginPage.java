import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Constantine on 03.03.2017.
 */
public class LoginPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink(){
        WebElement element = driver.findElement(By.xpath("//li[contains(@class, 'account_register_option')]/a/div/span"));
        element.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//input[@name='username'])[1]")));
    }

    private void setDataToField(WebElement element, String data){
        if ( element!= null )
            element.sendKeys(data);
    }

    public void inputEmail(String email){
        WebElement element = driver.findElement(By.xpath("(.//input[@name='username'])[1]"));
        setDataToField(element, email);
    }

    public void inputPassword(String password){
        WebElement element = driver.findElement(By.xpath("(.//input[@name='password'])[1]"));
        setDataToField(element, password);
    }

    public void clickSubmit(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("(.//input[@type='submit'])[4]"));
        actions.moveToElement(element).click().build().perform();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='header_name user_firstname']")));
    }

    public boolean isLogined(){
        return driver.findElement(By.xpath("//span[@class='header_name user_firstname']")).isDisplayed();
    }

}
