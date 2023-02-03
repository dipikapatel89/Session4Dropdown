package varConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnScrollUpDown {

	WebDriver driver;
	
	@Before
	public void init()
	{
        System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void upDownScroll() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,800)");
		
		Thread.sleep(2000);
		//for top position
		js.executeScript("scroll(0,0)");
		
	}
}
