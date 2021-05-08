package com.crm.vtiger.genericUtils;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;
/**
 * this class contains java specific libraries
 * @author rohit
 *
 */
public class JavaUtility {
	/**
	 * generate random number
	 * @author rohith
	 * 
	 */
	@Test
	public String getRandomData() {
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	
	/**
	 * generates current system date
	 * @author rohit
	 * @return current date
	 */
	public String getCurrentSystemDate() {
		Date date=new Date();
		String currentDate=date.toString();
		return currentDate;
	}
}
