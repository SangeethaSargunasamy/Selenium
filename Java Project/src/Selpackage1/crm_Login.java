package Selpackage1;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class crm_Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Launching the URL
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\inc2013\\Documents\\Selenium\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://192.168.50.76:81/tauedudynamic/crm/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        //Login to CRM page
        driver.findElement(By.id("login_username")).sendKeys("crm");
        driver.findElement(By.id("login_password")).sendKeys("welcome");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        
        //Navigating through menus and navigating to Add Enquiry page
       Actions action=new Actions(driver);
       WebElement enquiry=driver.findElement(By.xpath("//a[text()='Enquiry']"));
       action.moveToElement(enquiry);
       Thread.sleep(5000);
       WebElement enquirylist= driver.findElement(By.xpath("//a[text()='Enquiry List']"));
       action.moveToElement(enquirylist).click().perform();
       driver.findElement(By.xpath("//a[text()='Add Enquiry']")).click();
       Thread.sleep(5000);
       
       //Adding enquiry details
      Select Campaign_type= new Select( driver.findElement(By.xpath("//select[@id='ct_id']")));
      Campaign_type.selectByVisibleText("Naukri");
      //WebDriverWait wait=new WebDriverWait(driver, 60);
      //List<WebElement> campid=  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath("//select[@id='campaign_id']"))));
      Thread.sleep(2000);
      Select Campaign_name= new Select( driver.findElement(By.xpath("//select[@id='campaign_id']")));
      Campaign_name.selectByVisibleText("Mailer");
      Thread.sleep(5000);
     
      
      Select salutation=new Select(driver.findElement(By.xpath("//select[@id='salutation']")));
      salutation.selectByVisibleText("Ms");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Priya");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Sudhan");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@id='email']")).sendKeys("www@gmail.com");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("gggg@gmail.com");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@id='dummy_email']")).click();
      Thread.sleep(3000); 
      Select emailstatus=new Select(driver.findElement(By.xpath("//select[@id='email_status']")));
      emailstatus.selectByIndex(1);
      Thread.sleep(3000);
      Select qual=new Select(driver.findElement(By.xpath("//select[@id='current_qualification']")));
      qual.selectByIndex(1);
      Thread.sleep(3000);
    
    driver.findElement(By.xpath("//input[@id='disable_notification']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@id='dnd_calls']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@id='gender_female']")).click();
    Thread.sleep(3000);
    Select maritalstatus=new Select(driver.findElement(By.xpath("//select[@id='marital_status']")));
    maritalstatus.selectByIndex(1);
    Thread.sleep(3000);
    
    //Select from date picker
   /* driver.findElement(By.xpath("//img[@id='dob_trigger']")).click();
   driver.findElement(By.xpath("//div[@class='DynarchCalendar-bottomBar-today']")).click();
    /* driver.findElement(By.xpath("//div[@class='DynarchCalendar-prevYear DynarchCalendar-navBtn']")).click();
    driver.findElement(By.xpath("//div[@class='DynarchCalendar-prevYear DynarchCalendar-navBtn']")).click();
    driver.findElement(By.xpath("//div[@class='DynarchCalendar-day' and text()='9']")).click();
     List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
    for (WebElement cell: columns){
       //Select 8th Date 
       if (cell.getText().equals("7")){
          cell.findElement(By.linkText("7")).click();
          break;*/
    
    
    /*driver.findElement(By.xpath("//img[@id='ecd_date_trigger']")).click();
    //driver.findElement(By.xpath("//div[@class='DynarchCalendar-bottomBar-today']")).click();
  driver.findElement(By.xpath("//div[@class='DynarchCalendar-body']/table/tbody/tr[3]/td[2]/div[text()='12' and @class='DynarchCalendar-day DynarchCalendar-day-disabled']")).click();
    /*
    List<WebElement> columns1=dateWidget1.findElements(By.tagName("td"));
    for (WebElement cell1: columns1){
       //Select 9th Date 
       if (cell1.getText().equals("8")){
          cell1.findElement(By.linkText("8")).click();
          break;
     }
}*/
    Select leadstatus=new Select(driver.findElement(By.xpath("//select[@id='lead_status']")));
    leadstatus.selectByIndex(1);
    Thread.sleep(3000);

    Select leadstatusreason=new Select(driver.findElement(By.xpath("//select[@id='lead_status_reason']")));
    leadstatusreason.selectByIndex(0);
    Thread.sleep(3000);

    Select dept=new Select(driver.findElement(By.xpath("//select[@id='ser_user_dept[]']")));
    dept.selectByIndex(1);
    Thread.sleep(3000);

    Select assignedid=new Select(driver.findElement(By.xpath("//select[@id='assigned_user_id']")));
    assignedid.selectByVisibleText("veera");
    Thread.sleep(3000);

    
  driver.findElement(By.xpath("//img[@id='enquiry_received_on_trigger']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@class='DynarchCalendar-bottomBar-today']")).click();
    Thread.sleep(3000);

    /*driver.findElement(By.xpath("//div[@class='DynarchCalendar-body']/table/tbody/tr/td/div[text()='1']")).click();
    /*List<WebElement> columns2=enquiryreceived.findElements(By.tagName("td"));
    for (WebElement cell2: columns2){
       //Select 9th Date 
       if (cell2.getText().equals("9")){
          cell2.findElement(By.linkText("8")).click();
          break;
     }
}*/
    Select course=new Select(driver.findElement(By.xpath("//select[@id='interested_course1']")));
    course.selectByIndex(1);
    Thread.sleep(3000);

    js.executeScript("window.scrollBy(0,1000)");
    driver.findElement(By.xpath("//input[@value='Update']")).click();
    Thread.sleep(3000);

    driver.close();
	}
}


