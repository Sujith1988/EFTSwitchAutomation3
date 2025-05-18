package listeners;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class DefaultReporting extends TestListenerAdapter {
  private int m_count =0;
	
	@Override
	public void onTestFailure(ITestResult tr) {			
		//store in index.html
		Reporter.log("the method failed & status are : " + tr.getName() +", " +tr.getStatus());			
		//print on console
		log("failed--- : " +tr.getName());			
	}
	@Override
	public void onTestSkipped(ITestResult tr) {		
		Reporter.log("the method skipped & status are : " + tr.getName() +", " +tr.getStatus());	
		log("skipped--- : " +tr.getName());
	}
	@Override
	public void onTestSuccess(ITestResult tr) {		
		Reporter.log("the method and status are : " + tr.getName() +", " +tr.getStatus());		
		log("won--- : " +tr.getName());
	}
	
//prints on console, but not enter into the index.html file	
private void log(String string) {
	System.out.print(string);
	if (++m_count % 4 == 0) {
	  System.out.println(" # ");
	 }
}

}