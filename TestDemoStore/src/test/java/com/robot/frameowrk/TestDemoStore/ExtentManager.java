/**
 * 
 */
package com.robot.frameowrk.TestDemoStore;

import com.relevantcodes.extentreports.ExtentReports;

/** 
* ------- ExtentManager -------
* Author: QA-DART
* Created on: Feb 27, 2017
* History of Changes:
*/
public class ExtentManager {

	
	static ExtentReports extent;
    final static String filePath = "C:\\NewExtentReports\\TestAutomationReport.html";
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
        }
        
        return extent;
    }
}
