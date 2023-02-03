package varConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnKeyboardAction {
	WebDriver driver;
	  By USER_NAME_FIELD=By.xpath("//input[@id='username']");
	  By USER_PASSWORD_FIELD=By.xpath("//input[@id='password']");
		    //By SIGNIN_BUTTON_FIELD=	By.xpath("/html/body/div/div/div/form/div[3]/button");
			//By BANK_CASH_BUTTON_FIELD=By.linkText("Bank & Cash");
		    //By NEW_ACCOUNT_FIELD=By.linkText("New Account");
			By DASHBOARD_HEADER_FIELD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	@Before
	public void init() 
	{
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void keyboardAction()
	{
		 driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		 driver.findElement(USER_PASSWORD_FIELD).sendKeys("abc123");
			//driver.findElement(SIGNIN_BUTTON_FIELD).click();
          
		  Actions action=new Actions(driver);
          action.sendKeys(Keys.ENTER).build().perform();
          
          //here I am doing first login and then click on dashboard menu and then 
          //it goes down by Tab key upto down. 
          driver.findElement(DASHBOARD_HEADER_FIELD).click();
          action.sendKeys(Keys.TAB).build().perform();
	}
}
