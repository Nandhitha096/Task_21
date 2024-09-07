package task21;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2 {

	public static void main(String[] args) {
		
		//Setting up the chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		//Launching the provided url
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	    //Switching to Top frame
	    WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
	    driver.switchTo().frame(topFrame);

	    //Verifying if the frame count is 3
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	    List<WebElement> frames=driver.findElements(By.tagName("frame"));
	    int frameCount=frames.size();
	    if (frameCount==3)
	    {
	     System.out.println("Three frames are available on the page");
	    }
	    else
	    {
	     System.out.println("Available frames are "+ frameCount);
	    }

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	   
	    //Switching to left frame
	    
	    WebElement leftFrame = driver.findElement(By.name("frame-left"));
	    driver.switchTo().frame(leftFrame);
	    System.out.println("Switched to the Left Frame");

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	    
	    //Verifying the text of left frame
	    WebElement element1 = driver.findElement(By.xpath("//body[contains(text(),\"LEFT\")]"));
	    String leftFrameText = element1.getText();
	    if (leftFrameText.equals("LEFT"))
	    {
	     System.out.println("Left frame has a text *LEFT* ");
	    }
	    else
	    {
	     System.out.println("Left frame does not contain any text");
	    }

	    //Switching back to top frame
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(topFrame);
	    System.out.println("Switched from left frame to Top frame");
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

	    //Switching to middle frame 

	    WebElement middleFrame = driver.findElement(By.name("frame-middle"));
	    driver.switchTo().frame(middleFrame);
	    System.out.println("Switched to the Middle Frame");

	    //Verifying the text of middle frame
	    WebElement element2 = driver.findElement(By.xpath("//div[contains(text(),\"MIDDLE\")]"));
	    String middleFrameText = element2.getText();
	    if (middleFrameText.equals("MIDDLE"))
	    {
	     System.out.println("Middle frame has a text *MIDDLE* ");
	    }
	    else
	    {
	     System.out.println("Middle frame does not contain any text");
	    }

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

	    //Switching back to top frame
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(topFrame);
	    System.out.println("Switched from middle frame to Top frame");

	    //Switching to right frame
	    WebElement rightFrame = driver.findElement(By.name("frame-right"));
	    driver.switchTo().frame(rightFrame);
	    System.out.println("Switched to the Right Frame");

	    //Verifying the text of right frame
	    WebElement element3 = driver.findElement(By.xpath("//body[contains(text(),\"RIGHT\")]"));
	    String rightFrameText = element3.getText();
	    if (rightFrameText.equals("RIGHT"))
	    {
	     System.out.println("Right frame has a text *RIGHT* ");
	    }
	    else
	    {
	     System.out.println("Right frame does not contain any text");
	    }
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

	    //Switch back to top frame
	    driver.switchTo().defaultContent();
	    System.out.println("Switched from right frame to Top frame");

	    //Switching to bottom frame
	    WebElement bottomFrame = driver.findElement(By.name("frame-bottom"));
	    driver.switchTo().frame(bottomFrame);
	    System.out.println("Switched to the Bottom Frame");
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

	    //Verifying the text of bottom frame
	    
	    WebElement element4 = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
	    String bottomFrameText = element4.getText();
	    if (bottomFrameText.equals("BOTTOM"))
	    {
	     System.out.println("Bottom frame has a text *BOTTOM* ");
	    }
	    else
	    {
	     System.out.println("Bottom frame does not contain any text");
	    }

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));


	    //Switching to top frame
	    driver.switchTo().defaultContent();
	    System.out.println("Switched from bottom frame to top frame");

	    //Verifying the page title
	    driver.switchTo().defaultContent();
	    String webpageTitle= driver.getTitle();
	    
	    if (webpageTitle.equals("Frames"))
	    {
	     System.out.println("The title of the page is : "+ webpageTitle);
	    }
	    else
	    {
	     System.out.println("The title of the page is not as mentioned");
	    }

	    //Close the browser
	    driver.close();

	}

}


/* Output :
 
Three frames are available on the page
Switched to the Left Frame
Left frame has a text *LEFT* 
Switched from left frame to Top frame
Switched to the Middle Frame
Middle frame has a text *MIDDLE* 
Switched from middle frame to Top frame
Switched to the Right Frame
Right frame has a text *RIGHT* 
Switched from right frame to Top frame
Switched to the Bottom Frame
Bottom frame has a text *BOTTOM* 
Switched from bottom frame to top frame
The title of the page is : Frames

 
 */
