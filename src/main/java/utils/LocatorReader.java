package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LocatorReader {

	public static Properties props = new Properties();
	public static FileReader fr;

	public LocatorReader() throws IOException {
		String user_dir = System.getProperty("user.dir");		
			fr = new FileReader(user_dir + "\\src\\main\\resources\\locators.properties");		
			props.load(fr);			
	}
}
