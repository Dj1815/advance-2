package practice.datadriventesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXmlFileTest {
	@Test
	public void Test(XmlTest xml) {
		System.out.println("execute test");
		
		String Browser=xml.getParameter("browser");
		System.out.println(Browser);
	}

}
