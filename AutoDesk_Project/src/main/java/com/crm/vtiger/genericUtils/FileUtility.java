package com.crm.vtiger.genericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



/**
 * used to read the data from property file and return the value based on key
 * @author rohit
 *
 */
public class FileUtility implements IPathConstant  {
	
	public String getPropertyValue(String key) throws IOException {
		FileInputStream fin=new FileInputStream(PROPERTY_FILEPATH);
		Properties prop=new Properties();
		prop.load(fin);
		return prop.getProperty(key);
	}
	
	public String getDatafromJason(String jsonKey) throws Throwable {
		FileReader reader = new FileReader(IPathConstant.JSON_FILEPATH);
		JSONParser parser = new JSONParser();
		Object object = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) object;
		String value = jsonObject.get(jsonKey).toString();
		return value;

	}

}
