package Selpackage1;


	

	import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;



	public class TestA {

		public static void main(String[] args) throws InterruptedException, IOException, TesseractException {
			// TODO Auto-generated method stub
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\inc2013\\Documents\\Selenium\\chromedriver.exe");
			
			//ChromeOptions opt=new ChromeOptions();
			//opt.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver();
			driver.get("https://apply.tauedu.org/bsmdg-guyana/");
			
			driver.manage().window().maximize();
		
			
			driver.findElement(By.id("name_e")).sendKeys("test");
			
			driver.findElement(By.id("txtEmail")).sendKeys("testEmail2testEmail2testEmail2testEmail2testEmail2testEmail2test@gmail.com");
			
			Select countrycode=new Select(driver.findElement(By.id("country_code")));
			countrycode.selectByVisibleText("Germany (+49)"); 
			Thread.sleep(3000);
			
			
			driver.findElement(By.name("contact")).sendKeys("123456789123456");
			
			Select qualification=new Select(driver.findElement(By.id("qualification")));
			qualification.selectByVisibleText("Completed O levels/ Senior Secondary Education"); 
			Thread.sleep(3000);
			

			
			/*
			 * String captcha
			 * =driver.findElement(By.id("captcha_code")).getAttribute("value");
			 * 
			 * System.out.println(captcha);
			 * 
			 * 
			 * 
			 * driver.findElement(By.id("captcha")).sendKeys(captcha);
			 * 
			 * 
			 * Thread.sleep(5000);
			 */
			
			
			//driver.findElement(By.id("fee")).click();
			
			//Thread.sleep(5000);
			//File src=driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div/div[3]/div/form/div[6]/img")).getScreenshotAs(OutputType.FILE);
			
			File src=driver.findElement(By.id("captcha_iframe")).getScreenshotAs(OutputType.FILE);
			
			
			String path=System.getProperty("user.dir")+"/Screenshots1/captcha.png";
			
			FileHandler.copy(src,new File(path));
			
		
			ITesseract image=new Tesseract();
		
			String imageText=image.doOCR(new File(path));
					

			System.out.println(imageText);
			
				
				
			
			
			driver.findElement(By.id("captcha")).sendKeys(imageText);
			
		

		   
			//driver.findElement(By.id("btn_submit")).click();
			
			Thread.sleep(5000);
			
			
			driver.close();

		}

	}


