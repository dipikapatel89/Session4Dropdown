package varConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {
    WebDriver driver;
	@Before
	public void init() 
	{
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void handlingAlert()
	{
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		//for get text from message display 
		String str=driver.switchTo().alert().getText();
		//for in message we need to click ok. so use accept() method.
		driver.switchTo().alert().accept();
		System.out.println(str);
	}
}
