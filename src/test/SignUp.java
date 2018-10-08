package test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;




public class SignUp {
	
	WebDriver driver;
	
	//Before Test
	  public void setUp() throws InterruptedException
	  {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true); 
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\eclipse\\chromedriver_win32\\chromedriver.exe");		
		driver = new ChromeDriver(capabilities);
		
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
		}

		public ArrayList<String> readExcelData(int colNo) throws Exception
		{
			FileInputStream fis = new FileInputStream("D:\\Testing\\TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet s = wb.getSheet("Sheet1");
			Iterator <Row> row = s.iterator();
			row.next();
			ArrayList<String> list = new ArrayList <String>();
			while (row.hasNext())
			{
				list.add(row.next().getCell(colNo).getStringCellValue().toString());
			}
			
			return list;
		}
	//Test SignUp process
		public void testSignUp() throws Exception
		{
		ArrayList<String> FName = readExcelData(0);
		ArrayList<String> LName = readExcelData(1);
		ArrayList<String> Email = readExcelData(2);
		ArrayList<String> ConEmail = readExcelData(3);
		ArrayList<String> Password = readExcelData(4);
		
		for (int i=3;i<FName.size();i++)
		{
		driver.findElement(By.id("u_0_j")).sendKeys(FName.get(i));
		Thread.sleep(3000);
		driver.findElement(By.id("u_0_l")).sendKeys(LName.get(i));
		Thread.sleep(3000);
		driver.findElement(By.id("u_0_o")).sendKeys(Email.get(i));
		Thread.sleep(3000);
		driver.findElement(By.id("u_0_r")).sendKeys(ConEmail.get(i));
		Thread.sleep(3000);
		driver.findElement(By.id("u_0_v")).sendKeys(Password.get(i));
		Thread.sleep(3000);
		Select sel1 = new Select(driver.findElement(By.id("day"))); 
		sel1.selectByValue("22");
		Thread.sleep(3000);
		Select sel2 = new Select(driver.findElement(By.id("month"))); 
		sel2.selectByValue("4");
		Thread.sleep(3000);
		Select sel3 = new Select(driver.findElement(By.id("year"))); 
		sel3.selectByValue("1995");
		Thread.sleep(3000);
		driver.findElement(By.className("_5k_2 _5dba").name("sex")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("u_0_11")).click();  //Sign up
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"js_0\"]/div/div/div[2]/div/div/a")).click(); 
		Thread.sleep(9000);
		Login();
		}
		}
		
		
	//Test Login process
		public void Login() throws Exception
		{
			
			ArrayList<String> email = readExcelData(2);
			ArrayList<String> password = readExcelData(4);
			for (int i=3; i< email.size();i++)
			{
			driver.findElement(By.id("email")).sendKeys(email.get(i));
			Thread.sleep(3000);
			driver.findElement(By.id("pass")).sendKeys(password.get(i));
			Thread.sleep(3000);
			driver.findElement(By.id("loginbutton")).click(); //login
			driver.findElement(By.id("userNavigationLabel")).click();
			Thread.sleep(9000);
			driver.findElement(By.cssSelector("a[href='https://www.facebook.com/settings']")).click();
			Thread.sleep(9000);
			driver.findElement(By.cssSelector("a[href='/settings?tab=account&section=account_management']")).click(); 
			Thread.sleep(9000);
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,450)");
			Thread.sleep(6000);
			driver.findElement(By.cssSelector("a[href=\"/deactivate/\"]")).click();
			Thread.sleep(9000);
			//jsx.executeScript("window.scrollBy(0,450)");
			//Thread.sleep(6000);
			List<WebElement> radio = driver.findElements(By.className("_13ll").name("reason"));
			for ( i=0;i<radio.size();i++)
			{
				WebElement localRadio = radio.get(i);
				String value = localRadio.getAttribute("value");
				if (value.equalsIgnoreCase("OTHERACCOUNTS"))
				{
					localRadio.click();
				}
			}
			Thread.sleep(6000);
			driver.findElement(By.className("_42ft _4jy0 _4jy3 _4jy1 selected _51sy").name("submit")).click();
			Thread.sleep(6000);
			driver.findElement(By.cssSelector("button[type ='submit']")).click();
			Thread.sleep(9000);

			driver.findElement(By.xpath("//button[contains(text(),'Deactivate Now')]")).click();
			
			}
			
		}
		
		
	//AfterTest
	public void closing()
		{
		driver.close();
		}
		
		
		public static void main(String[] args) throws Exception {
			
			SignUp s1 = new SignUp();
			s1.setUp();
			s1.testSignUp();
			s1.closing();
			
		}

	}


