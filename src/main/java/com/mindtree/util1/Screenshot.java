package com.mindtree.util1;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;



public class Screenshot {
	static Logger log = Logger.getLogger(Screenshot.class);
	static int i=1;
	public  static String getScreenShot(WebDriver driver,String name)
	{
		
		String dest="D:\\workspace1\\HybridNetworkFramework\\Screenshots\\"  +name+i +".png";
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
			Files.copy(screenshotFile,  new File(dest));
		}
    	catch (IOException e) {
			log.error("Problem in Capturing Screenshot");
			
		}
    	i++;
    	log.info("Screenshot captured");
		return dest;
    	
	}
		

}
