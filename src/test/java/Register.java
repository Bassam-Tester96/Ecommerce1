import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register {

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

        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='M']")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Bassam");
        driver.findElement(By.id("LastName")).sendKeys("Amgad");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("20");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("August");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1996");
        driver.findElement(By.id("Email")).sendKeys("bassammm@efw.com");
        driver.findElement(By.id("Company")).sendKeys("ElBes");
        driver.findElement(By.id("Password")).sendKeys("B@b12345");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("B@b12345");
        driver.findElement(By.id("register-button")).click();

        // add assert
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/registerresult/1?returnUrl=/");

    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
