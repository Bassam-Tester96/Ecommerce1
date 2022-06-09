import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectCategory {

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

        Login ln = new Login();
        Thread.sleep(3000);


    }

    @Test
    public void SelectCategory() throws InterruptedException {

        // Login
//        driver.findElement(By.linkText("Log in")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.id("Email")).sendKeys("bassam.tester@gmail.com");
//        driver.findElement(By.id("Password")).sendKeys("B@b12345");
//        driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);


     //Web search
        // Locating the Main Menu (Parent element)
        //WebElement mainMenu = driver.findElement(By.xpath("//a[text()='Computers']"));
       // WebElement mainMenu = driver.findElement(By.xpath("//a[@text='Computers']"));

//        //Methode 2
        //identify menu
        WebElement n=driver.findElement(By.xpath("(//a[@href="/Computers"])[1]"));
        // object of Actions with method moveToElement
        Actions a = new Actions(driver);
        a.moveToElement(n).perform();
        //identify sub-menu element
        WebElement m=driver.
                findElement(By.xpath("(//a[@href="/Desktops"])[1]"));
        //move to element and click
        a.moveToElement(m).click().perform();


        // Methode 1
//        //Instantiating Actions class
//        Actions actions = new Actions(driver);
//
//        //Hovering on main menu
//        actions.moveToElement(mainMenu);
//
//        // Locating the element from Sub Menu
//        WebElement subMenu = driver.findElement(By.xpath(//a[@herf=\"/Desktops\"])[1]"));
//
//        //To mouseover on sub menu
//        actions.moveToElement(subMenu);
//
//        //build()- used to compile all the actions into a single step
//        actions.click().build().perform();


//        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
//        driver.findElement(By.id(""))



    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }




}
