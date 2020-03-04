package Selpackage1;

    import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

	public class Dropdown_search_Select {

		public static void main(String[] args) throws InterruptedException, AWTException {
			
			
			
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\inc2013\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver=new ChromeDriver();
			
			driver.get("http://192.168.2.167:82/taf/login");
			
			driver.manage().window().maximize();
			
			
			WebElement element=null;
			
			element=driver.findElement(By.id("email"));
			element.sendKeys("accounts@gmail.com");
			element=driver.findElement(By.id("password"));
			element.sendKeys("welcome");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div[4]/button")).click();
			
			Select drop=new Select(driver.findElement(By.id("company_name")));
			drop.selectByVisibleText("Texila American University Inc - Guyana");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div[3]/button")).click();
			Thread.sleep(3000);
			//Ledgers
			
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul[4]/li[1]/span")).click();
			Thread.sleep(3000);
			//Ledger Creations
			
		   driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul[4]/li[2]/a/span")).click();
		   Thread.sleep(3000);
		   
		   //Add
		   
		   driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div[3]/div/div/div/div/div[1]/div/div[1]/a[2]")).click();
		   Thread.sleep(3000);
		   
		   //Ledger name
		   
		   
		   element=driver.findElement(By.id("ledger_name"));
			element.sendKeys("Ranbaxy");
			
			element=driver.findElement(By.id("ledger_perfix_no"));
			element.sendKeys("101");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"select2-parent_id-container\"]")).click();
			
			element=driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
			element.sendKeys("Vendors");
			element.sendKeys(Keys.ENTER);

			
			Thread.sleep(5000);
			
			Select msmee=new Select(driver.findElement(By.id("msme")));
			msmee.selectByVisibleText("Yes"); 
			Thread.sleep(3000);
			
			
			
			 element=driver.findElement(By.id("vendor_address"));
			 element.sendKeys("Indira Nagar, Civil Aerodrome Post, Peelamedu, Coimbatore, Tamil Nadu 641014");
			 Thread.sleep(3000);
			 
			 element=driver.findElement(By.name("vendor_contact_no"));
			 element.sendKeys("912224826000");
			 Thread.sleep(2000);
			 
			 
			 
			 driver.findElement(By.xpath("//*[@id=\"select2-vendor_type-container\"]")).click();
			 element=driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		     element.sendKeys("Firm");
			 element.sendKeys(Keys.ENTER);
			 Thread.sleep(2000);
			 
			
			 
			// driver.findElement(By.xpath("//*[@id=\"select2-pan_applicable-container\"]")).click();
			 
		    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div[4]/div/div/div/div/div/form/fieldset/div[2]/div/div[4]/div/div/div/span/span[1]/span/span[1]")).click();
			Thread.sleep(1000);
			element=driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
			element.sendKeys("Applicable");
			Thread.sleep(10000);
			driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[2]")).click();
			
			
			
			
			
			Thread.sleep(1000);
			
		}}


