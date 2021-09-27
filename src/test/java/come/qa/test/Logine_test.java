package come.qa.test;

import org.testng.annotations.Test;

import come.qa.common.BaseTest;
import come.qa.pages.Loginepage;

public class Logine_test extends BaseTest{
	
@Test
	public void validlogine() {
		
	Loginepage logine = new Loginepage(driver);
	}

}
