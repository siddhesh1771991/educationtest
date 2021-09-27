package come.qa.common;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest implements AutoConstant{
	
	 protected WebDriver driver; //Create a global webdriver Interface

	@Parameters("browser") // Here it will pickup the parameters given in XML file

	@BeforeMethod // this will perform befor your test script

	public void open_App(String browser) {

	if(browser.equalsIgnoreCase("chrome"))

	{

	System.out.println("chrome");

	System.setProperty(CH_Key, CH_value );

	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(APP_URL);

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	

	}

	else if (browser.equalsIgnoreCase("firefox"))

	{

	System.out.println("firefox");

	System.setProperty("webdriver.gecko.driver", "./driver/Firefox Installer (1).exe");

	driver=new FirefoxDriver();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.manage().window().maximize();

	}

	else if (browser.equalsIgnoreCase("edge")) {

	System.out.println("edge");

	System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
	driver = new EdgeDriver();

	//driver=new InternetExplorerDriver();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.manage().window().maximize();

	}

	// optional default case

	else {

		System.out.println("IE");

		System.setProperty("http://webdriver.ie.driver", "C:\\Third party softwares\\Selenium\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");

		driver=new InternetExplorerDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	}

	@Test // this your test script

	public void googlesearch()

	{
		
		Xls_Reader xl = new Xls_Reader(Xl_Path);
		String data = xl.getCellData("Sheet1", 1, 0);
		String data2 = xl.getCellData("Sheet1", "Test", 1);
		
		System.out.println(data);
		System.out.println(data2);
   

	}

	@AfterMethod// this will quit your browser after execution

	public void close_App(ITestResult it) {
		String test_name = it.getName();
		int status = it.getStatus();
if (status==1) {
	Reporter.log("Test"+test_name+"is pass",true);
	
} else {
	Reporter.log("Test"+test_name+"is fail/skipp",true);
	System.out.println("fail");
	
	AutoLib.getPhoto(driver, screenshot_Path+test_name+".png");
	

}

	//driver.quit();

	} }


