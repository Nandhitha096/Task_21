package task21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {

	public static void main(String[] args) {
		
		//Setting up the chrome driver
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		//Launching the provided url
		
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
	     
	     //Clicking on the link 
	     driver.findElement(By.xpath("//div[@class='example']/a")).click();
	     
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

	     // Handling main window
	     String mw=driver.getWindowHandle();

	     //Switching to new window
	     
	     for(String windowHandle:driver.getWindowHandles())
	     {
	      
	    	 driver.switchTo().window(windowHandle);
	     }
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

	     //Verifying the new window 

	     WebElement title=driver.findElement(By.xpath("//h3"));
	     
	     if(title.getText().equals("New Window"))
	     {
	      System.out.println("Navigated to New window - "+ title.getText());
	     }
	     else
	     {
	      System.out.println("New window does not exist ");
	     }
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

	     //Closing the new window
	     driver.close();

	     //switching to main window
	     driver.switchTo().window(driver.getWindowHandles().iterator().next());
	     
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	     //verification the main window message
	     
	     WebElement mainWindow=driver.findElement(By.xpath("//div[@class='example']/h3"));
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	     
	     if(mainWindow.getText().equals("Opening a new window"))
	     {
	      System.out.println("Main window is active");
	     }
	     else
	     {
	      System.out.println("Main window does not exist");
	     }
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

	     //Closing the main window
	     driver.close();
	 }

	}

/* Output :
 
Navigated to New window - New Window
Main window is active

 */

