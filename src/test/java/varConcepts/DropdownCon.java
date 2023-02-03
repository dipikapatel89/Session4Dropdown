package varConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import java.util.List;
//import org.openqa.selenium.support.ui.List;
//import org.openqa.jetty.html.List;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import junit.framework.Assert;
import java.util.List;
import java.util.Random;

public class DropdownCon {
	 WebDriver driver;
	 
	    By USER_NAME_FIELD=By.xpath("//input[@id='username']");
		By USER_PASSWORD_FIELD=By.xpath("//input[@id='password']");
	    By SIGNIN_BUTTON_FIELD=	By.xpath("/html/body/div/div/div/form/div[3]/button");
	    By DASHBOARD_HEADER_FIELD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	    
	  //here we use contains method for text. because there is a span.
	    By CUSTOMER_FIELD=By.xpath("//span[contains(text(),'Customers')]");
		By ADDCUSTOMER_FIELD=By.xpath("//a[contains(text(),'Add Customer')]");
		By FULLNAME_FIELD=By.xpath("//*[@id=\"account\"]");
		By EMAIL_FIELD=By.xpath("//*[@id=\"email\"]");
		By PHONE=By.xpath("//*[@id=\"phone\"]");
		By ADDRESS=By.xpath("//*[@id=\"address\"]");
		By CITY=By.xpath("//*[@id=\"city\"]");
		By STATE=By.xpath("//*[@id=\"state\"]");
		By ZIP=By.xpath("//*[@id=\"zip\"]");
		By SAVE=By.xpath("//*[@id=\"submit\"]");
		//By LIST_CUSTOMER=By.xpath("//a[contains(text(),'List Customers')]");
			
		
		
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
		public void loginTest()
		{
			
		   // By BANK_CASH_BUTTON_FIELD=By.linkText("Bank & Cash");
		    
		    driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
			driver.findElement(USER_PASSWORD_FIELD).sendKeys("abc123 ");
			driver.findElement(SIGNIN_BUTTON_FIELD).click();
			
			
			//driver.findElement(BANK_CASH_BUTTON_FIELD).click();
			
			//Assert by dashboard text
			String DashboardString=driver.findElement(DASHBOARD_HEADER_FIELD).getText();
			Assert.assertEquals("Page not found","Dashboard",DashboardString); 
			
			//Assert by dashboard title and for title inspect and ctrl+f n write title.then get title of dashboard.
			//Assert.assertEquals("Page not found", "Dashboard- iBilling"	, driver.getTitle());
			//Assert.assertEquals("Bank and cash not found ","Ban & Cash",driver.findElement(BANK_CASH_BUTTON_FIELD).getText());
		}
		
		@Test
		public void addcustomer()
		{
			loginTest();
			driver.findElement(CUSTOMER_FIELD).click();
			driver.findElement(ADDCUSTOMER_FIELD).click();
			driver.findElement(FULLNAME_FIELD).sendKeys("jeno pal");
			
			int genNum=generateRandomNum(999);
			driver.findElement(FULLNAME_FIELD).sendKeys("selenium" + genNum);
			
			
			WebElement dd=driver.findElement(By.xpath("//select[@id='cid']"));
		    Select sel=new Select(dd);
		    sel.selectByVisibleText("Tesla");
		    
		    /*For list of all company name print on console
		    List<WebElement> li=sel.getOptions();
		    System.out.println("List of company name:");
		    for(int i=1;i<li.size();i++)
		    {
		    	
		    	System.out.println(li.get(i).getText());
		    }*/
			
		    driver.findElement(EMAIL_FIELD).sendKeys("bnoj@gmail.com");
		    //driver.findElement(EMAIL_FIELD).sendKeys(generateRandomNum(9999)+ "bnoj@gmail.com");
			driver.findElement(PHONE).sendKeys("1234678996");
			driver.findElement(ADDRESS).sendKeys("124,uabc");
			driver.findElement(CITY).sendKeys("houston");
			driver.findElement(STATE).sendKeys("texas");
			driver.findElement(ZIP).sendKeys("78606");
			
			WebElement cn=driver.findElement(By.xpath("//select[@id='country']"));
			Select sel1=new Select(cn);
			sel1.selectByVisibleText("Zimbabwe");
			//	sel1.selectByValue("Zimbabwe");
			
			driver.findElement(SAVE).click();
			
			/*WebElement hd=driver.findElement(By.xpath("//select[@id='tags']"));
			Select sel2=new Select(hd);
			sel2.selectByVisibleText("IT Training");
			
			WebElement cur=driver.findElement(By.xpath("//select[@id='currency']"));
			Select sel3=new Select(cur);
			sel3.selectByVisibleText("USD");
			
			
			WebElement grp=driver.findElement(By.xpath(" //select[@id='group']"));
			Select sel4=new Select(grp);
			sel4.selectByVisibleText("SQL");*/
			//driver.findElement(LIST_CUSTOMER).click();
			
			
			
			
			
			
				
		}
		private int generateRandomNum(int boundaryNum) {
			Random rnd = new Random();
			int generatedNum = rnd.nextInt(boundaryNum);
			return generatedNum;
			
		}

}

  	