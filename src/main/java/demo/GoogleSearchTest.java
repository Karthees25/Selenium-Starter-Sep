package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

 
 ChromeDriver driver;
    public GoogleSearchTest()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }    
     public void TestCase01(){ 

        try {
            // Step 1: Open Google and search for "amazon"
            driver.get("https://www.google.com");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("amazon");
            searchBox.sendKeys(Keys.RETURN);

            // Step 2: Check if "amazon.in" or "amazon.com" is in the search results
  boolean  result =driver.findElement(By.xpath("//a[contains(@href,'amazon.in') or contains(@href,'amazon.com')]")).isDisplayed();

 System.out.println(result);
          

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
