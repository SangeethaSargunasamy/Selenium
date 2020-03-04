package Selpackage1;

import java.io.File;
import java.io.IOException;



import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Captachacapture {
	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\inc2013\\Documents\\Selenium\\chromedriver.exe");
		

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		
		driver.get("https://apply.tauedu.org/bsmdg-guyana/");
		 driver.manage().window().maximize();
		
		//driver.manage().window().maximize();

		
	    driver.findElement(By.id("name_e")).sendKeys("NEWNAME");
	   
	    driver.findElement(By.id("txtEmail")).sendKeys("TESTNAME@mail.com");
	    Select drop=new Select(driver.findElement(By.id("country_code")));
	    
		drop.selectByVisibleText("Afghanistan (+93)");
		driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div/div[3]/div/form/div[3]/div[2]/div/input")).sendKeys("98456789");
		Select drop1=new Select(driver.findElement(By.id("qualification")));
		drop1.selectByVisibleText("CSEC");

		Thread.sleep(2000);
		
		File src=driver.findElement(By.id("captcha_iframe")).getScreenshotAs(OutputType.FILE);
		System.out.println("user.dir: "+System.getProperty("user.dir")); 
		String path1=System.getProperty("user.dir")+"/Screenshots1/captcha.png";
		
		FileHandler.copy(src,new File(path1));
		ITesseract image=new Tesseract();
		String captchatext=image.doOCR(new File(path1));
		System.out.println(captchatext);
	    driver.findElement(By.id("captcha")).sendKeys(captchatext);
	    Thread.sleep(4000);
	    driver.findElement(By.id("btn_submit")).click();
	    Thread.sleep(2000);
	    driver.close();
	    
}

}
