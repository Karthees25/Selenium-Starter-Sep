package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;


public class WindowHandleExample {


    ChromeDriver driver;
    public WindowHandleExample()
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
            // Step 1: Go to the URL
            driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

            // Switch to iframe containing the "Try it" button
            driver.switchTo().frame("iframeResult");

            // Step 2: Click the "Try it" button
            WebElement tryItButton = driver.findElement(By.tagName("button"));
            tryItButton.click();

            // Step 3: Get URL and Title, take screenshot, and close the new window
            String originalWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
            }

            String newWindowTitle = driver.getTitle();
            String newWindowURL = driver.getCurrentUrl();

            // Take screenshot
            File screenshot = ((ChromeDriver) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);

            // Close the new window
            driver.close();

            // Switch back to the original window
            driver.switchTo().window(originalWindowHandle);

            // Step 4: Print URL, Title, and close the browser
            System.out.println("New Window URL: " + newWindowURL);
            System.out.println("New Window Title: " + newWindowTitle);

            // Save screenshot to a file
            File destination = new File("screenshot.png");
            org.apache.commons.io.FileUtils.copyFile(screenshot, destination);

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
