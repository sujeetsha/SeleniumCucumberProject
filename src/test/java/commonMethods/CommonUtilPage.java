package commonMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelReader;
import utils.ReadCongiguration;

public class CommonUtilPage {
	static WebDriver driver;
	static List<Map<String, String>> excelData;
	static int row;


	/**======================================================================
	 * Method to initialize the webdriver to desired browser type
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public void initialiseBrowser() throws Exception {	
		String browserName = ReadCongiguration.readConfiguration("browser");
		System.out.println(browserName);
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", ReadCongiguration.userPath+"/src/test/resources/Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			break;
		}
		driver.manage().window().maximize();
	}

	/**======================================================================
	 * Method to close the driver
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public void closeBrowser() {
		driver.close();
	}

	/**======================================================================
	 * Method to return excel data based fileName and sheetName
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static List<Map<String, String>> readExcelFile(String fileName, String sheetName, int rowNumber)throws Exception {
		ExcelReader reader = new ExcelReader();
		excelData = 
				reader.getData(ReadCongiguration.userPath+"/"+fileName, sheetName);
		row = rowNumber;
		return excelData;		
	}
	
	/**======================================================================
	 * Method to read excel data based on column heading
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static String readExcelData(String columnHeading) {
		String cellvalue = excelData.get(row).get(columnHeading);
		return cellvalue;
	}
	
}
