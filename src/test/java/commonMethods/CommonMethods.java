package commonMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import utils.ReadCongiguration;

public class CommonMethods extends CommonUtilPage{

	static WebDriverWait wait = new WebDriverWait(driver, 40);		

	/**======================================================================
	 * Method to launch url
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static void launchUrl(String url) {
		String urlValue = ReadCongiguration.readConfiguration(url);
		driver.get(urlValue);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}


	/**======================================================================
	 * Method to enter value in a text field
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static void enterValueTextField(String fieldValue, String locatorName) { 
		System.out.println(ReadCongiguration.readObjectRepo(locatorName));
		WebElement textField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ReadCongiguration.readObjectRepo(locatorName)))));
		textField.clear();
		textField.sendKeys(fieldValue);
		textField.sendKeys(Keys.TAB);
		System.out.println("Entered "+fieldValue+" in "+locatorName+" field");		
	}

	/**======================================================================
	 * Method to select drop down with visible text
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static void selectFromDropdownVisibleText(String locatorName, String dropdownValue) {
		WebElement dropdownField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ReadCongiguration.readObjectRepo(locatorName)))));
		Select select = new Select(dropdownField);
		select.selectByVisibleText(dropdownValue);
		System.out.println("Dropdown value "+dropdownValue+" selected for the field "+locatorName);
	}

	/**======================================================================
	 * Method to click on a button
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static void clickOnButton(String locatorName) {
		WebElement buttonField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ReadCongiguration.readObjectRepo(locatorName)))));
		buttonField.click();
		System.out.println("Field "+locatorName+" is clicked");
	}

	/**======================================================================
	 * Method to validate page title
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static void validatePageTitle(String expPageTitle) {
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(expPageTitle, actualPageTitle);
	}
	
	
	/**======================================================================
	 * Method to validate field text
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static void validateFieldText(String fieldName, String expFieldText) {
		WebElement fieldToValidate = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ReadCongiguration.readObjectRepo(fieldName)))));
		String actualFieldText = fieldToValidate.getText();
		Assert.assertEquals(expFieldText, actualFieldText);
	}
}
