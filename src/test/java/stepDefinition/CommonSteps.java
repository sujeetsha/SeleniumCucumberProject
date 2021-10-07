package stepDefinition;

import commonMethods.CommonMethods;
import commonMethods.CommonUtilPage;
import io.cucumber.java.en.*;

public class CommonSteps {		

	@Given("user has launched {string} page")
	public void user_has_launched_page(String url) {
		CommonMethods.launchUrl(url);
	}

	@When("user enters {string} in field {string}")
	public void user_enters_in_field(String fieldValue, String fiedlName) {
		String excelFielValue = CommonUtilPage.readExcelData(fieldValue);
		CommonMethods.enterValueTextField(excelFielValue, fiedlName);
	}
	
	@When("user enters {string} in field {string} using example")
	public void user_enters_in_fieldUsingExample(String fieldValue, String fiedlName) {
		CommonMethods.enterValueTextField(fieldValue, fiedlName);
	}

	@When("user clicks {string}")
	public void user_clicks(String fieldName) {
		CommonMethods.clickOnButton(fieldName);
	}

	@Then("validate page title contains {string}")
	public void validate_page_title_contains(String expPageTitle) {
		CommonMethods.validatePageTitle(expPageTitle);
	}

	@Then("validate field {string} contains text {string}")
	public void validateFieldText(String fieldName, String expFieldText) {

	}

	@When("user fills the form from given filename {string}, sheetname {string} and rownumber {int}")
	public void getExcelFileDetails(String fileName, String sheetName, int rowNumber) {
		try {
			CommonUtilPage.readExcelFile(fileName, sheetName, rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
