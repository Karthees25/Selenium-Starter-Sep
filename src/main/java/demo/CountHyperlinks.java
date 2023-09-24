package demo;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountHyperlinks {

    ChromeDriver driver;
    public CountHyperlinks()
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


public void testCase01(){
        try {
            // Step 1: Visit the link
            driver.get("https://in.bookmyshow.com/explore/home/chennai");

            // Step 2: List down the count of hyperlinks
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            int hyperlinkCount = allLinks.size();

            // Step 3: Print the count of hyperlinks
            System.out.println("Total Hyperlinks on the page: " + hyperlinkCount);

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}

