package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;



public class ReadCongiguration {
	
	static Properties properties = new Properties();
	public static String userPath = System.getProperty("user.dir");
	
	/**======================================================================
	 * Method to Read the .properties configuration file key and return the value
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static String readConfiguration(String key) {
		try {
			InputStream input = new FileInputStream(userPath+"/src/test/java/utils/configuration.properties");
			properties.load(input);
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Error: "+exception.getMessage());
		}
		return properties.getProperty(key);
	}
	
	/**======================================================================
	 * Method to Read the .properties file to read object repository
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static String readObjectRepo(String key) {
		try {
			InputStream input = new FileInputStream(userPath+"/src/test/java/objectRepository/ObjectRepo.properties");
			properties.load(input);
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Error: "+exception.getMessage());
		}
		return properties.getProperty(key);
	}
	
	
	
	/**======================================================================
	 * Method to write values back to .properties file
	 * @author: Sujeet Shanbhag
	 *=======================================================================*/
	public static void writeConfiguration(String key, String value) {
		try {
			OutputStream output = new FileOutputStream(userPath+"/src/test/java/utils/configuration.properties");
			properties.setProperty(key, value);
			properties.store(output, "Values written back in config file");
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Error: "+exception.getMessage());
		}
		
	}
}
