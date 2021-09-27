package come.qa.common;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoLib {
	
	public static void getPhoto (WebDriver driver,String path) {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File (path);
		try {
			FileUtils.copyDirectory(src, dest);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
