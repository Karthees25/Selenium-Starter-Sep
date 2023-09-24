package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedIn
{
    ChromeDriver driver;
    public LinkedIn()
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

    public void TestCase01() throws InterruptedException {
    
            // Step 1: Sign in to LinkedIn
            driver.get("https://www.linkedin.com/");
            Thread.sleep(3000);
            WebElement emailField = driver.findElement(By.id("session_key"));
            WebElement passwordField = driver.findElement(By.id("session_password"));
            WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));

            // Replace "your_email" and "your_password" with your actual LinkedIn credentials
            emailField.sendKeys("kwaran@na.amityonline.com");
            passwordField.sendKeys("Karthees@2510");
            signInButton.click();

            // Wait for the dashboard to load
            Thread.sleep(3000); // You may need to adjust this wait time

            // Step 2: Create a post with an image or video
            WebElement startPostButton = driver.findElement(By.xpath("//span[text()='Media']"));
            startPostButton.click();
            Thread.sleep(3000);

     try {
             WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
             Thread.sleep(3000);
            
            // Replace "Your post content" with your actual post content
           String Pic = "C:\\Users\\Dell\\OneDrive\\Pictures\\Screenshots\\Karthees.png";
          // String Pic = "C:\\Users\\Client\\Downloads\\mondayquotes.jpg";

            // Upload image (you will need to replace the path with the actual file path)
           // WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
            uploadInput.sendKeys(Pic);

            // Wait for the image to upload (you may need to adjust the wait time)
            Thread.sleep(5000);

            WebElement NextButton=driver.findElement(By.xpath("//span[text()='Next']"));
            NextButton.click();

            // Click on the "Post" button
            WebElement postButton = driver.findElement(By.xpath("//span[text()='Post']"));
            postButton.click();

            // Wait for the post to be published (you may need to adjust the wait time)
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
