package stepDefinition;

import commonMethods.CommonUtilPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
	
	CommonUtilPage cu = new CommonUtilPage();
	
	@Before
	public void setUp() throws Exception {		
		cu.initialiseBrowser();
	}
	
	@After
	public void tearDown() throws Exception{
		cu.closeBrowser();
	}
	
	
	
}
