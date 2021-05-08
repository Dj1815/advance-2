package practice.datadriventesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateCustomerTest {
	
	@Test
	
	public void createCustomer(XmlTest xml) {
		
		String userName=System.getProperty("username");
		System.out.println("===========>"+userName);
		
	}

}
