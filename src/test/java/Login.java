import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {

    WebDriver driver = null;

    @BeforeTest
    public void OpenBro() throws InterruptedException {
        //1- Bridge between Test Script and Browser
        String chromepath = System.getProperty("user.dir")+ "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromepath);


        //2- New Object of WebDriver
        driver = new ChromeDriver();

        //3- Navigate to URL & Maximize & Sleep
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);


    }

    @Test
    public void RegValid() throws InterruptedException {

        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("Email")).sendKeys("bassam.tester@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("B@b12345");
        driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);

        // add assert
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
