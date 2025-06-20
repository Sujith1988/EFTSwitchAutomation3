package dataprovider;

import org.testng.annotations.DataProvider;

public class ArrayDataProvider {


		//data driven testing using the testNG annotation. dataProvider aray setup
		@DataProvider(name = "RCData1")
		public Object[][] createData1() {
			return new Object[][] {
				{ "ATMRC", "spare"},
				{ "EvertecCred", "spare"},
				{ "MdsRC", "spare"},  
				{ "NaiguataRC", "spare"}  
			};
		}
		
		
		
		//data driven testing using the testNG annotation. dataProvider aray setup
		@DataProvider(name = "NodeAppData")
		public Object[][] createData2() {
			return new Object[][] {
				{ "nodApp_form_input_option_POSApp", "nodApp_form_input_option_POSAlpha"},												
				{ "nodApp_form_input_option_ATMApp", "nodApp_form_input_option_ATMAlpha"}  
			};
		}
				
											
				
		//data driven testing using the testNG annotation. dataProvider aray setup
		@DataProvider(name = "NodeAppConctnData")
		public Object[][] createData3() {
			return new Object[][] {
				{ "nodApp_form_input_option_conectn_POSApp", "sap_name_nodeConnctn_POSApp", "sap_ip_nodConnctn_POSApp", "sap_port_nodConnctn_POSApp", "sap_max_no_of_nodConnctn_POSApp"},												
				{ "nodApp_form_input_option_conectn_ATMApp", "sap_name_nodeConnctn_ATMNode", "sap_ip_nodConnctn_ATMNode", "sap_port_nodConnctn_ATMNode", "sap_max_no_of_nodConnctn_ATMNode"}  
			};
		}
		
		
		
		//data driven testing using the testNG annotation. dataProvider aray setup
		@DataProvider(name = "IntrchngData")
		public Object[][] createData4() {
			return new Object[][] {
				{ "option_intrchng_interface_ISOAdapter", "input_intrchng_name_value_ISOAdapter", "option_intrchng_nodType_Alpha", "option_intrchnge_alphanode_SwitchAlpha", "input_interchange_sapName_value_iso", "option_intrchng_conct_typalpha_srvr", "input_interchange_sapIp_alpha_value", "input_interchange_sapPort_alpha_value"},												
				{ "option_intrchng_interface_MDS", "input_intrchng_name_value_MDS_ATM", "option_intrchng_nodType_Omega", "option_intrchnge_omeganode_MDS", "input_interchange_sapName_value_mds", "option_intrchng_conct_typ_omega_client", "input_interchange_sapIp_omega_value", "input_interchange_sapPort_omega_value"}
//				{ "option_intrchng_interface_MDS", "input_intrchng_name_value_MDS_ATM_Test", "option_intrchng_nodType_Omega", "option_intrchnge_omeganode_MDS", "input_interchange_sapName_value_mds_Test", "option_intrchng_conct_typ_omega_client", "input_interchange_sapIp_omega_value", "input_interchange_sapPort_omega_value_Test"}
			};
		}
}
