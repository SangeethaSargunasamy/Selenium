package Selpackage1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		 String facebook="https://www.facebook.com/";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\inc2013\\Documents\\Selenium\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(facebook);
        driver.manage().window().maximize();
       
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Total links are "+links.size());
        for(int i=0; i<links.size(); i++) {
        	 WebElement element = links.get(i);
        	 String url=element.getAttribute("href");
        	 verifyLink(url);
	}
	}
	public static void verifyLink(String URLlink)
	{
		try
		{
			 URL link = new URL(URLlink);
			 HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
			 httpConn.setConnectTimeout(2000);
			 httpConn.connect();
			 if(httpConn.getResponseCode()== 200) { 
				 System.out.println(URLlink+" - "+httpConn.getResponseMessage());
				 }
				 if(httpConn.getResponseCode()== 404) {
				 System.out.println(URLlink+" - "+httpConn.getResponseMessage());
				 }
				 }
		catch(Exception e)
		{
		}
	}
}

