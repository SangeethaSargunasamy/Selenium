package Selpackage1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven {

	private static final XSSFSheet Sheet1 = null;

	public static void main(String[] args) throws IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\inc2013\\Documents\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
				
				driver.get("http://192.168.2.167:82/taf/login");

				driver.manage().window().maximize();
				
				FileInputStream fios=new FileInputStream("C:\\Users\\INC2013\\Documents\\Vijay.xlsx");
				//C:\Users\inc2013\Documents
				
				XSSFWorkbook wb=new XSSFWorkbook(fios);
				
				XSSFSheet Sheet=wb.getSheet("Sheet1");
				
				int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
				
				System.out.println("rowcount="+rowCount);
				int noOfColumns = Sheet.getRow(0).getPhysicalNumberOfCells();
				System.out.println("columncount="+noOfColumns);
				
				String ExpectedTitle="Accounts - Select Company";
				
				for(int i=1;i<=rowCount;i++)
				{
					for (int j=0;j<noOfColumns;j++)
					{
						
						Row row1=Sheet.getRow(i);
						Cell cell=row1.getCell(j);
						Cell cell1=row1.getCell(++j);
						String r=cell.getStringCellValue();
						String r1=cell1.getStringCellValue();
						Thread.sleep(3000);
						driver.findElement(By.id("email")).sendKeys(r);
						driver.findElement(By.id("password")).sendKeys(r1);
						Thread.sleep(3000);
						driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div[4]/button")).click();
						Thread.sleep(3000);
						String actualtitle=driver.getTitle();
						if(ExpectedTitle.equals(actualtitle))
						{
							System.out.println("Login Sucessfully for user name =" +r+"\tPassword = "+r1 );
							driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div[3]/a")).click();
							
						}
						else
						{
							System.out.println("Login failed for user name =" +r+"\tPassword = "+r1 );
							
						}
						
						
						
						
						
						
						
					}
				}

				driver.close();
		        
	}
}
