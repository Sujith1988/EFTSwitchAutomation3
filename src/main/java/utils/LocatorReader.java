package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LocatorReader {

	public static Properties props = new Properties();
	public static FileReader fr;
	public static int wnd_delay;
	public static int pag_delay;
	public static int slp_1;
	public static int slp_2;
	
	public static String usr;
	public static String psw;
	public static String btn;

	public LocatorReader() throws IOException {
		String user_dir = System.getProperty("user.dir");		
			fr = new FileReader(user_dir + "\\src\\main\\resources\\locators.properties");		
			props.load(fr);
			
			wnd_delay = Integer.parseInt(props.getProperty("windo_timeout"));
			pag_delay = Integer.parseInt(props.getProperty("pag_load_wait"));
			slp_1 = Integer.parseInt(props.getProperty("sleep_1"));
			slp_2 = Integer.parseInt(props.getProperty("sleep_2"));
			
			usr = props.getProperty("usr_name");
			psw = props.getProperty("pas_word");
			btn = props.getProperty("login_button");
	}
}
