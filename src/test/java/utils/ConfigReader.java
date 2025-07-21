package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties props = new Properties();
	public static FileReader fr;
	public  String brw;
	public  String url;

	public ConfigReader() throws IOException {
		String user_dir = System.getProperty("user.dir");		
//			fr = new FileReader(user_dir + "\\src\\main\\resources\\config.properties");
			fr = new FileReader(user_dir + "\\src\\test\\resources\\config\\config.properties");	
			props.load(fr);
			
			 brw = props.getProperty("browserName");
			 url = props.getProperty("urlName");
	}
}
