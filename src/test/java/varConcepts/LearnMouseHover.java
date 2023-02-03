package varConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {
	WebDriver driver;
	Actions action;
	//By USER_NAME_FIELD=By.xpath("//input[@id='username']");
	//By USER_PASSWORD_FIELD=By.xpath("//input[@id='password']");
	By PRODUCT_FIELD=By.xpath("//span[contains(text(),'Products')]");
	By SOLUTINOS=By.xpath("//span[contains(text(),'Solutions')]");
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
	public void mouseHoverOnSolutios()
	{
	    action=new Actions(driver);
		action.moveToElement(driver.findElement(SOLUTINOS)).build().perform();
	}
	@Test
	public void mouseHoverOnProduct()
	{
		action=new Actions(driver);
		action.moveToElement(driver.findElement(PRODUCT_FIELD)).build().perform();
		driver.findElement(By.xpath("//a[text()='Data Storage']")).click();
		
		
		
	}
	
}
