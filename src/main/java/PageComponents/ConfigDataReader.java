package PageComponents;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class ConfigDataReader {
	Properties props = new Properties();

	public ConfigDataReader() {
		File src = new File("./resources/configData.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			props.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file " + e.getMessage());
		}
	}
	
	
	public String getBrowser() {return System.getProperty("browser")!=null?System.getProperty("browser"):props.getProperty("browser");}
	
	public String getUrl() { return props.getProperty("url");}
	
	
}
