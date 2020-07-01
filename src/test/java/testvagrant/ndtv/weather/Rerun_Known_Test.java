package testvagrant.ndtv.weather;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerun_Known_Test implements IRetryAnalyzer {

	int minCont = 0, maxCount = 3;

	public boolean retry(ITestResult result) {
		while (minCont<maxCount) {
			minCont ++ ;
			return true;
		}
		return false;
	}
	
}
