import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
public class CubeWorks {
    WebDriver driver;

     @Before
    public void setup() {
         System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
         driver = new ChromeDriver();
         driver.get("https://www.saucedemo.com/");
         driver.manage().window().maximize();
     }
     @Test
    public void ValidateTitle(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.equals("Swag Labs"));
    }
    @Test
    public void ValidateLogin(){
         Point point = driver.manage().window().getPosition();
         System.out.println(point.x);
         System.out.println(point.y);
         Point point1 = new Point(20,20);
         driver.manage().window().setPosition(point1);
         driver.findElement(By.id("user-name")).sendKeys("standard_user");
         String fontsize = driver.findElement(By.id("password")).getCssValue("font-size");
         System.out.println(fontsize);
         driver.findElement(By.id("password")).sendKeys("secret_sauce");
         driver.findElement(By.id("login-button")).click();
         String url = driver.getCurrentUrl();
         Assert.assertEquals("https://www.saucedemo.com/inventory.html",url);
    }
     @Test
        public void useAlert(){
        driver.navigate().to("https://only-testing-blog.blogspot.com");
        driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).click();
        driver.switchTo().alert().sendKeys("Rani");

    }
    @After
    public void close(){

         driver.quit();
    }
}
