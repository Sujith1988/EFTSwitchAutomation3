package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnectUtil {

	public static void binTableevacuate() throws SQLException {
	Connection con = DriverManager.getConnection(
	"jdbc:sqlserver://localhost; databaseName=Aptswitch;encrypt=true;trustServerCertificate=true; user=sa; password=password@123;");
		System.out.println("connected");
		try {
			Statement st = con.createStatement();
		
			int rowsAffectedVisaBins = st.executeUpdate("DELETE FROM [Aptswitch].[dbo].[apt_bins] WHERE \r\n"
					+ "[routing_category] = 'ATMRC' or \r\n"
					+ "[routing_category] = 'MdsRC' or\r\n"
					+ "[routing_category] = 'EvertecCredRC' or\r\n"
					+ "[routing_category] = 'NaiguatRC' or\r\n"
					+ "[routing_category] = 'VisaRC';");
			System.out.println("Deleted all rows of all CG-BINs, rows affected: " + rowsAffectedVisaBins);
			
			ResultSet rs = st.executeQuery("SELECT * FROM [Aptswitch].[dbo].[apt_bins] WHERE \r\n"
					+ "[routing_category] = 'ATMRC' or \r\n"
					+ "[routing_category] = 'MdsRC' or\r\n"
					+ "[routing_category] = 'EvertecCredRC' or\r\n"
					+ "[routing_category] = 'NaiguatRC' or\r\n"
					+ "[routing_category] = 'VisaRC';");
			 while(rs.next())
			    {
			    	System.out.println("Available Bins: " +rs.getString(1));
			    }
			 
			st.close();

			// ...
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
					System.out.println("connection closed");
				} catch (Exception e) {
				}
		}

	}

}