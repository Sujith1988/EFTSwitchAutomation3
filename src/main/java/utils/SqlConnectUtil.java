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
	
	
	
	
	public static void alphaNodeTableevacuate() throws SQLException {
		Connection con = DriverManager.getConnection(
		"jdbc:sqlserver://localhost; databaseName=Aptswitch;encrypt=true;trustServerCertificate=true; user=sa; password=password@123;");
			System.out.println("connected");
			try {
				Statement st = con.createStatement();
			
				int rowsAffectedsapnodeconnections = st.executeUpdate("DELETE FROM [Aptswitch].[dbo].[apt_sap];");					
				System.out.println("Deleted all rows of node app sap connections from apt_alpha_sap, rows affected: " + rowsAffectedsapnodeconnections);
				
				int rowsAffectednodeapp = st.executeUpdate("DELETE FROM [Aptswitch].[dbo].[apt_node_applications];");		
				System.out.println("Deleted all rows of node apps from apt_node_applications, rows affected: " + rowsAffectednodeapp);
				
				int rowsAffectedInterchangeISO = st.executeUpdate("DELETE FROM [Aptswitch].[dbo].[apt_interchange] where [interface] = 'ISO Adapter';"); 
				System.out.println("Deleted the ISO Adapter interchange from apt_node_interchange, rows affected: " + rowsAffectedInterchangeISO);

				
				int rowsAffectedtcpconnectionalpha = st.executeUpdate("DELETE FROM [Aptswitch].[dbo].[apt_tcp_connections] WHERE \r\n"
						+ "[name] = 'ATMAlpha' or \r\n"
						+ "[name] = 'POSAlpha' or\r\n"
						+ "[name] = 'SwitchAlpha';");						
				System.out.println("Deleted all rows of alphanodes from apt_tcp_connections, rows affected: " + rowsAffectedtcpconnectionalpha);
				
				int rowsAffectedalphanode = st.executeUpdate("DELETE FROM [Aptswitch].[dbo].[apt_alpha_node] WHERE \r\n"
						+ "[alpha_node] = 'ATMAlpha' or \r\n"
						+ "[alpha_node] = 'POSAlpha' or\r\n"
						+ "[alpha_node] = 'SwitchAlpha';");						
				System.out.println("Deleted all rows of alphanodes from apt_alpha_node, rows affected: " + rowsAffectedalphanode);
				
				
				
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